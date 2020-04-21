package com.example.nguyenxuansang98.mvp.ui.register

import android.content.Context
import com.example.nguyenxuansang98.mvp.data.db.model.Profile

interface RegisterContract {

    interface View {
        fun onRegisterBlankError()
    }

    interface Presenter {
        fun handleRegister(context: Context, profile: Profile)
    }
}