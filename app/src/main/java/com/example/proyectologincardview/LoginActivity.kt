package com.example.proyectologincardview

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.proyectologincardview.databinding.ActivityLoginBinding

class LoginActivity: AppCompatActivity() {
    private lateinit var bindingLoginBinding: ActivityLoginBinding
    private lateinit var editTextCorreo : EditText
    private lateinit var editTextPassword : EditText
    private lateinit var buttonValidar : ImageButton

    private val MYUSER = "maria@gmail.com"
    private val MYPASS = "maria"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        bindingLoginBinding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(bindingLoginBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(bindingLoginBinding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editTextCorreo = bindingLoginBinding.editTextEmail
        editTextPassword = bindingLoginBinding.editTextPassword
        buttonValidar = bindingLoginBinding.buttonValidar

        initEvent()
    }

    //Método para validar si el correo y la contraseña es correcta.
    //En caso de ser correcta al pulsar el botón irá al activity principal
    //En caso de no ser correcto saldrá un mensaje
    private fun initEvent() {
        buttonValidar.setOnClickListener {
            val username = bindingLoginBinding.editTextEmail.text.toString()
            val password = bindingLoginBinding.editTextPassword.text.toString()

            if (username == MYUSER && password == MYPASS) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            } else {
                Toast.makeText(this, "El usuario o la contraseña es incorrecta", Toast.LENGTH_SHORT).show()
            }
        }
    }
}