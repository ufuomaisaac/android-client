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

expect object ImageUtil {
    val DEFAULT_MAX_WIDTH: Float
    val DEFAULT_MAX_HEIGHT: Float

    fun compressImage(
        decodedBytes: ByteArray,
        maxWidth: Float = DEFAULT_MAX_WIDTH,
        maxHeight: Float = DEFAULT_MAX_HEIGHT,
    ): ByteArray
}
