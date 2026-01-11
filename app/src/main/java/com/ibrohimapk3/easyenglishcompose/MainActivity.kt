package com.ibrohimapk3.easyenglishcompose

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Greeting()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Greeting() {
    var count by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxSize().fillMaxHeight(1F)) {
        Text(
            "${uppercaseLetters[count]} ${lowercaseLetters[count]}", modifier = Modifier.padding(top = 20.dp, start = 40.dp), fontSize = 39.sp
        )
        Image(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .padding()
                .fillMaxHeight(0.8F)
                .background(Color.White),
            contentScale = ContentScale.Crop,
            contentDescription = "My photo",
            painter = painterResource(listOfPhoto[count]),
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {
                    if (count > 0)
                        count--
                },
                modifier = Modifier
                    .size(60.dp)

            ) {
                Image(
                    modifier = Modifier
                        .padding(3.dp)
                        .size(57.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null
                )
            }
            IconButton(
                onClick = {
                    if (count < 25)
                        count++
                },
                modifier = Modifier
                    .size(60.dp)

            ) {
                Image(
                    modifier = Modifier
                        .padding(3.dp)
                        .size(57.dp),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(R.drawable.baseline_arrow_forward_ios_24),
                    contentDescription = null
                )
            }

        }
    }
}
val listOfPhoto = listOf(
    R.drawable.a,
    R.drawable.b,
    R.drawable.c,
    R.drawable.d,
    R.drawable.e,
    R.drawable.f,
    R.drawable.g,
    R.drawable.h,
    R.drawable.i,
    R.drawable.j,
    R.drawable.k,
    R.drawable.l,
    R.drawable.m,
    R.drawable.n,
    R.drawable.o,
    R.drawable.p,
    R.drawable.q,
    R.drawable.r,
    R.drawable.s,
    R.drawable.t,
    R.drawable.u,
    R.drawable.v,
    R.drawable.w,
    R.drawable.x,
    R.drawable.y,
    R.drawable.z
)
val uppercaseLetters = arrayOf(
    "A","B","C","D","E","F","G","H","I","J","K","L","M",
    "N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
)

val lowercaseLetters = arrayOf(
    "a","b","c","d","e","f","g","h","i","j","k","l","m",
    "n","o","p","q","r","s","t","u","v","w","x","y","z"
)