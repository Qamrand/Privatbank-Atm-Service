package com.qamrand.privatbankatmservice.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.qamrand.privatbankatmservice.databinding.FragmentAtmBinding
import com.qamrand.privatbankatmservice.model.AtmDevice

class AtmFragment : Fragment() {

    private var _binding: FragmentAtmBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAtmBinding.inflate(inflater, container, false)
        val view = binding.root

        val atmDevice = arguments?.getSerializable("Atm data") as AtmDevice

        binding.apply {
            textViewCity.text = atmDevice.getCityRU()
            textViewPlace.text = atmDevice.getPlaceRu()
            textViewAddress.text = atmDevice.getFullAddressRu()
            textViewWorkTime.text = atmDevice.getAtmTimeWork().toString()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val EXTRA_ATM_DATA = "Atm data"
    }
}