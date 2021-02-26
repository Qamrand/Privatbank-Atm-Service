package com.qamrand.privatbankatmservice.ui.fragment.atm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.rickandmorty.utils.autoClearedFragment
import com.qamrand.privatbankatmservice.R
import com.qamrand.privatbankatmservice.databinding.FragmentAtmBinding
import com.qamrand.privatbankatmservice.model.AtmDevice

class AtmFragment : Fragment(R.layout.fragment_atm) {

  /*  private var _binding: FragmentAtmBinding? = null
    private val binding get() = _binding!!*/

    private val binding: FragmentAtmBinding by autoClearedFragment(FragmentAtmBinding::bind)

/*    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_atm, container, false)
        val view = binding.root



        return view
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val atmDevice = arguments?.getSerializable(EXTRA_ATM_DATA) as AtmDevice
        binding.atm = atmDevice
    }

    companion object {
        const val EXTRA_ATM_DATA = "Atm data"
    }
}