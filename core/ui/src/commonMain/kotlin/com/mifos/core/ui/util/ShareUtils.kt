/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.ui.util

import androidx.compose.ui.graphics.ImageBitmap

expect object ShareUtils {

    fun shareText(text: String)

    suspend fun shareImage(title: String, image: ImageBitmap)

    suspend fun shareImage(title: String, byte: ByteArray)

    fun openAppInfo()

    fun shareApp()

    fun callHelpline()

    fun mailHelpline()

    fun openUrl(url: String)

    fun ossLicensesMenuActivity()

    fun restartApplication()
}
