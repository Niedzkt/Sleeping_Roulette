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
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.wader.sleeping_roulette.R
import pl.wader.sleeping_roulette.ui.theme.DarkBlue
import pl.wader.sleeping_roulette.ui.theme.DarkGold
import pl.wader.sleeping_roulette.ui.theme.DarkerBlue
import pl.wader.sleeping_roulette.ui.theme.DarkerGray
import pl.wader.sleeping_roulette.ui.theme.Gold
import pl.wader.sleeping_roulette.ui.theme.LightDarkGray
import pl.wader.sleeping_roulette.ui.theme.MainFont

//onClick:(String) ->Unit
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightDarkGray),
        contentAlignment = Alignment.TopCenter

    )
    {
        Surface(color = DarkGold, modifier = Modifier.height(650.dp).fillMaxWidth(),
        shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp)) {
            Surface(color = DarkerGray, modifier = Modifier.matchParentSize().padding(4.dp),
                shape = RoundedCornerShape(bottomEnd = 60.dp, bottomStart = 60.dp)) {

            }
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
                    color = Gold),
                    fontFamily = MainFont,
                    modifier = Modifier.padding(4.dp)
                    )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
            ,contentAlignment = Alignment.Center)
        {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        //onClick("play")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "play",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = Gold,
                            fontFamily = MainFont
                        )
                    )
                }
                Button(
                    onClick = {
                       // onClick("settings")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "settings",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = Gold,
                            fontFamily = MainFont
                        )
                    )
                }
                Button(
                    onClick = {
                        //onClick("history")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "history",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = Gold,
                            fontFamily = MainFont
                        )
                    )
                }
                Button(
                    onClick = {
                        //onClick("knowHow")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "how to play",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = Gold,
                            fontFamily = MainFont
                        )
                    )
                }
                Button(
                    onClick = {
                        //onClick("exit")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "exit",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = Gold,
                            fontFamily = MainFont
                        )
                    )
                }


            }
            }
    }
}