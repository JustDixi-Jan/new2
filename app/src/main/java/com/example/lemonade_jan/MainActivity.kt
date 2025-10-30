package com.example.lemonade_jan

import android.media.Image
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lemonade_jan.ui.theme.Lemonade_janTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lemonade_janTheme {
                lemonPrew()
            }
        }
    }
}

@Composable
fun lemonadeShow(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }

    var clickcount1 by remember { mutableStateOf(0) }
    var clickcount2 by remember { mutableStateOf(0) }
    var clickcount3 by remember { mutableStateOf(0) }
    var clickcount4 by remember { mutableStateOf(0) }

    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val textResource = when (result) {
        1 -> R.string.Lemon_tree
        2 -> R.string.Lemon
        3 -> R.string.Glass_of_lemonade
        4 -> R.string.Empty_glass
        else -> R.string.Lemon_tree
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .size(0.dp, 65.dp)
            .absoluteOffset(0.dp, -400.dp)
            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
            Text(
                text = "Lemonade",
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black,
                modifier = modifier
                    .absoluteOffset(0.dp, 5.dp)
            )
        }
    Text(
        text = "Семенов Ян ИСИП24",
        fontSize = 12.sp,
        color = Color.Black,
        modifier = modifier
            .absoluteOffset(0.dp, -350.dp)
    )

    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageResource),
            contentDescription = result.toString(),
            modifier = Modifier.clickable {
                when (result) {
                    1 -> {
                        clickcount1 += 1
                        if (clickcount1 >= 1) {
                            result = 2
                            clickcount1 = 0
                        }
                    }
                    2 -> {
                        clickcount2 += 1
                        var count2 = (2..3).random()
                        if (clickcount2 >= count2) {
                            result = 3
                            clickcount2 = 0
                        }
                    }
                    3 -> {
                        clickcount3 += 1
                        if (clickcount3 >= 1) {
                            result = 4
                            clickcount3 = 0
                        }
                    }
                    4 -> {
                        clickcount4 += 1
                        if (clickcount4 >= 1) {
                            result = 1
                            clickcount4 = 0
                        }
                    }

                }
            }
        )
        TextButton(
            onClick = { when (result) {
                1 -> {
                    clickcount1 += 1
                    if (clickcount1 >= 1) {
                        result = 2
                        clickcount1 = 0
                    }
                }
                2 -> {
                    clickcount2 += 1
                    var count2 = (2..3).random()
                    if (clickcount2 >= count2) {
                        result = 3
                        clickcount2 = 0
                    }
                }
                3 -> {
                    clickcount3 += 1
                    if (clickcount3 >= 1) {
                        result = 4
                        clickcount3 = 0
                    }
                }
                4 -> {
                    clickcount4 += 1
                    if (clickcount4 >= 1) {
                        result = 1
                        clickcount4 = 0
                    }
                }
            } },
            colors = ButtonDefaults.textButtonColors(contentColor = Color.Black),
            modifier = Modifier
                .padding(10.dp)) {
            Text(stringResource(textResource))
        }
    }
}

@Preview
@Composable
fun lemonPrew() {
    lemonadeShow(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}