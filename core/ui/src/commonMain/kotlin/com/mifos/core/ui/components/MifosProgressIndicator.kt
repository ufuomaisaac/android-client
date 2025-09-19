/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.ui.components

import androidclient.core.ui.generated.resources.Res
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mifos.core.designsystem.theme.MifosTheme
import com.mifos.core.ui.util.LottieConstants
import io.github.alexzhirkevich.compottie.LottieCompositionSpec
import io.github.alexzhirkevich.compottie.animateLottieCompositionAsState
import io.github.alexzhirkevich.compottie.rememberLottieComposition
import io.github.alexzhirkevich.compottie.rememberLottiePainter
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun MifosProgressIndicator(
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes(LottieConstants.LOADING_ANIMATION).decodeToString(),
        )
    }
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = Int.MAX_VALUE,
    )

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = rememberLottiePainter(
                composition = composition,
                progress = { progress },
            ),
            contentDescription = "Lottie animation",
        )
    }
}

@Composable
fun MifosProgressIndicatorOverlay(
    modifier: Modifier = Modifier.fillMaxSize(),
) {
    val composition by rememberLottieComposition {
        LottieCompositionSpec.JsonString(
            Res.readBytes(LottieConstants.LOADING_ANIMATION).decodeToString(),
        )
    }
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = Int.MAX_VALUE,
    )

    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.7f))
            .clickable(
                enabled = false,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) { },
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = rememberLottiePainter(
                composition = composition,
                progress = { progress },
            ),
            contentDescription = "Loading animation",
        )
    }
}

@Composable
fun MifosPagingAppendProgress(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .padding(8.dp),
            strokeWidth = 4.dp,
        )
    }
}

@Preview
@Composable
private fun Loading_Preview() {
    MifosTheme {
        MifosProgressIndicator()
    }
}

@Preview
@Composable
private fun Overlay_Loading_Preview() {
    MifosTheme {
        MifosProgressIndicatorOverlay()
    }
}

@Preview
@Composable
private fun MifosPagingAppendProgressPreview() {
    MaterialTheme {
        MifosPagingAppendProgress()
    }
}
