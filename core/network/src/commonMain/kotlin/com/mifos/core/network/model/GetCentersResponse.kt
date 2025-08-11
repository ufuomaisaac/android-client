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
 * GetCentersResponse
 *
 * @param pageItems
 * @param totalFilteredRecords
 */

@Serializable
data class GetCentersResponse(

    val pageItems: Set<GetCentersPageItems>? = null,

    val totalFilteredRecords: Int? = null,

)
