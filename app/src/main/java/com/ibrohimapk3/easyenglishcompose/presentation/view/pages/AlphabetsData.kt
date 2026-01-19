package com.ibrohimapk3.easyenglishcompose.presentation.view.pages

import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrohimapk3.easyenglishcompose.R
import com.ibrohimapk3.easyenglishcompose.presentation.view.Speaker
import com.ibrohimapk3.easyenglishcompose.presentation.view.listOfPhoto
import com.ibrohimapk3.easyenglishcompose.presentation.view.lowercaseLetters
import com.ibrohimapk3.easyenglishcompose.presentation.view.uppercaseLetters


@Composable
fun AlphabetData() {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(1F)
            .background(Color.White)
    ) {
        Text(
            "${uppercaseLetters[count]} ${lowercaseLetters[count]}",
            modifier = Modifier.padding(top = 20.dp, start = 40.dp),
            fontSize = 39.sp
        )
        Image(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .padding()
                .fillMaxHeight(0.7F)
                .background(Color.White),
            contentScale = ContentScale.Crop,
            contentDescription = "My photo",
            painter = painterResource(listOfPhoto[count]),
        )
        ButtonSoundAndSwitcher(count, onCountChange = { count = it })
    }
}

@Composable
fun ButtonSoundAndSwitcher(count: Int, onCountChange: (Int) -> Unit) {
    val context = LocalContext.current
    var speaker = remember { Speaker(context = context) }
    Row(modifier = Modifier.fillMaxWidth()) {
        IconButton(
            onClick = {
                speaker.speak(uppercaseLetters[count])
                Log.d("coun2t", count.toString())
            },
            modifier = Modifier
                .width(90.dp)
                .height(90.dp)
        ) {
            Image(
                modifier = Modifier.size(90.dp),
                painter = painterResource(R.drawable.soundicon),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .weight(1F)
                .padding(end = 20.dp),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(
                onClick = {
                    if (count > 0) {
                        var newCount = count - 1
                        onCountChange(newCount)
                        speaker.speak(uppercaseLetters[newCount].toString())
                        Log.d("coun2t", count.toString())
                    }
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
                    if (count < 25) {
                        var newCount = count + 1
                        onCountChange(newCount)
                        speaker.speak(uppercaseLetters[newCount].toString())
                        Log.d("coun2t", count.toString())
                    }
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
