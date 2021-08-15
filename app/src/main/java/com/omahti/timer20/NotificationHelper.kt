package com.omahti.timer20

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

object NotificationHelper {

    private const val CHANNEL_ID = "reminder"
    private const val NOTIFICATION_ID = 1

    /*
    * Tujuan fungsi createNotificationChannel:
    * Membuat kategori notifikasi yang nanti akan muncul di pengaturan aplikasi.
    * Pembuatan kategori notifikasi ini berguna untuk mempermudah dalam mengatur notifikasi
    */
    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Reminder"
            val descriptionText = "show notification after 20 minutes timer"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = descriptionText

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun sendFinishTimerNotification(context: Context) {
        createNotificationChannel(context)
        // TODO: Membuat notifikasi ketika timer selesai
    }

    fun sendStartTimerNotification(context: Context){
        createNotificationChannel(context)
        // TODO: Membuat notifikasi ketika timer dijalankan
    }

}