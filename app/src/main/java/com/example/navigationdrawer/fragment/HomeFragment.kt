package com.example.navigationdrawer.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.R
import com.example.navigationdrawer.model.User
import kotlinx.android.synthetic.main.home_activity.view.*

class HomeFragment: Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.home_activity, container, false)
        
        val users = prepareUserList()

        refreshAdapter(users)

        return root
    }

    private fun prepareUserList(): List<User> {
        var users = ArrayList<User>()
        for (i in 0..20){
            users.add(User("Odilbek", "+998 97 775 17 79"))
        }
        return users
    }
    private fun refreshAdapter(users: List<User>) {
        val adapter =CustomAdapter(users)
        root.recyclerView.adapter = adapter
    }
}