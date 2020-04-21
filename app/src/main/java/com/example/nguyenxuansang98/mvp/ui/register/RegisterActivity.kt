package com.example.nguyenxuansang98.mvp.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.nguyenxuansang98.mvp.R
import com.example.nguyenxuansang98.mvp.data.db.model.Profile
import com.example.nguyenxuansang98.mvp.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(),RegisterContract.View {

    private var registerPresenter : RegisterPresenter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerPresenter = RegisterPresenter(this)
        button_register_ok.setOnClickListener {
            var profile = Profile(edittext_username_register.text.toString(),
                                  edittext_password_register.text.toString(),
                                  edittext_email_register.text.toString(),
                                  edittext_url_register.text.toString())
            registerPresenter!!.handleRegister(this,profile)
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    override fun onRegisterBlankError() {
        Toast.makeText(this,"Các trường không được bỏ trống", Toast.LENGTH_LONG).show()
    }
}
