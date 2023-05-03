package com.test.interview.presentation.ramazan

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.test.interview.data.custom_notification.createCustomNotification

/*
 * Created by Shahid Iqbal on 5/4/2023.
 */

class RamazanViewModel(private val application: Application) : AndroidViewModel(application) {

    fun createNotification() {
        application.createCustomNotification()
    }
}