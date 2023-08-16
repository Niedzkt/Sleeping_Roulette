package pl.wader.sleeping_roulette

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import java.util.Timer
import java.util.TimerTask
import kotlin.random.Random

data class DifficultyLevel(val name: String, val hourRange: IntRange, val minuteRange: IntRange)


class GameScreenViewModel:ViewModel() {
    private var interstitialAd: InterstitialAd?= null

    fun loadInterstitialAd(context: Context){
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(
            context,
            "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback(){
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                }

                override fun onAdFailedToLoad(adError: LoadAdError) {
                    interstitialAd = null
                }
            }
        )
    }

    fun showInterstitialAd(context: Context){
        interstitialAd?.show(context as Activity)
    }

   // private val _endTime = MutableStateFlow(0L)
   init {
       Log.d("GameScreenViewModel", "Initialized instance: $this")
   }
    var startTime: Long = 0L
    var endTime: Long = 0L


    val difficultyLevels = listOf(
        DifficultyLevel("Easy", 0..0, 1..2),
        DifficultyLevel("Medium", 0..10, 0..59),
        DifficultyLevel("Hard", 0..23, 0..59),
       // DifficultyLevel("Asian", 0..23, 9..59),
    )

    var selectedDifficultyLevel = difficultyLevels[0]


    private var isAlarmSet = false
    private var timer = Timer()

    init {
        timer.scheduleAtFixedRate(object : TimerTask(){
            override fun run() {
                checkAlarmTriggered()
            }
        },0,1000)
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    fun setRandomAlarm(context: Context){
        if(!isAlarmSet){
            val randomHour = Random.nextInt(selectedDifficultyLevel.hourRange.first, selectedDifficultyLevel.hourRange.last + 1)
            val randomMinute = Random.nextInt(selectedDifficultyLevel.minuteRange.first, selectedDifficultyLevel.minuteRange.last + 1)

            setAlarm(context, randomHour, randomMinute)
            isAlarmSet = true
            startTime = System.currentTimeMillis()
            Log.d("TAG", "setRandomAlarm called")
            Log.d("GameScreenVM", "Alarm set. startTime: $startTime")
        }
    }

    fun stopAlarm(context: Context){
        cancelAlarm(context)
        Log.d("TAG", "stopAlarm called")
    }
    fun stopOngoingAlarm(){
        YourAlarmReceiver().stopAlarm()
        Log.d("TAG", "stopOngoingAlarm called")

    }
    fun checkAlarmTriggered(){
        if(YourAlarmReceiver.isAlarmTriggered && endTime == 0L){
            endTime=System.currentTimeMillis()
            Log.d("GameScreenVM", "Alarm triggered. endTime: $endTime")
        }
    }
    fun getElapsedTimed(): Long{
        return endTime-startTime
    }


    private fun setAlarm(context: Context, hour: Int, minute: Int){
        val calendar = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            Log.d("TAG", "setAlarm called")
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