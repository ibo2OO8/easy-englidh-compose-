package com.ibrohimapk3.easyenglishcompose.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmarks
import androidx.compose.material.icons.filled.FormatListBulleted
import androidx.compose.material.icons.filled.House
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.ibrohimapk3.easyenglishcompose.presentation.view.pages.AlphabetData
import com.ibrohimapk3.easyenglishcompose.presentation.view.pages.AlphabetList
import com.ibrohimapk3.easyenglishcompose.presentation.view.pages.MyVocabulary
import com.ibrohimapk3.easyenglishcompose.presentation.view.pages.VocabularyList

@Composable
fun AllScreens() {
    var navItemsList = listOf<NavItems>(
        NavItems( Icons.Default.House),
        NavItems( Icons.Default.ListAlt),
        NavItems( Icons.Default.Bookmarks),
        NavItems( Icons.Default.FormatListBulleted),
    )
    var selectIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize().background(Color.White),
        //bottomBar хамма элемента а поен мекнад
        bottomBar = {
            NavigationBar {
                navItemsList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectIndex == index,
                        onClick = {
                            selectIndex = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = null)
                        },
                    )
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectIndex)
    }
}
@Composable
fun ContentScreen(modifier: Modifier = Modifier , selected:Int) {
    when(selected){
        0-> AlphabetData()
        1->VocabularyList()
        2-> MyVocabulary()
        3-> AlphabetList()
    }
}