package pl.wader.sleeping_roulette.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.wader.sleeping_roulette.GameScreenViewModel
import pl.wader.sleeping_roulette.ui.theme.LightDarkGray
import pl.wader.sleeping_roulette.ui.theme.LightImageGray
import pl.wader.sleeping_roulette.ui.theme.MainFont
import pl.wader.sleeping_roulette.ui.theme.MainMenuBlack
import pl.wader.sleeping_roulette.ui.theme.imageGray

const val MILISECONDS_PER_SECOND = 1000
const val SECONDS_PER_MINUTE = 60
const val MINUTES_PER_HOUR = 60

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlarmScreen(gameScreenVm: GameScreenViewModel, onClick:(String)->Unit) {

    val context = LocalContext.current
    val elapsedTime = gameScreenVm.getElapsedTimed()

    var totalSeconds: Long = 0L
    var hours: Long = 0L
    var minutes: Long = 0L
    var seconds: Long = 0L
    Log.d("AlarmScreen", "Before calculations: elapsedTime: $elapsedTime")
    val endTime = gameScreenVm.endTime

    if(endTime > 0) {
        val totalSeconds = elapsedTime / MILISECONDS_PER_SECOND
        hours = totalSeconds / (SECONDS_PER_MINUTE * MINUTES_PER_HOUR)
        minutes = (totalSeconds / SECONDS_PER_MINUTE) % MINUTES_PER_HOUR
        seconds = totalSeconds % SECONDS_PER_MINUTE
    }
    Log.d("AlarmScreen", "Elapsed Time: $elapsedTime")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        contentAlignment = Alignment.TopCenter
    ){
        Surface(
            color = LightImageGray,
            modifier = Modifier.fillMaxSize()) {


        }
        Surface(
            color = MainMenuBlack,
            modifier = Modifier
                .height(730.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                bottomEnd = 45.dp,
                bottomStart = 45.dp)
        ) {

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            Text(
                text = "sleeping roulette",
                style = TextStyle(
                    fontSize = 48.sp,
                    color = imageGray
                ),
                fontFamily = MainFont,
                modifier = Modifier.padding(4.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .width(300.dp)
            ) {
                Log.d("AlarmScreen", "hours: $hours, minutes: $minutes, seconds: $seconds")

                Text(
                    text = "You slept for $hours hours, $minutes minutes and $seconds seconds",

                    style = TextStyle(
                        fontSize = 48.sp,
                        color = imageGray
                    ),

                    modifier = Modifier.padding(4.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        gameScreenVm.stopOngoingAlarm()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                        .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                        .padding(2.dp)) {
                    Text(
                        text = "turn off alarm",
                        style = TextStyle(
                            fontSize = 35.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        gameScreenVm.stopOngoingAlarm()
                        onClick("home")
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                        .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                        .padding(2.dp)) {
                    Text(
                        text = "menu",
                        style = TextStyle(
                            fontSize = 35.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )
                }
            }

        }
    }
}