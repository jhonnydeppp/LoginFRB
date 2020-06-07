package com.jhonnydev.loginfirebase.ui.register

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
import com.jhonnydev.loginfirebase.models.UserResponse
import com.jhonnydev.loginfirebase.ui.login.mvvm.LoginFragment
import com.jhonnydev.loginfirebase.ui.login.mvvm.LoginViewModel
import com.jhonnydev.loginfirebase.ui.profile.mvvm.ProfileFragment
import com.jhonnydev.loginfirebase.utils.Utils
import kotlinx.android.synthetic.main.register_fragment.*

class RegisterFragment : Fragment() {

    private val TAG =  javaClass.simpleName
    private lateinit var  mContext : Context
    companion object {
        fun newInstance() = RegisterFragment()
    }

    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.mContext= this.context!!
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        config()
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    private fun config(){
        viewModel.isUserRegistered .observe(viewLifecycleOwner, Observer { users ->
              if(users)
                  Utils.makeToast(this.mContext,"Usuario Registrado con exito")
                Utils.cambiarFragments(LoginFragment.newInstance(),activity!!.supportFragmentManager, R.id.container)

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_registrar.setOnClickListener {  viewModel.newUser(UserResponse(et_usuario.text.toString(),et_clave.text.toString()
            ,et_name.text.toString(),et_telefono.text.toString(),et_direccion.text.toString()))}
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}