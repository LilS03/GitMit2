package com.example.authentication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.authentication.R
import com.example.authentication.data.utils.SharedPreferencesHelper

class AuthFragment : Fragment() {

    private lateinit var etToken: EditText
    private lateinit var btnLogIn: Button
    private lateinit var sharedPreferencesHelper: SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)

        etToken = view.findViewById(R.id.etToken)
        btnLogIn = view.findViewById(R.id.btnLogin)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())

        btnLogIn.setOnClickListener {
            val token = etToken.text.trim().toString()
            if (token.isNotEmpty()) {
                sharedPreferencesHelper.saveToken(token)
                //openActivity()
            } else {
                etToken.error = "Token cannot be empty"
            }
        }

        return view
    }

    // in this case i will open another activity
//    private fun openActivity() {
//        val intent = Intent(activity, Activity::class.java)
//        startActivity(intent)
//        activity?.finish()
//    }
}
