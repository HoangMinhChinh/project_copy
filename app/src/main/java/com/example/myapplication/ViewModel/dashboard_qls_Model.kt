package com.example.myapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Model.viewData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DashboardQLSModel : ViewModel() {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    private val _categoryLiveData = MutableLiveData<MutableList<viewData>>()
    val categories: LiveData<MutableList<viewData>> get() = _categoryLiveData

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
                _categoryLiveData.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle database error if needed
            }
        })
    }
}
