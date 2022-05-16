package com.justfriends.fragment

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.LinkMovementMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.facebook.*
import com.facebook.login.LoginBehavior
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.Scopes
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.google.android.gms.tasks.Task
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.databinding.FragmentLoginBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.preference.PreferenceKeys
import com.justfriends.viewModel.AuthViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.auth.model.Prompt
import com.kakao.sdk.user.UserApiClient
import java.util.*


private const val RC_SIGN_IN = 7

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val authViewModel: AuthViewModel by viewModels()
    private var helper: PreferenceHelper? = null
    private var mIMainActivity: IMainActivity? = null
    private lateinit var callbackManager: CallbackManager
    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private var deviceID = UUID.randomUUID().toString()
    private var show = true


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), createGoogleSinInOptions())
        callbackManager = CallbackManager.Factory.create()
        return binding.root
    }

    private fun createGoogleSinInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder()
            .requestServerAuthCode(getString(R.string.server_client_id))
            .requestIdToken(getString(R.string.server_client_id))
            .requestEmail()
            .requestProfile()
            .requestScopes(Scope(Scopes.EMAIL))
            .requestScopes(Scope(Scopes.PROFILE))
            .requestScopes(Scope(Scopes.PLUS_ME))
            .build()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        setUpObserver()
        setSpannable()
    }

    private fun setSpannable() {
        val ss = SpannableString(getString(R.string.don_t_have_an_account_signup))
        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                val direction = LoginFragmentDirections.actionNavLoginFragmentToNavSignUpFragment()
                findNavController().navigate(direction)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        ss.setSpan(clickableSpan, 23, 28, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(ForegroundColorSpan(Color.WHITE), 23, 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.tvSignUp.text = ss
        binding.tvSignUp.text = ss
        binding.tvSignUp.movementMethod = LinkMovementMethod.getInstance()
        binding.tvSignUp.highlightColor = Color.TRANSPARENT
    }

    private fun setUpObserver() {
        authViewModel.getProgressObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showProgress(it)
        }
        authViewModel.getMessageObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.showMessage(it)
        }
        authViewModel.getLoginObserver.observe(viewLifecycleOwner) {
            mIMainActivity?.getPreference()?.saveCurrentUser(it.data)
            mIMainActivity?.getPreference()?.saveStringValue(PreferenceKeys.KEY_USER_TOKEN, it.token)
            val direction = NavGraphDirections.actionGlobalNavHomeFragment()
            findNavController().navigate(direction)
        }

    }

    private fun setUpListener() {
        binding.ivEye.setOnClickListener {
            if (show) {
                binding.etPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
                binding.ivEye.setImageResource(R.drawable.ic_hide)
                show = false
            } else {
                binding.etPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
                binding.ivEye.setImageResource(R.drawable.show)
                show = true
            }
        }


        binding.tvForgotPassword.setOnClickListener {
            val direction = LoginFragmentDirections.actionNavLoginFragmentToForgotPasswordFragment()
            findNavController().navigate(direction)
        }


        binding.btLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            authViewModel.login(email, password)
        }

        binding.btFacebook.setOnClickListener {
            logInFacebook()
        }

        binding.btGoogle.setOnClickListener {
            logInGoogle()
        }

        binding.btKakao.setOnClickListener {
            logInKakao()
        }
    }

    private fun logInKakao() {

        UserApiClient.instance.loginWithKakaoAccount(requireContext()) { token, error ->
            Log.d(TAG, "logInKakao: token = $token\nerror = ${error?.localizedMessage}")
            if (error != null) {
                Log.e(TAG, "Login fail", error)
            } else if (token != null) {
                Log.i(TAG, "Login success ${token.accessToken}")
                getUserInfo()
            }
        }


    }

    fun getUserInfo(){
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "Retrieving user information fails.", error)
            }
            else if (user != null) {
                val scopes = mutableListOf<String>()

                 if (user.kakaoAccount?.emailNeedsAgreement == true) {
                    scopes.add("account_email")
                    Log.d(TAG, "getUserInfo: $scopes.add(\"account_email\")")
                }
                if (user.kakaoAccount?.birthdayNeedsAgreement == true) {
                    scopes.add("birthday")
                }
                if (user.kakaoAccount?.birthyearNeedsAgreement == true) {
                    scopes.add("birthyear")
                }
                if (user.kakaoAccount?.genderNeedsAgreement == true) {
                    scopes.add("gender")
                }
                if (user.kakaoAccount?.phoneNumberNeedsAgreement == true) {
                    scopes.add("phone_number")
                }
                if (user.kakaoAccount?.profileNeedsAgreement == true) {
                    scopes.add("profile")
                }
                if (user.kakaoAccount?.ageRangeNeedsAgreement == true) {
                    scopes.add("age_range")
                }
                if (user.kakaoAccount?.ciNeedsAgreement == true) {
                    scopes.add("account_ci")
                }
                val name = user.kakaoAccount?.profile?.nickname
                val profileImg = user.kakaoAccount?.profile?.profileImageUrl
                val email = user.kakaoAccount?.email
                authViewModel.socialLogin(
                    email = email?:"",
                    password = "",
                    name = name?:"",
                    countryCode = "",
                    mobile = "",
                    userImg = profileImg?:"",
                    gmail = "",
                    facebook = "",
                    token = "",
                    deviceType = "",
                    deviceId = deviceID,
                    platform = "kakao",
                    latitude = "",
                    longitude = "",
                    isActive = "1"
                )

               /* if (scopes.count() > 0) {
                    Log.d(TAG, "Need to obtain consent from user.")

                    UserApiClient.instance.loginWithNewScopes(
                        requireContext(),
                        scopes
                    ) { token, error ->
                        if (error != null) {
                            Log.e(TAG, "Obtaining additional consent fails.", error)
                        } else {
                            Log.d(TAG, "allowed scopes: ${token!!.scopes}")

                            // Re-request user information
                            UserApiClient.instance.me { user, error ->
                                if (error != null) {
                                    Log.e(TAG, "Retrieving user information fails.", error)
                                } else if (user != null) {
                                    Log.i(TAG, "Retrieving user information succeeds.")
                                }
                            }
                        }
                    }
                }*/
            }
        }
    }

    fun logoutKakao(){
        // Logout
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e(TAG, "Logout fail. Tokens are deleted from SDK", error)
            }
            else {
                Log.i(TAG, "Logout success. Tokens are deleted from SDK")
            }
        }
    }

    private fun logInGoogle() {
        mGoogleSignInClient.signOut()
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    private fun logInFacebook() {
        LoginManager.getInstance().logOut()
        LoginManager.getInstance().loginBehavior = LoginBehavior.WEB_ONLY
        LoginManager.getInstance()
            .logInWithReadPermissions(this, listOf("email", "public_profile"))
        LoginManager.getInstance()
            .registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
                override fun onSuccess(loginResult: LoginResult?) {
                    loginResult?.let {
                        val facebookAccessToken = it.accessToken
                        val graphRequest = GraphRequest.newMeRequest(
                            facebookAccessToken
                        ) { `object`, response ->
                            val fbId = `object`.optString("id")
                            Log.d(TAG, "++++++++++++++++++++: $fbId")
                            var email = `object`.optString("email")
                            Log.d(TAG, "_________________: $email")
                            val name =
                                `object`.optString("first_name") + " " + `object`.optString("last_name")
                            if (email.isEmpty()) email = ""
                            Log.d(TAG, "*****************: $name")
                            val url = "http://graph.facebook.com/$fbId/picture?type=large"

                            Log.d(TAG, "onSuccess: FbId = $fbId")

                            authViewModel.socialLogin(
                                email = email,
                                password = "",
                                name = name,
                                countryCode = "",
                                mobile = "",
                                userImg = url,
                                gmail = "",
                                facebook = fbId,
                                token = "",
                                deviceType = "",
                                deviceId = deviceID,
                                platform = "Facebook",
                                latitude = "",
                                longitude = "",
                                isActive = "1"
                            )
                        }

                        val parameters = Bundle()
                        parameters.putString(
                            "fields",
                            "id, first_name, last_name, email,gender, birthday, location"
                        )
                        graphRequest.parameters = parameters
                        graphRequest.executeAsync()
                    }
                }


                override fun onCancel() {
                    Log.v("LoginScreen", "---onCancel");
                    // App code
                }

                override fun onError(exception: FacebookException) {
                    // App code
                    Log.println(Log.ERROR, "USERID>>>>>>", exception.toString())
                }
            })
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            Log.println(Log.VERBOSE, "GMAILLL USERID>>>>>>", account?.id.toString())
            val email = account?.email
            val gmailId = account?.id
            val firstName = account?.givenName
            val lastName = account?.familyName
            val image = account?.photoUrl?.toString()
            if (email != null) {
                if (gmailId != null) {
                    val name = firstName.plus(" ").plus(lastName)
                    authViewModel.socialLogin(
                        email, "", name, "", "",
                        image.toString(), gmailId, "", "", deviceID, "Gmail", "", "", "",
                        "1"
                    )
                }
            }
        } catch (e: ApiException) {
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        } else {
            callbackManager.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mIMainActivity = context as IMainActivity
    }

    override fun onDetach() {
        super.onDetach()
        mIMainActivity = null
    }

}