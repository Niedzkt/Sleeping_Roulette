package pl.wader.sleeping_roulette

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer

class YourAlarmReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        playAlarmSound(context)
    }

    private fun playAlarmSound(context: Context){
        val mediaPlayer = MediaPlayer.create(context, R.raw.alarm_sound)
        mediaPlayer.start()
    }
}