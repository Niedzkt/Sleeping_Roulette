package pl.wader.sleeping_roulette

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.provider.Settings
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

var mediaPlayer: MediaPlayer? = null

class YourAlarmReceiver: BroadcastReceiver() {

    companion object{
        var isAlarmTriggered: Boolean = false
    }
    override fun onReceive(context: Context, intent: Intent) {
        playAlarmSound(context)
        showNotification(context)

        val newIntent = Intent(context, MainActivity::class.java).apply {
            putExtra("NAVIGATE_TO", "alarmOn")
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        context.startActivity(newIntent)
        isAlarmTriggered = true
        Log.d("YourAlarmReceiver", "onReceive called. isAlarmTriggered set to true.")

    }

    private fun playAlarmSound(context: Context) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, R.raw.alarm_sound)
        }
        mediaPlayer?.start()
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

    fun stopAlarm(){
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}