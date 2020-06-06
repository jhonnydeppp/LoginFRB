package com.jhonnydev.loginfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.jhonnydev.loginfirebase.ui.login.LoginFragment
import com.jhonnydev.loginfirebase.utils.Utils

class MainActivity : AppCompatActivity() {
    private val TAG =  javaClass.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Utils.cambiarFragments(LoginFragment.newInstance(), supportFragmentManager, R.id.container)


    }
}