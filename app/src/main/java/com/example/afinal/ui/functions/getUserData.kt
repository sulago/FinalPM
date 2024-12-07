package com.example.afinal.ui.functions

import com.example.afinal.data.data_classes.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


fun getUserData(userId: String, onResult: (User?) -> Unit) {
    val database = FirebaseDatabase.getInstance()
    val userRef = database.reference.child("users").child(userId)

    userRef.addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val user = snapshot.getValue(User::class.java)
            onResult(user)
        }

        override fun onCancelled(error: DatabaseError) {
            onResult(null)
        }
    })
}