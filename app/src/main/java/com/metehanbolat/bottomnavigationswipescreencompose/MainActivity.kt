package com.metehanbolat.bottomnavigationswipescreencompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.metehanbolat.bottomnavigationswipescreencompose.ui.theme.BottomNavigationSwipeScreenComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavigationSwipeScreenComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BottomNavigationWithSwipeScreen()
                }
            }
        }
    }
}

@Composable
fun BottomNavigationWithSwipeScreen() {
    val scope = rememberCoroutineScope()
    val images = listOf(
        R.drawable.ic_launcher_background
    )
}
