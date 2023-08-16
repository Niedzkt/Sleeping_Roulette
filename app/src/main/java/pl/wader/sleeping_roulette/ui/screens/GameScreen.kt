package pl.wader.sleeping_roulette.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.wader.sleeping_roulette.GameScreenViewModel
import pl.wader.sleeping_roulette.ui.theme.LightDarkGray
import pl.wader.sleeping_roulette.ui.theme.LightImageGray
import pl.wader.sleeping_roulette.ui.theme.MainFont
import pl.wader.sleeping_roulette.ui.theme.MainMenuBlack
import pl.wader.sleeping_roulette.ui.theme.imageGray

@Composable
fun DifficultySelector(gameScreenVm: GameScreenViewModel) {

    var currentDifficultyIndex by remember { mutableStateOf(0) }
    val currentDifficulty = gameScreenVm.difficultyLevels[currentDifficultyIndex]

    gameScreenVm.selectedDifficultyLevel = gameScreenVm.difficultyLevels[currentDifficultyIndex]

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Button(onClick = {
            if (currentDifficultyIndex > 0) {
                currentDifficultyIndex--
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                .width(70.dp)
                .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                .padding(2.dp)) {
            Text(
                text = "<",
                style = TextStyle(
                    color = imageGray,
                    fontSize = 22.sp
                )
            )
        }

        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.height(50.dp)) {


            Text(
                text = currentDifficulty.name,
                style = TextStyle(
                    fontSize = 38.sp,
                    color = imageGray,
                    fontFamily = MainFont

                    ), modifier = Modifier
                    .weight(1f)
            )

        }
        Button(onClick = {
            if (currentDifficultyIndex < gameScreenVm.difficultyLevels.size - 1) {
                currentDifficultyIndex++
            }
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(1.dp), clip = false)
                .background(LightDarkGray.copy(0.88f), RoundedCornerShape(4.dp))
                .width(70.dp)
                .border(2.dp, imageGray, RoundedCornerShape(6.dp))
                .padding(2.dp)) {
            Text(
                text = ">",
                style = TextStyle(
                    color = imageGray,
                    fontSize = 22.sp
                )
            )
        }
    }


    LaunchedEffect(currentDifficultyIndex) {
        gameScreenVm.selectedDifficultyLevel = gameScreenVm.difficultyLevels[currentDifficultyIndex]
    }
}

@Composable
fun GameScreen(gameScreenVm: GameScreenViewModel, onClick:(String)->Unit){



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
            Text(
                text = "How to play?\n" +
                        "\n" +
                        "1. Turn off any other unnecessary alarms that might interrupt the game.\n" + "\n" +
                        "2. Unmute the alarm sound.\n" + "\n" +
                        "3. Choose the difficulty level.\n" + "\n" +
                        "4. Follow the instructions appearing on the screen.\n" + "\n" +
                        "5. Do not cheat.\n" + "\n",
                style = TextStyle(
                    fontSize = 22.sp,
                    color = imageGray
                )
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.width(300.dp)
            ) {
                Text(
                    text = "good luck",
                    style = TextStyle(
                        color = imageGray,
                        fontSize = 50.sp
                    ),
                    fontFamily = MainFont,
                    modifier = Modifier.padding(5.dp)
                )
                Spacer(
                    modifier = Modifier.height(40.dp)
                )

                DifficultySelector(gameScreenVm)

                Button(
                    onClick = {
                        onClick("gameOn")
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
                        text = "start",
                        style = TextStyle(
                            fontSize = 50.sp,
                            color = imageGray,
                            fontFamily = MainFont
                        )
                    )

                }
            }
        }
    }
}

