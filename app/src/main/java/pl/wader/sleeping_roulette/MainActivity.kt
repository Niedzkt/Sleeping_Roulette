package pl.wader.sleeping_roulette

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.ads.MobileAds
import pl.wader.sleeping_roulette.ui.screens.AlarmScreen
import pl.wader.sleeping_roulette.ui.screens.GameOnScreen
import pl.wader.sleeping_roulette.ui.screens.GameScreen
import pl.wader.sleeping_roulette.ui.screens.HomeScreen
import pl.wader.sleeping_roulette.ui.screens.SettingsScreen

class MainActivity : ComponentActivity() {

    companion object {
        const val MY_PERMISSIONS_REQUEST_SCHEDULE_EXACT_ALARM = 1
    }

    private val gameScreenVm by viewModels<GameScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (ContextCompat.checkSelfPermission(this, "android.permission.SCHEDULE_EXACT_ALARM")
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                arrayOf("android.permission.SCHEDULE_EXACT_ALARM"),
                MY_PERMISSIONS_REQUEST_SCHEDULE_EXACT_ALARM)
        }

        Log.d("AlarmDebug", "MainActivity created.")
        MobileAds.initialize(this){}

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val name = "Alarm Channel"
            val descriptionText = "Channel for alarm sound"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("alarm_channel", name, importance).apply{
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }

        val windows = this.window
        windows.statusBarColor = Color.BLACK

        setContent {
            val navController = rememberNavController()

            val context = LocalContext.current

            intent?.getStringExtra("NAVIGATE_TO")?.let { destination ->
                if(destination == "alarmOn"){
                    LaunchedEffect(key1 = destination){
                        navController.navigate("alarmOn")
                    }
                }
            }

            NavHost(navController = navController, startDestination = "home"){
                composable("home"){
                   HomeScreen(
                       gameScreenVm = gameScreenVm,
                       onClick = {
                           if(it=="exit") {
                           (context as? Activity)?.finish()
                           }
                           else
                               navController.navigate(it)
                       }
                )
                }
                composable("play"){
                    GameScreen(
                        gameScreenVm = gameScreenVm,
                        onClick = {navController.navigate(it)}
                    )
                }
                composable("gameOn"){
                    GameOnScreen(
                        gameScreenVm = gameScreenVm,
                        onClick = {navController.navigate(it)}
                    )
                }
                composable("alarmOn"){
                    AlarmScreen(
                        gameScreenVm = gameScreenVm,
                        onClick = {navController.navigate(it)}
                    )
                }
                composable("settings"){
                    SettingsScreen(
                        gameScreenVm = gameScreenVm,
                        onClick = {navController.navigate(it)}
                    )
                }
            }
        }
    }
}

