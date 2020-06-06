package com.jhonnydev.loginfirebase.ui.login.mvvm

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.jhonnydev.loginfirebase.api.RestApi
import com.jhonnydev.loginfirebase.base.RetrofitClient
import com.jhonnydev.loginfirebase.firebase.BasicFirebaseConfig
import com.jhonnydev.loginfirebase.firebase.FbDataInterface
import com.jhonnydev.loginfirebase.models.UserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModel: FbDataInterface {
    private val API = RetrofitClient.getClient().create(RestApi::class.java)
    private val TAG = javaClass.simpleName
    val fbDb: BasicFirebaseConfig = BasicFirebaseConfig()
    lateinit var mLoginModelInterface :LoginModelInterface

    fun getLogin( ) = API.getLogin().subscribeOn(
        Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())!!

    fun login(){
        fbDb.init(this)
        fbDb.getUser()
    }

    override fun getLogitData(list: List<UserResponse>) {
        mLoginModelInterface.getLogin(list)
    }

}
interface LoginModelInterface{
    fun getLogin(list :List<UserResponse>)
}