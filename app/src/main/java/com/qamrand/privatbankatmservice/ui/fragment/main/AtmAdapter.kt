package com.qamrand.privatbankatmservice.ui.fragment.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.qamrand.privatbankatmservice.R
import com.qamrand.privatbankatmservice.databinding.ItemPlaceBinding
import com.qamrand.privatbankatmservice.model.AtmDevice

class AtmAdapter(private val listener: AtmViewListener) :
    RecyclerView.Adapter<ViewHolder>() {

    interface AtmViewListener {
        fun onClickAtm(atm: AtmDevice)
    }

    private val items = ArrayList<AtmDevice>()

    fun setItems(items: ArrayList<AtmDevice>) {
        //Log.d(App.TAG_APP, "adapter:\n\n\n $items" )
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPlaceBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_place,
                parent,
                false
            )
        return ViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount(): Int = items.size
}

class ViewHolder(
    private val itemBinding: ItemPlaceBinding,
    private val listener: AtmAdapter.AtmViewListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var atmDevice: AtmDevice

    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: AtmDevice) {
        this.atmDevice = item
        itemBinding.atm = item
    }

    override fun onClick(v: View?) {
        listener.onClickAtm(atmDevice)
    }
}