package com.jhonnydev.loginfirebase.ui.login.mvvm

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jhonnydev.loginfirebase.base.apicontract.BaseContract
import com.jhonnydev.loginfirebase.base.observer.CallbackHandlingObserver
import com.jhonnydev.loginfirebase.models.UserResponse

class LoginViewModel : ViewModel()  , BaseContract.ServiceErrorApi{

    private val TAG = javaClass.simpleName

    val mUserModel: LoginModel = LoginModel()
    private val ENDPOINT_LOGIN = "ENDPOINT_LOGIN"
    var user: MutableLiveData<UserResponse> = MutableLiveData()

    @SuppressLint("CheckResult")
    fun getLogin() {
        mUserModel.getLogin().subscribeWith(object: CallbackHandlingObserver<UserResponse>(this, ENDPOINT_LOGIN){
            override fun onSuccess(data: UserResponse) {
                user.value = data
            }
        })
    }


    override fun onUnknownError(error: String, caller: String) {
        Log.e(TAG,"onUnknownError error: $error, caller: $caller")
    }

    override fun onTimeoutError(caller: String) {
        Log.e(TAG,"onTimeoutError caller: $caller")
    }

    override fun onNetworkError(caller: String) {
        Log.e(TAG,"onNetworkError caller: $caller")
    }

    override fun onBadRequestError(caller: String, codeError: Int) {
        Log.e(TAG,"onBadRequestError caller: $caller, codeError: $codeError")
    }

    override fun onServerError(caller: String) {
        Log.e(TAG,"onServerError caller: $caller")
    }

    override fun infoError(cause: Throwable?, msg: String?) {
        Log.e(TAG,"onServerError cause: $cause, msg: $msg")
    }
}
