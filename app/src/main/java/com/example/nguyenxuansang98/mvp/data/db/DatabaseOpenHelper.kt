package com.example.nguyenxuansang98.mvp.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseOpenHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION){

    companion object{
        val DATABASE_NAME = "ProfileDatabase"
        val DATABASE_VERSION = 1
        val TABLE_PROFILE ="Profile"
        val ID_PROFILE = "IdProfile"
        val USER_NAME = "UserName"
        val URL_IMG ="UrlImage"
        val PASSWORD ="Password"
        val EMAIL = "Email"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val create_table_profile = String.format("CREATE TABLE %s(%s INTEGER IDENTITY(1,1) PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT,%s TEXT)", TABLE_PROFILE, ID_PROFILE, USER_NAME, PASSWORD, EMAIL,
            URL_IMG)
        db?.execSQL(create_table_profile)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}