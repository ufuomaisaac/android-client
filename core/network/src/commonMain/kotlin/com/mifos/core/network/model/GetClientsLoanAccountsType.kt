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
 * @param description
 * @param id
 */

@Serializable
data class GetClientsLoanAccountsType(

    val code: String? = null,

    val description: String? = null,

    val id: Long? = null,
)
