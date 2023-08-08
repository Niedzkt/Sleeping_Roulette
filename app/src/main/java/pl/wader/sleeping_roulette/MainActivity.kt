package pl.wader.sleeping_roulette

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.wader.sleeping_roulette.ui.screens.GameOnScreen
import pl.wader.sleeping_roulette.ui.screens.GameScreen
import pl.wader.sleeping_roulette.ui.screens.HistoryScreen
import pl.wader.sleeping_roulette.ui.screens.HomeScreen
import pl.wader.sleeping_roulette.ui.screens.Rules
import pl.wader.sleeping_roulette.ui.screens.SettingsScreen
import pl.wader.sleeping_roulette.ui.theme.Sleeping_RouletteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windows = this.window
        windows.statusBarColor = Color.BLACK

        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "home"){
                composable("home"){
                   HomeScreen(
                       onClick = { navController.navigate(it) }
                )
                }
                composable("play"){
                    GameScreen()
                }
                composable("gameOn"){
                    GameOnScreen()
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

