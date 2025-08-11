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
import androidclient.core.ui.generated.resources.core_ui_core_common_working
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mifos.core.designsystem.theme.MifosTheme
import com.mifos.core.ui.util.DevicePreview
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MifosRadioButtonDialog(
    titleResId: StringResource,
    selectedItem: String,
    items: Array<String>,
    selectItem: (item: String, index: Int) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BasicAlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = modifier,
    ) {
        Card {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = stringResource(titleResId))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 500.dp),
                ) {
                    itemsIndexed(items = items) { index, item ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clickable {
                                    onDismissRequest.invoke()
                                    selectItem.invoke(item, index)
                                }
                                .fillMaxWidth(),
                        ) {
                            RadioButton(
                                selected = (item == selectedItem),
                                onClick = {
                                    onDismissRequest.invoke()
                                    selectItem.invoke(item, index)
                                },
                            )
                            Text(
                                text = item,
                                modifier = Modifier.padding(start = 4.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}

@DevicePreview
@Composable
fun PreviewRadioButtonDialog() {
    MifosTheme {
        MifosRadioButtonDialog(
            titleResId = Res.string.core_ui_core_common_working,
            items = arrayOf("1", "2", "3"),
            selectedItem = "1",
            onDismissRequest = { },
            selectItem = { _, _ -> },
        )
    }
}
