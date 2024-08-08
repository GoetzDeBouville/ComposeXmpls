package com.hellcorp.composenavigationxmpl.feature.myscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hellcorp.composenavigationxmpl.feature.dialog.SpecialDialog
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyScreen(paddingValues: PaddingValues) {
    val scope = rememberCoroutineScope()

    val pagerState = rememberPagerState(pageCount = { 2 })

    val selectedTabIndex by remember { derivedStateOf { pagerState.currentPage } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = paddingValues.calculateTopPadding())
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = selectedTabIndex == 0,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.outline,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                },
                text = { Text(text = "Первый экран") },
            )

            Tab(
                selected = selectedTabIndex == 1,
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.outline,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                },
                text = { Text(text = "Второй экран") },
            )
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            when (page) {
                0 -> FirstScreen()
                1 -> SecondScreen()
            }
        }
    }
}

@Composable
fun FirstScreen() {
    val shouldShowDialog = remember { mutableStateOf(false) }

    SpecialDialog(
        visible = shouldShowDialog.value,
        onDismissRequest = { shouldShowDialog.value = false },
        onConfirmation = { shouldShowDialog.value = false },
    )

    Column {
        Text(
            text = "first page",
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .clickable {
                    shouldShowDialog.value = true
                }
        )
    }
}

@Composable
fun SecondScreen() {
    Column {
        Text(
            text = "second page",
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        )
    }
} 