package com.example.navigationdrawer.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawer.R
import com.example.navigationdrawer.model.User

class CustomAdapter(var users: List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_home_view, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var user = users.get(position)
        if (holder is CustomViewHolder){
            holder.tv_name.setText(user.tv_name)
            holder.tv_tel_number.setText(user.tv_tel_umber)
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_name = view.findViewById<TextView>(R.id.tv_name)
        val tv_tel_number = view.findViewById<TextView>(R.id.tv_tel_number)
    }
}
