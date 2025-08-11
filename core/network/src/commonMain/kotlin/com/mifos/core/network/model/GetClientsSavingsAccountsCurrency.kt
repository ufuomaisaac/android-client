/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.network.model

import kotlinx.serialization.Serializable

/**
 *
 *
 * @param code
 * @param decimalPlaces
 * @param displayLabel
 * @param displaySymbol
 * @param name
 * @param nameCode
 */

@Serializable
data class GetClientsSavingsAccountsCurrency(

    val code: String? = null,

    val decimalPlaces: Int? = null,

    val displayLabel: String? = null,

    val displaySymbol: String? = null,

    val name: String? = null,

    val nameCode: String? = null,

)
