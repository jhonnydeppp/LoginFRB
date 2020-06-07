package com.jhonnydev.loginfirebase.ui.login.mvvm

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.jhonnydev.loginfirebase.R
import com.jhonnydev.loginfirebase.ui.profile.mvvm.ProfileFragment
import com.jhonnydev.loginfirebase.ui.register.RegisterFragment
import com.jhonnydev.loginfirebase.utils.Utils
import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment() {

    private lateinit var mLoginViewModel: LoginViewModel

    private val TAG =  javaClass.simpleName
    private lateinit var mContext : Context
    companion object {
        fun newInstance() =
            LoginFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mContext= this.context!!
        mLoginViewModel =
            ViewModelProviders.of(this).get(LoginViewModel::class.java)
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    private fun config(){
        mLoginViewModel.user .observe(viewLifecycleOwner, Observer { users ->
            if(users.isNotEmpty()){
                hideLoading()
                Log.i(TAG, "config: login succeful ${users.get(0).name}")
                Utils.cambiarFragments(ProfileFragment.newInstance(users.get(0)),activity!!.supportFragmentManager, R.id.container)
            }else
                Utils.makeToast(mContext, getString(R.string.no_login))

        })
    }

     fun showLoading() {
        if(spin_kit != null)
            spin_kit.visibility = View.VISIBLE
    }

    fun hideLoading() {
        if(spin_kit != null)
            spin_kit.visibility = View.GONE
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_iniciar_sesion.setOnClickListener{
            showLoading()
            mLoginViewModel.getUsers(et_user.text.toString(),et_password.text.toString())
            config()
        }
        tv_registrar.setOnClickListener {
            Utils.cambiarFragments(RegisterFragment.newInstance(),activity!!.supportFragmentManager, R.id.container)
        }


    }
}