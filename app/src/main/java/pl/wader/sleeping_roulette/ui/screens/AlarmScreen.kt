package pl.wader.sleeping_roulette.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import pl.wader.sleeping_roulette.ui.theme.LightDarkGray
import pl.wader.sleeping_roulette.ui.theme.LightImageGray
import pl.wader.sleeping_roulette.ui.theme.MainFont
import pl.wader.sleeping_roulette.ui.theme.MainMenuBlack
import pl.wader.sleeping_roulette.ui.theme.imageGray

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlarmScreen() {


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
                Button(
                    onClick = {
                        /*TODO*/
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
            }

        }
    }
}