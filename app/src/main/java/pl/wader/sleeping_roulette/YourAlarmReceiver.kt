package pl.wader.sleeping_roulette

import android.app.Notification
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class YourAlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        playAlarmSound(context)
        showNotification(context)

        val newIntent = Intent(context, MainActivity::class.java).apply {
            putExtra("NAVIGATE_TO", "alarmOn")
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        context.startActivity(newIntent)
    }

    private fun playAlarmSound(context: Context){
        val mediaPlayer = MediaPlayer.create(context, R.raw.alarm_sound)
        mediaPlayer.start()
    }

    private fun showNotification(context: Context){
        val builder = NotificationCompat.Builder(context, "alarm_channel")
            .setSmallIcon(R.drawable.arrow)
            .setContentTitle("WAKE UP")
            .setContentText("WAKY WAKY")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setSound(Settings.System.DEFAULT_ALARM_ALERT_URI)

        val notificationManager = NotificationManagerCompat.from(context)
        try {
            notificationManager.notify(1, builder.build())
        }catch (e: SecurityException){
            e.printStackTrace()
        }

    }
}