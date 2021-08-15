package com.omahti.timer20

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.text.SimpleDateFormat
import java.util.*

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

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle("20 menit selesai")
            .setAutoCancel(true)
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Segera tinggalkan tempatmu dan tetap jaga protokol kesehatan")
            )

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
    }

    fun sendStartTimerNotification(context: Context) {
        createNotificationChannel(context)

        val time = System.currentTimeMillis() + (1000 * 60 * 20)
        val date = Date(time)
        val simpleDateFormat = SimpleDateFormat("HH:mm")


        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_timer_24)
            .setContentTitle("Timer telah dijalankan")
            .setContentText(
                "Waktu berakhir pada pukul ${simpleDateFormat.format(date)}"
            )

        NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, builder.build())
    }

}