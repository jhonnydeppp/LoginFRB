package com.jhonnydev.loginfirebase.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jhonnydev.loginfirebase.models.UserResponse
import com.jhonnydev.loginfirebase.ui.login.mvvm.LoginModel

class RegisterViewModel : ViewModel(), RegisterModelInterface {
    private val TAG = javaClass.simpleName
    val mRegisterModel: RegisterModel = RegisterModel()
    var isUserRegistered: MutableLiveData<Boolean> = MutableLiveData()

    fun newUser(user: UserResponse) {
        mRegisterModel.mRegisterModelInterface = this
        mRegisterModel.register(user)
    }

    override fun registerSucceful(isRegistered :Boolean) {
        isUserRegistered .value = isRegistered
    }

}