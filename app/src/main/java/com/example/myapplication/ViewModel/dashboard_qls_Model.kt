package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.viewData
import com.example.myapplication.Model.view_all_book
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DashboardQLSModel : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _viewData = MutableLiveData<MutableList<viewData>>()
    private val _view_all_book = MutableLiveData<MutableList<view_all_book>>()

    val categories: LiveData<MutableList<viewData>> = _viewData
    val view_all_book: LiveData<MutableList<view_all_book>>  = _view_all_book

    fun loadview_all_book() {
        val ref = firebaseDatabase.getReference("path_to_category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<viewData>()
                for (child in snapshot.children) {
                    val item = child.getValue(viewData::class.java)
                    if (item != null) {
                        lists.add(item)
                    }
                }
                _viewData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error if needed
            }
        })
    }

    fun loadCategory() {
        val ref = firebaseDatabase.getReference("path_to_category")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<viewData>()
                for (child in snapshot.children) {
                    val item = child.getValue(viewData::class.java)
                    if (item != null) {
                        lists.add(item)
                    }
                }
                _viewData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error if needed
            }
        })
    }
}
