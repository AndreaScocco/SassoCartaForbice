package com.example.sassocartaforbice

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sassocartaforbice.ui.theme.SassoCartaForbiceTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SassoCartaForbiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pulsanti()
                }
            }
        }
    }
}

@Composable

fun Pulsanti(){
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        var rockImage by remember{ mutableStateOf(R.drawable.rock) }
        var paperImage by remember{ mutableStateOf(R.drawable.paper) }
        var scissorsImage by remember{ mutableStateOf(R.drawable.scissors) }

        var MosseG by remember{ mutableStateOf(R.drawable.rock) }
        var MosseP by remember{ mutableStateOf(R.drawable.rock) }

        Image (painter = painterResource(id = rockImage), contentDescription = "")
        Image (painter = painterResource(id = paperImage), contentDescription = "")
       Image (painter = painterResource(id = scissorsImage), contentDescription = "")

        Row (modifier = Modifier.padding(10.dp,10.dp)){
            Text(text = "Mosse disponibili")
        }
        Row {
            Button(onClick = { rockImage = R.drawable.rock },
                modifier = Modifier
                    .padding(10.dp, 10.dp)) {
                Text(text = "Sasso")
            }
            Button(onClick = { paperImage = R.drawable.paper },
                modifier = Modifier
                    .padding(10.dp, 10.dp)) {
                Text(text = "Carta")
            }
            Button(onClick = { scissorsImage = R.drawable.scissors },
                modifier = Modifier
                    .padding(10.dp,10.dp)) {
                Text(text = "Forbice")

            }
        }
        fun IntRange.random(): Int {
            val rand = Random.nextInt((endInclusive + 1) - start) + start
            //(1..3).random()
            if (rand == 1){
                MosseP = R.drawable.rock
            } else if (rand == 2){
                MosseP = R.drawable.paper
            } else {
                MosseP = R.drawable.scissors
            }
            return rand
        }
    }
}

@Composable
@Preview
fun AppPreview (){
Pulsanti()
}