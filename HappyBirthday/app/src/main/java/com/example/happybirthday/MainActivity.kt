package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(message = stringResource(R.string.happy_birthday_text), from = stringResource(
                        R.string.signature_text
                    ))
                }
            }
        }
    }
}

@Composable
fun GreetingText(from: String ,message: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            from = from,
            message = message,
            modifier = Modifier
                .align(alignment = Alignment.Center)
        )
    }
}

/*@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        //GreetingText(message = "Happy Birthday PH!", from ="From Paulo")
        GreetingImage(
            stringResource(R.string.happy_birthday_text),
            stringResource(R.string.signature_text),
        )
    }
}*/

@Composable
fun  LearnTogether(){
    val image = painterResource(R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.jetpack_compose_tutorial),
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top=16.dp, bottom = 16.dp)
        )
        Text(
            text = stringResource(R.string.jetpack_compose_is),
            modifier = Modifier
                .padding(top=16.dp, bottom = 16.dp)
            )
        Text(
            text = stringResource(R.string.text_tutorial),
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(top=16.dp, bottom = 16.dp)
            )
    }
}

/*@Preview(showBackground = true)
@Composable
fun  LearnTogetherPreview(){
    LearnTogether()
}*/

@Composable
fun TaskManagerCompleted(){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = R.drawable.ic_task_completed),
            contentDescription = null,
        )
        Text(
            text = "All tasks completed",
            Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskManagerCompletedPreview(){
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        TaskManagerCompleted()
    }
}