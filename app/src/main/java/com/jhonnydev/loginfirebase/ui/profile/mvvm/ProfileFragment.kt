package com.jhonnydev.loginfirebase.ui.profile.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.jhonnydev.loginfirebase.R
import com.jhonnydev.loginfirebase.databinding.ProfileFragmentBinding
import com.jhonnydev.loginfirebase.models.UserResponse

class ProfileFragment : Fragment() {
    lateinit var user: UserResponse

    companion object {
        fun newInstance(
            user: UserResponse
        ): ProfileFragment {
            val mProfileFragment: ProfileFragment = ProfileFragment()
            mProfileFragment.user = user
            return mProfileFragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: ProfileFragmentBinding = DataBindingUtil.inflate(
            inflater,R.layout.profile_fragment, container, false
        )
        val view: View = binding.getRoot()
        binding.userDetail = user
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}