package com.example.nguyenxuansang98.mvp.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.nguyenxuansang98.mvp.R
import com.example.nguyenxuansang98.mvp.ui.login.LoginPresenter
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Glide.with(this).load(LoginPresenter.profile.urlImage).into(circlerimage_profile)
        textview_name_profile.text=LoginPresenter.profile.userName
    }
}
