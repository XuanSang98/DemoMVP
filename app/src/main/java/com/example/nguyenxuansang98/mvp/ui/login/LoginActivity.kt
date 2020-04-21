package com.example.nguyenxuansang98.mvp.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import com.example.nguyenxuansang98.mvp.R
import com.example.nguyenxuansang98.mvp.data.db.model.Profile
import com.example.nguyenxuansang98.mvp.ui.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginPresenter = LoginPresenter(this)
        button_register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        button_login.setOnClickListener {
            loginPresenter.handleLogin(
                this,
                edittext_email_login.text.toString(),
                edittext_password_login.text.toString()
            )
        }
    }

    override fun onLoginSuccess() {
        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show()
    }

    override fun onLoginFailure() {
        Toast.makeText(this, "Email hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show()
    }

    override fun onLoginBlankError() {
        Toast.makeText(this, "Email hoặc password không được bỏ trống", Toast.LENGTH_LONG).show()
    }
}
