package com.ochinedu.dogprofilepage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ochinedu.dogprofilepage.ui.theme.DogProfilePageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DogProfilePageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    ProfilePage()
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var nameState by remember {
        mutableStateOf(value="")
    }

    var name by rememberSaveable {
        mutableStateOf(value="")
    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){
        Text(text="Hello $name")
        Spacer(modifier = Modifier.height(5.dp))
        TextField(value = nameState, onValueChange = {
            nameState = it
        })
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            name = nameState
        }) {
            Text(text = "Display")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DogProfilePageTheme {
        Greeting()
    }
}