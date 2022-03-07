package com.sonu.dagger2example.core

import android.util.Log
import javax.inject.Inject

interface AnalyticService {
    fun sendEvent(eventName: String, eventType: String)
}

private const val TAG = "AnalyticService"

@Singleton
class MixPanel @Inject constructor(
) : AnalyticService {
    override fun sendEvent(eventName: String, eventType: String) {
        Log.d(TAG, "sendEvent:  $eventName -> $eventType ")
    }
}

@Singleton
class FirebaseAnalytic @Inject constructor(
) : AnalyticService {
    override fun sendEvent(eventName: String, eventType: String) {
        Log.d(TAG, "sendEvent:  $eventName -> $eventType ")
    }
}