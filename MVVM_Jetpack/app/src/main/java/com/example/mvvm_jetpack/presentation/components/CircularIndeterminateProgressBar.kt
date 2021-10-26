package com.example.mvvm_jetpack.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CircularIndeterminateProgressBar(
    isDisplay: Boolean,
    verticalBias: Float
) {
    if (isDisplay) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ){
            val (progressBar) = createRefs()
            val topBias = createGuidelineFromTop(verticalBias)
            CircularProgressIndicator(
                color = MaterialTheme.colors.primary,
                modifier = Modifier.constrainAs(progressBar){
                    top.linkTo(topBias)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }

    }
}