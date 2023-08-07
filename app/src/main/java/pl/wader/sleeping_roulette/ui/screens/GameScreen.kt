package pl.wader.sleeping_roulette.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GameScreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
    contentAlignment = Alignment.TopCenter
    ){
        Surface(color = Color.Red, modifier = Modifier.fillMaxSize()) {
            
        }
        Surface(color = Color.Yellow, modifier = Modifier.height(600.dp).fillMaxWidth()) {

        }
    }
}

