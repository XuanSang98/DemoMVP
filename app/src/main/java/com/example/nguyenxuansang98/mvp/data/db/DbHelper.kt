package com.example.nguyenxuansang98.mvp.data.db

import com.example.nguyenxuansang98.mvp.data.db.model.Profile

interface DbHelper {
    fun insertProfile(profile: Profile)
    fun getProfile(email : String,pass: String): Profile?
}