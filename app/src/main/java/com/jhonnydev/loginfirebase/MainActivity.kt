package com.jhonnydev.loginfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.jhonnydev.loginfirebase.ui.login.mvvm.LoginFragment
import com.jhonnydev.loginfirebase.utils.Utils

class MainActivity : AppCompatActivity() {
    private val TAG =  javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utils.cambiarFragments(LoginFragment.newInstance(), supportFragmentManager, R.id.container)


    }
}