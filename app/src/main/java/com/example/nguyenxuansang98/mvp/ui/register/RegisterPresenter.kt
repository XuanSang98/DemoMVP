package com.example.nguyenxuansang98.mvp.ui.register

import android.content.Context
import com.example.nguyenxuansang98.mvp.data.db.AppDbHelper
import com.example.nguyenxuansang98.mvp.data.db.DbHelper
import com.example.nguyenxuansang98.mvp.data.db.model.Profile

class RegisterPresenter(val view: RegisterContract.View) : RegisterContract.Presenter {

    lateinit var database: AppDbHelper

    override fun handleRegister(context: Context, profile: Profile) {
        if (profile.email.isEmpty() || profile.passWord.isEmpty() || profile.urlImage.isEmpty() || profile.userName.isEmpty()) {
            view.onRegisterBlankError()
        } else {
            database = AppDbHelper(context)
            database.insertProfile(profile)
        }
    }
}