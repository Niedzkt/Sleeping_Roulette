package pl.wader.sleeping_roulette.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.wader.sleeping_roulette.ui.theme.DarkerGray
import pl.wader.sleeping_roulette.ui.theme.LightImageGray
import pl.wader.sleeping_roulette.ui.theme.MainFont
import pl.wader.sleeping_roulette.ui.theme.MainMenuBlack
import pl.wader.sleeping_roulette.ui.theme.imageGray

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
    contentAlignment = Alignment.TopCenter
    ){
        Surface(color = LightImageGray, modifier = Modifier.fillMaxSize()) {


        }
        Surface(color = MainMenuBlack,
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
            Text(
                text = "How to play?\n" +
                        "\n" +
                        "1. Turn off any other unnecessary alarms that might interrupt the game.\n" + "\n" +
                        "2. Turn on the alarm sound.\n" + "\n" +
                        "3. Choose the difficulty level.\n" + "\n" +
                        "4. Follow the instructions appearing on the screen.\n" + "\n" +
                        "5. Do not cheat.\n" + "\n",
                style = TextStyle(
                    fontSize = 22.sp,
                    color = imageGray
                )
                )
            Column() {
                
            }
        }
    }
}

