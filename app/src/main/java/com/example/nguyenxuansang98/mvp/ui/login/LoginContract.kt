package com.example.nguyenxuansang98.mvp.ui.login

import android.content.Context
import com.example.nguyenxuansang98.mvp.data.db.model.Profile

interface LoginContract {

    interface View {
        fun onLoginSuccess()
        fun onLoginFailure()
        fun onLoginBlankError()
    }

    interface Presenter{
        fun handleLogin(context: Context,email : String,pass: String)
    }
}