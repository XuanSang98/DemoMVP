package com.example.nguyenxuansang98.mvp.ui.login

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.nguyenxuansang98.mvp.data.db.AppDbHelper
import com.example.nguyenxuansang98.mvp.data.db.model.Profile
import com.example.nguyenxuansang98.mvp.ui.profile.ProfileActivity

class LoginPresenter(val view: LoginContract.View) : LoginContract.Presenter {

    companion object {
        lateinit var profile: Profile
    }

    lateinit var database: AppDbHelper

    override fun handleLogin(context: Context, email: String, pass: String) {
        database = AppDbHelper(context)
        if (email.isEmpty() || pass.isEmpty()) {
            view.onLoginBlankError()
        } else {
            if (database.getProfile(email, pass)?.email == email && database.getProfile(
                    email,
                    pass
                )?.passWord == pass
            ) {
                context.startActivity(Intent(context, ProfileActivity::class.java))
                profile = database.getProfile(email, pass)!!
                view.onLoginSuccess()
            } else {
                view.onLoginFailure()
            }
        }
    }
}