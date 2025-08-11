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
 * PostCentersCenterIdRequest
 *
 * @param closureDate
 * @param closureReasonId
 * @param dateFormat
 * @param locale
 */

@Serializable
data class PostCentersCenterIdRequest(

    val closureDate: String? = null,

    val closureReasonId: Long? = null,

    val dateFormat: String? = null,

    val locale: String? = null,

)
