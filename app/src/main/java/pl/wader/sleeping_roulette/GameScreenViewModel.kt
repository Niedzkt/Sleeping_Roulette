package pl.wader.sleeping_roulette

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.provider.AlarmClock
import androidx.lifecycle.ViewModel
import kotlin.random.Random

data class DifficultyLevel(val name: String, val hourRange: IntRange, val minuteRange: IntRange)

class GameScreenViewModel:ViewModel() {


    val difficultyLevels = listOf(
        DifficultyLevel("Easy", 0..0, 0..1),
        DifficultyLevel("Medium", 0..10, 0..59),
        DifficultyLevel("Hard", 0..23, 0..59),
        DifficultyLevel("Asian", 0..23, 9..59),
    )

    var selectedDifficultyLevel = difficultyLevels[0]


    private var isAlarmSet = false

    fun setRandomAlarm(context: Context){
        if(!isAlarmSet){
            val randomHour = Random.nextInt(selectedDifficultyLevel.hourRange.first, selectedDifficultyLevel.hourRange.last + 1)
            val randomMinute = Random.nextInt(selectedDifficultyLevel.minuteRange.first, selectedDifficultyLevel.minuteRange.last + 1)

            setAlarm(context, randomHour, randomMinute)
            isAlarmSet = true
        }
    }

    fun stopAlarm(context: Context){
        cancelAlarm(context)
    }

    private fun setAlarm(context: Context, hour: Int, minute: Int){
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
        }

        val alarmIntent = Intent(context, YourAlarmReceiver::class.java)

        val flags = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }

        val pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, flags)

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)
    }

    private fun cancelAlarm(context: Context){
        val alarmIntent = Intent(context, YourAlarmReceiver::class.java)
        val flags = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        } else{
            PendingIntent.FLAG_UPDATE_CURRENT
        }
        val pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, flags)
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(pendingIntent)
    }

}