package com.example.authentication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.authentication.R

class AuthFragment : Fragment() {
    private lateinit var viewModel: AuthViewModel
    private lateinit var token: EditText
    private lateinit var logIn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        initViews(view)
    }
    private fun initViews(view: View) {
        token = view.findViewById(R.id.etToken)
        logIn = view.findViewById(R.id.btnLogin)
    }

}