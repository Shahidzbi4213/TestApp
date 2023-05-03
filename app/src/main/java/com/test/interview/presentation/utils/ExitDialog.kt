package com.test.interview.presentation.utils;

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/*
 * Created by Shahid Iqbal on 5/3/2023.
 */

fun Context.showExitDialog(
    title: String,
    description: String,
    onYes: () -> Unit
) {

    MaterialAlertDialogBuilder(this)
        .setTitle(title)
        .setMessage(description)
        .setCancelable(false)
        .setPositiveButton("Yes") { _, _ -> onYes() }
        .setNegativeButton("No", null)
        .show()
}