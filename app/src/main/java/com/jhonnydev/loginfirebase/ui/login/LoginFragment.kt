package com.jhonnydev.loginfirebase.ui.login

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.jhonnydev.loginfirebase.R
import com.jhonnydev.loginfirebase.ui.login.mvvm.LoginViewModel
import com.jhonnydev.loginfirebase.ui.profile.ProfileFragment
import com.jhonnydev.loginfirebase.ui.register.RegisterFragment
import com.jhonnydev.loginfirebase.utils.Utils
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private lateinit var mLoginViewModel: LoginViewModel

    private val TAG =  javaClass.simpleName
    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mLoginViewModel =
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    private fun config(){
        mLoginViewModel.user .observe(viewLifecycleOwner, Observer { users ->
            if(users.isNotEmpty()){
                Log.i(TAG, "config: login succeful ${users.get(0).name}")
                Utils.cambiarFragments(ProfileFragment.newInstance(),activity!!.supportFragmentManager, R.id.container)
            }
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_iniciar_sesion.setOnClickListener{
            mLoginViewModel.getUsers(et_user.text.toString(),et_password.text.toString())
            config()
        }
        tv_registrar.setOnClickListener {
            Utils.cambiarFragments(RegisterFragment.newInstance(),activity!!.supportFragmentManager, R.id.container)
        }


    }
}