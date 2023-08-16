package pl.wader.sleeping_roulette.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import pl.wader.sleeping_roulette.GameScreenViewModel

@Composable
fun SettingsScreen(gameScreenVm: GameScreenViewModel) {
    val context = LocalContext.current
    val sounds = gameScreenVm.soundsList
    val selectedSound = gameScreenVm.getSelectedSound(context)

    LazyColumn {
        items(sounds) { soundResId ->
            val soundName = context.resources.getResourceEntryName(soundResId)
            Text(
                text = soundName,
                modifier = Modifier.clickable {
                    gameScreenVm.saveSelectedSound(context, soundName)
                },
                color = if (soundName == selectedSound) Color.Green else Color.Black
            )
        }
    }
}
