/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mifos.core.designsystem.theme.DesignToken
import com.mifos.core.designsystem.theme.MifosTheme
import com.mifos.core.designsystem.theme.MifosTypography
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.ui.tooling.preview.PreviewParameter
import org.jetbrains.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun MifosBasicDialog(
    visibilityState: BasicDialogState,
    onDismissRequest: () -> Unit,
): Unit = when (visibilityState) {
    BasicDialogState.Hidden -> Unit
    is BasicDialogState.Shown -> {
        AlertDialog(
            onDismissRequest = onDismissRequest,
            confirmButton = {
                MifosTextButton(
                    content = {
                        Text(text = "Ok")
                    },
                    onClick = onDismissRequest,
                    modifier = Modifier.testTag("AcceptAlertButton"),
                )
            },
            title = visibilityState.title.let {
                {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.testTag("AlertTitleText"),
                    )
                }
            },
            text = {
                Text(
                    text = visibilityState.message,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.testTag("AlertContentText"),
                )
            },
            containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
            modifier = Modifier.semantics {
                testTag = "AlertPopup"
            },
        )
    }
}

@Composable
fun MifosBasicDialog(
    visibilityState: BasicDialogState,
    onConfirm: () -> Unit,
    onDismissRequest: () -> Unit,
    confirmText: String = "Ok",
    dismissText: String = "Cancel",
    icon: @Composable (() -> Unit)? = null,
) {
    when (visibilityState) {
        BasicDialogState.Hidden -> Unit
        is BasicDialogState.Shown -> {
            AlertDialog(
                onDismissRequest = onDismissRequest,
                confirmButton = {
                    Text(
                        text = confirmText,
                        style = MifosTypography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(horizontal = DesignToken.padding.large)
                            .clickable {
                                onConfirm()
                            },
                    )
                },
                dismissButton = {
                    Text(
                        text = dismissText,
                        style = MifosTypography.labelLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .padding(horizontal = DesignToken.padding.large)
                            .clickable {
                                onDismissRequest()
                            },
                    )
                },
                icon = icon,
                title = {
                    Text(
                        text = visibilityState.title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.fillMaxWidth().testTag("AlertTitleText"),
                        textAlign = TextAlign.Center,
                    )
                },
                text = {
                    Text(
                        text = visibilityState.message,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.fillMaxWidth().testTag("AlertContentText"),
                    )
                },
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
                modifier = Modifier.semantics {
                    testTag = "AlertPopup"
                },
            )
        }
    }
}

@Composable
fun MifosBasicDialog(
    onConfirm: () -> Unit,
    onDismissRequest: () -> Unit,
    confirmText: String = "Ok",
    dismissText: String = "Cancel",
    isConfirmEnabled: Boolean = true,
    title: String,
    content: @Composable () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                MifosOutlinedButton(
                    onClick = { onDismissRequest() },
                    text = {
                        Text(
                            text = dismissText,
                            color = MaterialTheme.colorScheme.primary,
                            style = MifosTypography.labelLarge,
                        )
                    },
                    modifier = Modifier.weight(1f),
                )

                Spacer(modifier = Modifier.width(8.dp))

                MifosTextButton(
                    onClick = { onConfirm() },
                    text = {
                        Text(
                            text = confirmText,
                            style = MifosTypography.labelLarge,
                        )
                    },
                    modifier = Modifier.weight(1f),
                    enabled = isConfirmEnabled,
                )
            }
        },
        title = {
            Text(
                text = title,
                style = MifosTypography.titleMediumEmphasized,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("AlertTitleText"),
            )
        },
        text = { content() },
        containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,
        modifier = Modifier.semantics { testTag = "AlertPopup" },
    )
}

@Composable
fun MifosGenericDialog(
    icon: ImageVector,
    iconTint: Color = Color(0xFF4CAF50), // default green
    title: String,
    message: String,
    confirmText: String = "Continue",
    onConfirm: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // 🔹 Icon (customizable)
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = iconTint,
                    modifier = Modifier.size(72.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // 🔹 Title
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
        },
        text = {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            Button(
                onClick = onConfirm,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(confirmText)
            }
        },
        shape = RoundedCornerShape(12.dp),
        containerColor = MaterialTheme.colorScheme.surface
    )
}


@Preview
@Composable
private fun MifosBasicDialog_preview() {
    MifosTheme {
        MifosBasicDialog(
            visibilityState = BasicDialogState.Shown(
                title = "An error has occurred.",
                message = "Username or password is incorrect. Try again.",
            ),
            onDismissRequest = {},
        )
    }
}

/**
 * Models display of a [MifosBasicDialog].
 */
sealed class BasicDialogState {

    data object Hidden : BasicDialogState()

    data class Shown(
        val message: String,
        val title: String = "An Error Occurred!",
    ) : BasicDialogState()
}

class BasicDialogStatePreviewProvider : PreviewParameterProvider<BasicDialogState> {
    override val values: Sequence<BasicDialogState> = sequenceOf(
        BasicDialogState.Shown(
            title = "An error has occurred.",
            message = "Username or password is incorrect. Try again.",
        ),
        BasicDialogState.Shown(
            title = "Confirm Action",
            message = "Are you sure you want to continue?",
        ),
    )
}

@Preview
@Composable
private fun MifosBasicDialogPreview(
    @PreviewParameter(BasicDialogStatePreviewProvider::class)
    state: BasicDialogState,
) {
    MifosTheme {
        MifosBasicDialog(
            visibilityState = state,
            onConfirm = {},
            onDismissRequest = {},
        )
    }
}

@Preview
@Composable
private fun MifosBasicDialogPreview(
) {

    MifosGenericDialog(
        icon = Icons.Default.CheckCircle,
        title = "Action Successful!",
        message = "You have successfully performed the action.\nPlease continue to get back to home.",
        onConfirm = {  },
        onDismissRequest = {  }
    )
}
