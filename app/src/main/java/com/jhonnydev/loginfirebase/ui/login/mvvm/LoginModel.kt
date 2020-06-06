package com.jhonnydev.loginfirebase.ui.login.mvvm

import com.jhonnydev.loginfirebase.api.RestApi
import com.jhonnydev.loginfirebase.base.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModel{
    private val API = RetrofitClient.getClient().create(RestApi::class.java)

    fun getLogin( ) = API.getLogin().subscribeOn(
        Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!
}