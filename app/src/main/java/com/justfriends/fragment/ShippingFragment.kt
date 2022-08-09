package com.justfriends.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.facebook.CallbackManager
import com.facebook.FacebookSdk.getApplicationContext
import com.google.gson.JsonObject
import com.iamport.sampleapp.ui.PaymentActivity
import com.justfriends.activity.MainActivity
import com.justfriends.databinding.ActivityShippingBinding
import com.justfriends.interfaces.IMainActivity
import com.justfriends.model.AddressResModel
import com.justfriends.network.GetDateService
import com.justfriends.network.RetrofitClientInstance.retrofitInstance
import com.justfriends.preference.PreferenceHelper
import com.justfriends.utils.PrefKeys
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ShippingFragment : Fragment() {
    lateinit var binding: ActivityShippingBinding
    private var helper: PreferenceHelper? = null
    private var mIMainActivity: IMainActivity? = null
    private lateinit var callbackManager: CallbackManager
    lateinit var token: String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityShippingBinding.inflate(inflater, container, false)
        helper = PreferenceHelper.getPref(requireContext())
        token = helper!!.getStringValue(PrefKeys.KEY_USER_TOKEN).toString()



        callbackManager = CallbackManager.Factory.create()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setUpListener()
    }


    private fun setUpListener() {

        binding.btContinue.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val address = binding.etAddress.text.toString().trim()
            val addressName = binding.etAddress.text.toString().trim()
            val mobile = binding.etPhone.text.toString().trim()
            val house = binding.etHouseNumber.text.toString().trim()
            val city = binding.etCity.text.toString().trim()
            val area = binding.etArea.text.toString().trim()
            val state = binding.etState.text.toString().trim()
            val pinCode = binding.etPinCode.text.toString().trim()
            newAddress(
                token,
                name,
                mobile,
                address,
                house,
                addressName,
                pinCode,
                city,
                area,
                state
            )
        }
    }

    private fun newAddress(
        s: String,
        name: String,
        mobile: String,
        address: String,
        house: String,
        addressName: String,
        pinCode: String,
        city: String,
        area: String,
        state: String
    ) {
        val body = JsonObject()
        body.addProperty("name", name)
        body.addProperty("phone_number", mobile)
        body.addProperty("address", address)
        body.addProperty("address_name", addressName)
        body.addProperty("house_number", house)
        body.addProperty("area", area)
        body.addProperty("pincode", pinCode)
        body.addProperty("city", city)
        body.addProperty("state", state)


        val service = retrofitInstance!!.create(
            GetDateService::class.java
        )
        service.addNewAddress(s, body)?.enqueue(object : Callback<AddressResModel?> {
            override fun onResponse(
                call: Call<AddressResModel?>?,
                response: Response<AddressResModel?>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(context, "주소가 저장됨", Toast.LENGTH_SHORT)
                        .show()

                    val intent = Intent(context, PaymentActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        context,
                        "" + response.body()!!.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<AddressResModel?>?, t: Throwable) {
                Toast.makeText(context, "" + t.message, Toast.LENGTH_SHORT).show()
            }
        })


    }
}