package com.github.uemoo.feature.sample

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.sample() {
    composable(route = SampleNavGraph.sampleRoute) {
        SampleRoot()
    }
}

object SampleNavGraph {
    const val sampleRoute = "sample"
}
