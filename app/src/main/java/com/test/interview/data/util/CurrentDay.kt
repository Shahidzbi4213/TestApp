package com.test.interview.data.util

import java.util.Calendar

/*
 * Created by Shahid Iqbal on 5/3/2023.
 */


fun Int.currentDay(): String = when (this) {
    Calendar.SUNDAY -> "Sunday"
    Calendar.MONDAY -> "Monday"
    Calendar.TUESDAY -> "Tuesday"
    Calendar.WEDNESDAY -> "Wednesday"
    Calendar.THURSDAY -> "Thursday"
    Calendar.FRIDAY -> "Friday"
    Calendar.SATURDAY -> "Saturday"
    else -> "Undefined"
}