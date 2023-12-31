package pl.wader.sleeping_roulette.ui.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.app.AlarmManagerCompat
import androidx.core.content.ContextCompat
import pl.wader.sleeping_roulette.GameScreenViewModel
import pl.wader.sleeping_roulette.MainActivity
import pl.wader.sleeping_roulette.R
import pl.wader.sleeping_roulette.ui.theme.DarkerGray
import pl.wader.sleeping_roulette.ui.theme.LightDarkGray
import pl.wader.sleeping_roulette.ui.theme.MainFont
import pl.wader.sleeping_roulette.ui.theme.imageGray
import android.provider.Settings
import android.os.Build


//onClick:(String) ->Unit
//@Preview(showBackground = true, showSystemUi = true)

@Composable
fun HomeScreen(gameScreenVm: GameScreenViewModel, onClick:(String) ->Unit){

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightDarkGray),
        contentAlignment = Alignment.TopCenter

    )
    {
        Image(
            painter = painterResource(id = R.drawable.bgimage4),
            contentDescription = "background_menu",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
       Surface(
           color = DarkerGray.copy(0.5f),
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
                    color = imageGray),
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
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.width(300.dp)
            ) {
                //val density = LocalDensity.current
               // val shadowPx = with(density) {16.dp.toPx()}
                Button(
                    onClick = {
                        onClick("play")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                        .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                ) {
                    Text(
                        text = "play",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )
                }
                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Button(
                    onClick = {
                        onClick("settings")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                        .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                ) {
                    Text(
                        text = "settings",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Button(
                    onClick = {
                        gameScreenVm.loadInterstitialAd(context)
                        gameScreenVm.showInterstitialAd(context)
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                        .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                ) {
                    Text(
                        text = "watch add",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Button(
                    onClick = {
                        onClick("exit")
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                        .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                        .fillMaxWidth()
                        .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                ) {
                    Text(
                        text = "exit",
                        style = TextStyle(
                            fontSize = 38.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )
                }


            }
            }
    }
}