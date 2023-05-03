package com.test.interview.data.custom_notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import com.test.interview.R
import com.test.interview.utils.NotificationsUtils

/*
 * Created by Shahid Iqbal on 5/4/2023.
 */

class CustomNotificationReceiver : BroadcastReceiver() {

    companion object {
        private var player: MediaPlayer? = null

        fun Context.getPlayer(): MediaPlayer {
            if (player == null) {
                player = MediaPlayer.create(this, R.raw.ramazan_tone)
            }
            return player!!
        }
    }

    override fun onReceive(context: Context, intent: Intent?) {

        context.apply {

            intent?.let {
                val playStatus = it.getStringExtra("PLAY_ME") ?: "1"

                if (playStatus == "1") {
                    getPlayer().start()
                } else {
                    getPlayer().stop()
                    getPlayer().release()
                    NotificationsUtils.cancelNotification(this, 4433)
                    player = null
                }
            }
        }

    }
}

