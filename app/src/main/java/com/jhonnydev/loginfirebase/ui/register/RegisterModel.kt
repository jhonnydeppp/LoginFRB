package com.jhonnydev.loginfirebase.ui.register

import com.jhonnydev.loginfirebase.firebase.BasicFirebaseConfig
import com.jhonnydev.loginfirebase.firebase.FbRegisterInterface
import com.jhonnydev.loginfirebase.models.UserResponse

class RegisterModel: FbRegisterInterface {
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