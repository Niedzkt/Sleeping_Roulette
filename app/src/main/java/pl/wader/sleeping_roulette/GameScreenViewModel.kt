package pl.wader.sleeping_roulette

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.provider.AlarmClock
import androidx.lifecycle.ViewModel

class GameScreenViewModel:ViewModel() {

    fun setRandomAlarm(context: Context){
        val randomHour = (0..0).random()
        val randomMinute = (0..1).random()

        setAlarm(context, randomHour, randomMinute)
    }

    private fun setAlarm(context: Context, hour: Int, minute: Int){
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }

        val alarmIntent = Intent(context, YourAlarmReceiver::class.java)

        // Dodajemy odpowiednią flagę w zależności od wersji Androida:
        val flags = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }

        val pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, flags)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }
}