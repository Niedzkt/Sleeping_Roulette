package pl.wader.sleeping_roulette

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.wader.sleeping_roulette.ui.screens.AlarmScreen
import pl.wader.sleeping_roulette.ui.screens.GameOnScreen
import pl.wader.sleeping_roulette.ui.screens.GameScreen
import pl.wader.sleeping_roulette.ui.screens.HistoryScreen
import pl.wader.sleeping_roulette.ui.screens.HomeScreen
import pl.wader.sleeping_roulette.ui.screens.Rules
import pl.wader.sleeping_roulette.ui.screens.SettingsScreen
import pl.wader.sleeping_roulette.ui.theme.Sleeping_RouletteTheme

class MainActivity : ComponentActivity() {
    private val gameScreenVm by viewModels<GameScreenViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                       onClick = { navController.navigate(it) }
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
                    SettingsScreen()
                }
                composable("history"){
                    HistoryScreen()
                }
                composable("knowHow"){
                        Rules()
                }
                composable("exit"){

                }
            }
        }
    }
}

