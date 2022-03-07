package com.sonu.dagger2example.core

import android.util.Log
import javax.inject.Inject

interface UserRepository {
    fun saveUser(email: String, password: String)
}

private const val TAG = "UserRepository"

/*
    component where are using sql
 */
class SQLRepository @Inject constructor(
    private val retryCount: Int
) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "user saved in db retry count $retryCount")
    }
}

class FirebaseRepository @Inject constructor(
) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG, "user saved in firebase database")

    }
}
