package com.xpaso.composegoogle_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xpaso.composegoogle_2.ui.theme.ComposeGoogle2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeGoogle2Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
//            }
//            Text("Hello World!")
//            Greeting("Sergio")
                    NewsStory()
        }
    }
}

@Composable
fun NewsStory() {
    MaterialTheme {
        val typography = MaterialTheme.typography
    Column(modifier = Modifier.padding(16.dp)) {
        Image(painter = painterResource(R.drawable.header),
        contentDescription = null,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .clip(
                shape
                = RoundedCornerShape((4.dp))
            ),
            contentScale = ContentScale.Crop
            )
        Spacer(modifier = Modifier.height(16.dp))
        Text("A day wandering through the sandhills " +
                "in Shark Fin Cove, and a few of the " +
                "sights I saw",
        style = typography.h6, maxLines = 2, overflow = TextOverflow.Ellipsis)
        Text("Davenport, California", style = typography.body2)
        Surface(color = Color.Blue) {
            Text("July 2021", style = typography.body2)
        }
        }
    }

}

@Preview(showBackground = true, name = "Text Preview")
@Composable
fun DefaultPreview() {
    NewsStory()
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeGoogle2Theme {
//        Greeting("Sergio")
//    }
//}