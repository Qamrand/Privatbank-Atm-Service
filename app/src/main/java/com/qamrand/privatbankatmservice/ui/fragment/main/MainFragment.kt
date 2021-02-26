package com.qamrand.privatbankatmservice.ui.fragment.main

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.utils.autoClearedFragment
import com.qamrand.privatbankatmservice.App
import com.qamrand.privatbankatmservice.R
import com.qamrand.privatbankatmservice.databinding.FragmentMainBinding
import com.qamrand.privatbankatmservice.di.components.DaggerMainFragmentComponent
import com.qamrand.privatbankatmservice.di.modules.MainFragmentModule
import com.qamrand.privatbankatmservice.model.AtmDevice
import com.qamrand.privatbankatmservice.remote.api.AtmDataSource
import com.qamrand.privatbankatmservice.ui.activity.MainActivity
import com.qamrand.privatbankatmservice.ui.fragment.atm.AtmFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainFragment : Fragment(R.layout.fragment_main), AtmAdapter.AtmViewListener,
    View.OnClickListener {

    @Inject
    lateinit var dataSource: AtmDataSource

    //@Inject
    lateinit var adapter: AtmAdapter

    private val _binding: FragmentMainBinding by autoClearedFragment(FragmentMainBinding::bind)
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                activity?.onBackPressed()
            }
        })

        App.appComponent.injectMainFragment(this)
        adapter = DaggerMainFragmentComponent
            .builder()
            .mainFragmentModule(MainFragmentModule(this))
            .build()
            .getAtmAdapter()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setAutoCompleteAdapter()

        binding.searchButton.setOnClickListener(this)
    }

    private fun setAutoCompleteAdapter(){
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            context!!,
            R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.cities)
        )

        binding.acCity.setAdapter(arrayAdapter)
    }

    private fun fetchData(city: String) {
        GlobalScope.launch(Dispatchers.Main) {
            binding.progressBar.visibility = View.VISIBLE
            val atm = dataSource.getAtmByCity(city)
            if (atm.isSuccessful) {
                // Log.d(App.TAG_APP, "" + atm.body()?.getAtmDevices())
                binding.progressBar.visibility = View.GONE
                adapter.setItems(atm.body()?.atmDevices as ArrayList<AtmDevice>)
            } else {
                Exception(atm.errorBody().toString()).printStackTrace()
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
        when (v.id) {
            R.id.search_button -> {
                val city: String = binding.acCity.text.toString()
                if (city != "") {
                    adapter.setItems(ArrayList())
                    hideSoftKeyboard(activity as MainActivity)
                    fetchData(city)
                }
            }

        }

    }

    private fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager: InputMethodManager = activity.getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity.currentFocus!!.windowToken, 0
        )
    }


}