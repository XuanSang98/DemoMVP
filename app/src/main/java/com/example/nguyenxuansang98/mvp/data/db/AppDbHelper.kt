package com.example.nguyenxuansang98.mvp.data.db

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.nguyenxuansang98.mvp.data.db.model.Profile
import com.example.nguyenxuansang98.mvp.ui.register.RegisterActivity

class AppDbHelper(var context: Context) : DbHelper {

    private lateinit var database : SQLiteDatabase

    override fun insertProfile(profile: Profile) {
        database = DatabaseOpenHelper(context).writableDatabase
        val value = ContentValues()
        value.put(DatabaseOpenHelper.USER_NAME,profile.userName)
        value.put(DatabaseOpenHelper.PASSWORD,profile.passWord)
        value.put(DatabaseOpenHelper.URL_IMG,profile.urlImage)
        value.put(DatabaseOpenHelper.EMAIL,profile.email)
        database.insert(DatabaseOpenHelper.TABLE_PROFILE,null,value)
        database.close()
    }

    override fun getProfile(email : String,pass: String): Profile? {
        database = DatabaseOpenHelper(context).readableDatabase
        var query ="SELECT * FROM "+DatabaseOpenHelper.TABLE_PROFILE +" WHERE Email = '"+email+"' AND Password = '"+pass+"'"
        var cursor = database.rawQuery(query,null)
        cursor.moveToFirst()
        var student : Profile?=null
        while(cursor.isAfterLast() == false) {
             student = Profile(cursor.getString(1), cursor.getString(2), cursor.getString(3),cursor.getString(4));
            cursor.moveToNext();
        }
        return student
    }

}