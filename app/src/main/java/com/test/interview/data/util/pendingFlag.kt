package com.test.interview.data.util

import android.app.PendingIntent
import android.os.Build

fun pendingFlag() =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0