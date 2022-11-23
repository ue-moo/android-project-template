package com.github.uemoo.androidprojecttemplate.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.github.uemoo.androidprojecttemplate.ui.theme.AndroidProjectTemplateTheme
import com.github.uemoo.feature.sample.SampleNavGraph
import com.github.uemoo.feature.sample.sample

@Composable
internal fun SampleApp() {
    val navController = rememberNavController()

    AndroidProjectTemplateTheme {
        NavHost(
            navController = navController,
            startDestination = SampleNavGraph.sampleRoute,
            modifier = Modifier.fillMaxSize(),
        ) {
            sample()
        }
    }
}
