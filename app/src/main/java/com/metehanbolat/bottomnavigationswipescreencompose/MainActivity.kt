package com.metehanbolat.bottomnavigationswipescreencompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import com.metehanbolat.bottomnavigationswipescreencompose.ui.theme.BottomNavigationSwipeScreenComposeTheme
import kotlinx.coroutines.launch

@ExperimentalPagerApi
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

@ExperimentalPagerApi
@Composable
fun BottomNavigationWithSwipeScreen() {
    val scope = rememberCoroutineScope()
    val images = listOf(
        R.drawable.image_1,
        R.drawable.image_2,
        R.drawable.image_3,
        R.drawable.image_4
    )
    val pageState = rememberPagerState(initialPage = 0)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Bottom Navigation Swipe Screen")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                content = {
                    for (page in images.indices) {
                        BottomNavigationItem(
                            selected = page == pageState.currentPage,
                            onClick = {
                                scope.launch { pageState.animateScrollToPage(page = page) }
                            },
                            icon = {
                                Icon(imageVector = Icons.Default.Home, contentDescription = "Home Icon")
                            },
                            selectedContentColor = Color.Magenta,
                            unselectedContentColor = Color.LightGray,
                            label = {
                                Text(text = "Page ${page + 1}")
                            }
                        )
                    }
                }
            )
        }
    ) {
        VerticalPager(count = images.size, state = pageState) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = "Screen Image",
                modifier = Modifier.fillMaxSize().padding(5.dp),
                contentScale = ContentScale.Crop
            )
        }
    }

}
