package com.example.application04102023

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.application04102023.ui.theme.Application04102023Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}
@Composable
fun App(){
    Application04102023Theme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(Modifier.height(80.dp)) {
                    SimpleCenterAlignedTopAppBar()
                }
                SimpleTextFieldSample("Nome")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Endereço")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Bairro")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Cep")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                SimpleTextFieldSample("Cidade")
                Divider(
                    color = Color.Transparent,
                    modifier = Modifier.height(20.dp)
                )
                ElevatedButtonSample()
            }
        }
    }
}
@Preview(widthDp = 400, heightDp = 600)
@Composable
fun AppPreview(){
    App()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleCenterAlignedTopAppBar() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        "PH Centered TopAppBar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
            }
        }
    )
}
@Composable
@Preview
fun SimpleCenterAlignedTopAppBarPreview(){
    SimpleCenterAlignedTopAppBar()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextFieldSample(label: String) {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = "it" },
        label = { Text(label) },
        singleLine = true
    )
}
@Preview
@Composable
fun SimpleTextFieldSamplePreview(){
    SimpleTextFieldSample("Nome")
}
@Composable
fun ElevatedButtonSample() {
    ElevatedButton(onClick = { /* Do something! */ }) { Text("Cadastrar") }
}
@Preview
@Composable
fun ElevatedButtonSamplePreview(){
    ElevatedButtonSample()
}