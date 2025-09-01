/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package cmp.navigation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mifos.core.designsystem.theme.DesignToken
import com.mifos.core.designsystem.theme.MifosTypography
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RowScope.MifosNavigationBarItem(
    contentDescriptionRes: StringResource,
    selectedIconRes: ImageVector,
    label: StringResource,
    unselectedIconRes: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBarItem(
        icon = {
            Icon(
                imageVector = if (isSelected) selectedIconRes else unselectedIconRes,
                contentDescription = stringResource(contentDescriptionRes),
            )
        },
        label = {
            Text(
                modifier = Modifier.padding(DesignToken.padding.extraSmall),
                text = stringResource(label),
                style = MifosTypography.labelMedium,
                color = MaterialTheme.colorScheme.secondary,
            )
        },
        selected = isSelected,
        alwaysShowLabel = true,
        onClick = onClick,
        modifier = modifier.padding(vertical = 6.dp),
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.primary,
            unselectedIconColor = MaterialTheme.colorScheme.primary,
            indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
        ),
    )
}
