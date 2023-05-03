package com.test.interview.presentation.utils

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.FragmentActivity

fun FragmentActivity.onBackPressed(callback: () -> Unit) {
    onBackPressedDispatcher.addCallback(this,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                callback()
            }
        }
 	)
}
