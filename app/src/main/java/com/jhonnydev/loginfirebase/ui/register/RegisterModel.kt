package com.jhonnydev.loginfirebase.ui.register

import com.jhonnydev.loginfirebase.api.RestApi
import com.jhonnydev.loginfirebase.base.RetrofitClient
import com.jhonnydev.loginfirebase.firebase.BasicFirebaseConfig
import com.jhonnydev.loginfirebase.firebase.FbRegisterInterface
import com.jhonnydev.loginfirebase.models.UserResponse
import com.jhonnydev.loginfirebase.ui.login.mvvm.LoginModelInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModel: FbRegisterInterface {
    private val API = RetrofitClient.getClient().create(RestApi::class.java)
    private val TAG = javaClass.simpleName


    val fbDb: BasicFirebaseConfig = BasicFirebaseConfig()
    lateinit var mRegisterModelInterface : RegisterModelInterface

    fun register(user: UserResponse){
        fbDb.fbDataRegister = this
        fbDb.newUser(user)
    }

    override fun registerSucceful(isRegistered :Boolean) {
        mRegisterModelInterface.registerSucceful(isRegistered )
    }

}
interface RegisterModelInterface{
    fun registerSucceful(isRegistered :Boolean)
}