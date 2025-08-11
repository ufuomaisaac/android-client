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
import androidclient.core.ui.generated.resources.core_ui_ic_centers_24dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mifos.core.designsystem.theme.MifosTheme
import com.mifos.core.ui.util.DevicePreview
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun MifosTextTitleDescSingleLine(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            style = MaterialTheme.typography.labelMedium,
            text = title,
            modifier = Modifier
                .alpha(0.7f),
        )

        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = description,
        )
    }
}

@Composable
fun MifosTextTitleDescDoubleLine(
    title: String,
    description: String,
    descriptionStyle: TextStyle,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
                .alpha(0.7f)
                .fillMaxWidth(),
        )
        Text(
            text = description,
            style = descriptionStyle,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Composable
fun MifosTextTitleDescDrawableSingleLine(
    title: String,
    description: String,
    imageResId: DrawableResource,
    modifier: Modifier = Modifier,
    imageSize: Dp = 14.dp,
    onDrawableClick: () -> Unit = {},
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            style = MaterialTheme.typography.labelMedium,
            text = title,
            modifier = Modifier
                .weight(1f)
                .alpha(0.7f),
        )
        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = description,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(imageResId),
            contentDescription = "Image",
            modifier = Modifier
                .size(imageSize)
                .clickable { onDrawableClick() },
        )
    }
}

@Composable
fun MifosTitleDescSingleLineEqual(
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            style = MaterialTheme.typography.labelMedium,
            text = title,
            modifier = Modifier
                .alpha(0.7f)
                .weight(1f),
        )

        Text(
            style = MaterialTheme.typography.bodyMedium,
            text = description,
            modifier = Modifier.weight(1f),
        )
    }
}

@DevicePreview
@Composable
fun MifosTextTitleDescSingleLinePreview(
    modifier: Modifier = Modifier,
) {
    MifosTheme {
        MifosTextTitleDescSingleLine(
            title = "MifosTextTitleDescSingleLine Title",
            description = "MifosTextTitleDescSingleLine Description",
            modifier = modifier,
        )
    }
}

@DevicePreview
@Composable
fun MifosTextTitleDescDoubleLinePreview(
    modifier: Modifier = Modifier,
) {
    MifosTheme {
        MifosTextTitleDescDoubleLine(
            title = "MifosTextTitleDescDoubleLine Title",
            description = "MifosTextTitleDescDoubleLine Description",
            descriptionStyle = MaterialTheme.typography.bodyMedium,
            modifier = modifier,
        )
    }
}

@DevicePreview
@Composable
fun MifosTextTitleDescDrawableSingleLinePreview(
    modifier: Modifier = Modifier,
) {
    MifosTheme {
        MifosTextTitleDescDrawableSingleLine(
            title = "MifosTextTitleDescDrawableSingleLine Title",
            description = "MifosTextTitleDescDrawableSingleLine Description",
            imageResId = Res.drawable.core_ui_ic_centers_24dp,
            modifier = modifier,
        )
    }
}

@DevicePreview
@Composable
fun MifosTitleDescSingleLineEqualPreview(
    modifier: Modifier = Modifier,
) {
    MifosTheme {
        MifosTitleDescSingleLineEqual(
            title = "MifosTitleDescSingleLineEqual Title",
            description = "MifosTitleDescSingleLineEqual Description",
            modifier = modifier,
        )
    }
}
