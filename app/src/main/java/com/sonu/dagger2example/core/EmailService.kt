package com.sonu.dagger2example.core

import android.util.Log
import javax.inject.Inject


/*
here we are taking user repository service at  activity level and analytics service at application level
 */
interface NotificationService {
    fun send(to: String, body: String)
}

private const val TAG = "EmailService"

@ActivityScope
class EmailService @Inject constructor(
    private val analyticService: AnalyticService
) : NotificationService {
    override fun send(to: String, body: String) {
        Log.d(TAG, ": send email")
        analyticService.sendEvent("email event", "email send")
    }
}

@ActivityScope
class MessageService @Inject constructor(
    private val analyticService: AnalyticService

) : NotificationService {
    override fun send(to: String, body: String) {
        Log.d(TAG, "send  message")
        analyticService.sendEvent("message event", "message send")

    }
}
