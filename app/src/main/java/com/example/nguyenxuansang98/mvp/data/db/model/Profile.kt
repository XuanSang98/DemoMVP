package com.example.nguyenxuansang98.mvp.data.db.model

class Profile {
    var userName: String
    var passWord: String
    var email: String
    var urlImage: String

    constructor(userName: String, passWord: String, email: String, urlImage: String) {
        this.userName = userName
        this.passWord = passWord
        this.email = email
        this.urlImage = urlImage
    }
}