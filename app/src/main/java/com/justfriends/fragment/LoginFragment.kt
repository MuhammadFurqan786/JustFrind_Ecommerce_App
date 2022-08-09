package com.justfriends.fragment

import android.app.Dialog
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
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginBehavior
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.util.CollectionUtils.listOf
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.justfriends.NavGraphDirections
import com.justfriends.R
import com.justfriends.databinding.FragmentLoginBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.PrefKeys
import com.justfriends.viewModel.AuthViewModel
import com.kakao.sdk.user.UserApiClient
import java.util.*


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private val authViewModel: AuthViewModel by viewModels()
    private var helper: PreferenceHelper? = null
    private var mIMainActivity: IMainActivity? = null
    private lateinit var callbackManager: CallbackManager
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private var deviceID = UUID.randomUUID().toString()
    private var show = true
    private lateinit var firebaseAuth: FirebaseAuth

    val Req_Code: Int = 123


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        FirebaseApp.initializeApp(requireContext())
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.server_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
        firebaseAuth = FirebaseAuth.getInstance()

        callbackManager = CallbackManager.Factory.create()
        return binding.root
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
        ss.setSpan(clickableSpan, 11, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        ss.setSpan(ForegroundColorSpan(Color.WHITE), 11, 15, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
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
            mIMainActivity?.getPreference()
                ?.saveStringValue(PrefKeys.KEY_USER_TOKEN, it.token)
            Log.d("TOKEN___________", it.token)

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
//                getUserInfo()
                showDialogue()
            }
        }


    }

    private fun showDialogue() {
        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_dialogue_email)
        val body = dialog.findViewById(R.id.et_email) as EditText
        val yesBtn = dialog.findViewById(R.id.btnPositive) as Button
        val noBtn = dialog.findViewById(R.id.btnNegative) as Button
        yesBtn.setOnClickListener {
            var email = body.text.toString()
            if (email.isNotEmpty()) {
                getUserInfo(email)
            } else {
                Log.d("TAG", "empty")
            }
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }

    fun getUserInfo(email: String) {
        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "Retrieving user information fails.", error)
            } else if (user != null) {
                val scopes = mutableListOf<String>()

                if (user.kakaoAccount?.emailNeedsAgreement == true) {
                    scopes.add("account_email")
                    Log.d(TAG, "getUserInfo: $scopes.add(\"account_email\")")
                }
                if (user.kakaoAccount?.birthdayNeedsAgreement == true) {
                    scopes.add("birthday")
                }
                if (user.kakaoAccount?.genderNeedsAgreement == true) {
                    scopes.add("gender")
                }
                if (user.kakaoAccount?.profileNeedsAgreement == true) {
                    scopes.add("profile_nickname")
                    scopes.add("profile_image")
                }
                val name = user.kakaoAccount?.profile?.nickname
                val profileImg = user.kakaoAccount?.profile?.profileImageUrl
                authViewModel.socialLogin(
                    email = email ?: "",
                    password = "",
                    name = name ?: "",
                    countryCode = "",
                    mobile = "",
                    userImg = profileImg ?: "",
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

    fun logoutKakao() {
        // Logout
        UserApiClient.instance.logout { error ->
            if (error != null) {
                Log.e(TAG, "Logout fail. Tokens are deleted from SDK", error)
            } else {
                Log.i(TAG, "Logout success. Tokens are deleted from SDK")
            }
        }
    }

    private fun logInGoogle() {
        val signInIntent: Intent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, Req_Code)
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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == Req_Code) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleResult(task)
        }else
        {
            callbackManager.onActivityResult(requestCode,resultCode, data)
        }
    }

    private fun handleResult(task: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            if (account != null) {
                UpdateUI(account)
            }
        } catch (e: ApiException) {
            Log.w(TAG, "signInResult:failed code=" + e.statusCode)
        }
    }

    private fun UpdateUI(account: GoogleSignInAccount) {
        Log.println(Log.VERBOSE, "GMAILLL USERID>>>>>>", account.id.toString())
        val email = account.email
        val gmailId = account.id
        val firstName = account.givenName
        val lastName = account.familyName
        val image = account.photoUrl?.toString()
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