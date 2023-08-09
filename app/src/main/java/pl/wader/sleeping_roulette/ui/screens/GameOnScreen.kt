package pl.wader.sleeping_roulette.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import pl.wader.sleeping_roulette.R
import pl.wader.sleeping_roulette.ui.theme.LightImageGray
import pl.wader.sleeping_roulette.ui.theme.MainFont
import pl.wader.sleeping_roulette.ui.theme.MainMenuBlack
import pl.wader.sleeping_roulette.ui.theme.imageGray

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GameOnScreen(){

    var rotation by remember {
        mutableStateOf(0f)
    }
    var position by remember {
        mutableStateOf(0f)
    }
    var coroutineScope = rememberCoroutineScope()

    val movingDistance = 50f

    LaunchedEffect(key1 = "rotateIncrementally"){
        while (true){
            delay(1000)
            rotation+= 5f
        }
    }

    LaunchedEffect(key1 = "moveUpDown"){
        while (true){
            delay(1000)
            position = if (position==0f) movingDistance else 0f
        }
    }

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
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(300.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                contentAlignment = Alignment.TopCenter)
                {
                    Image(
                        painter = painterResource(id = R.drawable.rulette_wheel),
                        contentDescription = "Roulette wheel",
                        modifier = Modifier
                            .offset(0.dp, 85.dp)
                            .size(300.dp, 300.dp)
                            .graphicsLayer(
                                rotationZ = rotation
                            ))
                    Image(
                        painter = painterResource(id = R.drawable.border_roulette),
                        contentDescription = "border of roulette wheel",
                        modifier = Modifier
                            .offset(0.dp, 85.dp)
                            .size(300.dp, 300.dp))
                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Arrow of roulette wheel",
                        modifier = Modifier
                            .size(100.dp, 100.dp)
                            .graphicsLayer(
                                translationY = position
                            ))
            }
        }
        }


}
}
