package com.qamrand.privatbankatmservice.ui.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.qamrand.privatbankatmservice.App
import com.qamrand.privatbankatmservice.R
import com.qamrand.privatbankatmservice.databinding.FragmentMainBinding
import com.qamrand.privatbankatmservice.model.AtmDevice
import com.qamrand.privatbankatmservice.remote.api.AtmDataSource
import com.qamrand.privatbankatmservice.ui.activity.MainActivity
import com.qamrand.privatbankatmservice.ui.fragment.AtmFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainFragment : Fragment(), AtmAdapter.AtmViewListener, View.OnClickListener {

    @Inject
    lateinit var dataSource: AtmDataSource

    private lateinit var adapter: AtmAdapter

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        App.appComponent.injectMainFragment(this)

        //AutoCompleteTextView init
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            context!!,
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.cities)
        )

        binding.acCity.setAdapter(arrayAdapter)

        setupRecyclerView()

        binding.searchButton.setOnClickListener(this)
        return view
    }


    private fun fetchData(city: String) {
        GlobalScope.launch(Dispatchers.Main){
            val atm = dataSource.getAtmByCity(city)
            if(atm.isSuccessful) {
               // Log.d(App.TAG_APP, "" + atm.body()?.getAtmDevices())
                adapter.setItems(atm.body()?.getAtmDevices() as ArrayList<AtmDevice>)
            } else {
                Log.d(App.TAG_APP, atm.errorBody().toString())
            }
        }
    }

    override fun onClickAtm(atm: AtmDevice) {
        val fragment = AtmFragment()
        val bundle = Bundle()
        bundle.putSerializable(AtmFragment.EXTRA_ATM_DATA, atm)
        fragment.arguments = bundle
        (activity as MainActivity).showFragment(fragment)
    }

    private fun setupRecyclerView() {
        adapter = AtmAdapter(this)
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val itemDecor = DividerItemDecoration(
            binding.recyclerView.context,
            linearLayoutManager.orientation
        )

        binding.recyclerView.also {
            it.adapter = adapter
            it.layoutManager = linearLayoutManager
            it.addItemDecoration(itemDecor)
            it.setHasFixedSize(true)
        }
    }




    override fun onClick(v: View) {
        if(v.id == R.id.search_button) {
            Log.d(App.TAG_APP, "clicked")
            val city: String = binding.acCity.text.toString()
            if (city != "") {
                fetchData(city)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}