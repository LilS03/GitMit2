package com.example.authentication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.authentication.R

class AuthFragment : Fragment() {
    private val viewModel: AuthViewModel by viewModels { AuthViewModel.Factory }
    private lateinit var etToken: EditText
    private lateinit var btnLogIn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_auth, container, false)
        etToken = view.findViewById(R.id.etToken)
        btnLogIn = view.findViewById(R.id.btnLogin)

        btnLogIn.setOnClickListener {
            val token = etToken.text.toString()
            viewModel.checkGitHubToken(token)
        }

        viewModel.tokenStatus.observe(viewLifecycleOwner) { isValid ->
            if (isValid) {
                Toast.makeText(context, "Token is valid!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Invalid token!", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}

