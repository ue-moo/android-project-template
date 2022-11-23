package com.github.uemoo.feature.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun SampleRoot() {
    SampleScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SampleScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(
                text = "SampleScreen"
            )
        }
    }
}

@Preview
@Composable
fun SampleScreenPreview() {
    SampleScreen()
}
