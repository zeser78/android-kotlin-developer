package com.xpaso.codebasicscodelab2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable

import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.xpaso.codebasicscodelab2.ui.theme.CodeBasicsCodeLab2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
        MyApp {
           MyScreenContent()
        }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    CodeBasicsCodeLab2Theme {
        Surface(color = Color.Blue) {
            content()
        }
    }
}
//fun MyApp() {
//    CodeBasicsCodeLab2Theme {
//        // A surface container using the 'background' color from the theme
//        Surface(color = Color.Blue) {
//            Greeting("Sergio")
//        }
//    }
//}




/// Using variables
@Composable
fun MyScreenContent(names: List<String> = List(1000) {"Hello Android #$it"}) {
//    fun MyScreenContent(names: List<String> = listOf("Sergio", "Olivares")) {
    //
    val counterState =  remember {
        mutableStateOf(0)
    }
    // available fillMaxSize and fillMaxWidth
    Column(modifier = Modifier.fillMaxHeight()) {
//        Column(modifier = Modifier.weight(1f)) {
        NameList(names, Modifier.weight(1f))
//        for (name in names) {
//            Greeting(name)
//            Divider(color = Color.Black)
//        }

//Divider(color = Color.Transparent, thickness = 32.dp)
//        Counter()
            Counter(
                count = counterState.value,
                updateCount = { newCount -> counterState.value = newCount }
            )

    }
}
//
//@Composable
//fun MyScreenContent() {
//    Column {
//        Greeting(name = "Oli")
//        Divider(color = Color.Black)
//        Greeting(name = "Ser")
//    }
//}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) { name ->
//        for (name in names) {
            Greeting(name = name)
            Divider(color = Color.Black)
        }
    }
}

// Creating a container


@Composable
fun Greeting(name: String) {
    // Animation
    var isSelected by remember {
        mutableStateOf(false)
    }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)
        Text(text = "Hello $name!", modifier = Modifier.padding(24.dp).background(color = backgroundColor).clickable(onClick = {isSelected = !isSelected}))
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = {updateCount(count+1)},
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 5) Color.Green else Color.White
        )) {
        Text(text = "I've been clicked $count times")
    }
//fun Counter() {
//val count = remember {
//    mutableStateOf(0)
//}

//    Button(onClick = { count.value++ }) {
//        Text("I've been clicked ${count.value} times")
//    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}