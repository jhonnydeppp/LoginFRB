package com.jhonnydev.loginfirebase.ui.login.mvvm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jhonnydev.loginfirebase.base.apicontract.BaseContract
import com.jhonnydev.loginfirebase.base.observer.CallbackHandlingObserver
import com.jhonnydev.loginfirebase.models.UserResponse

class LoginViewModel : ViewModel(), LoginModelInterface{

    private val TAG = javaClass.simpleName
    var username :String = ""
    var password: String = ""
    val mLoginModel: LoginModel = LoginModel()
    var user: MutableLiveData<List<UserResponse>> = MutableLiveData()

    fun getUsers(username :String, password: String){
        this.username = username
        this.password= password
        mLoginModel.mLoginModelInterface = this
        mLoginModel.login()
    }

    override fun getLogin(list: List<UserResponse>) {
        if(list.filter { it.user  == username && it.password == password}.isNotEmpty())
            user.value = list.filter { it.user  == username && it.password == password}
    }

}
