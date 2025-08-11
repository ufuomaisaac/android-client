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

/**
 * Converts the given [Int] to a [PasswordStrength]. A `null` value is returned if this value is
 * not in the [0, 4] range.
 */
@Suppress("MagicNumber")
fun Int.toPasswordStrengthOrNull(): PasswordStrength? =
    when (this) {
        0 -> PasswordStrength.LEVEL_0
        1 -> PasswordStrength.LEVEL_1
        2 -> PasswordStrength.LEVEL_2
        3 -> PasswordStrength.LEVEL_3
        4 -> PasswordStrength.LEVEL_4
        5 -> PasswordStrength.LEVEL_5
        else -> null
    }

/**
 * Converts the given [PasswordStrength] to an [Int].
 */
@Suppress("MagicNumber")
fun PasswordStrength.toInt(): Int =
    when (this) {
        PasswordStrength.LEVEL_0 -> 0
        PasswordStrength.LEVEL_1 -> 1
        PasswordStrength.LEVEL_2 -> 2
        PasswordStrength.LEVEL_3 -> 3
        PasswordStrength.LEVEL_4 -> 4
        PasswordStrength.LEVEL_5 -> 5
    }
