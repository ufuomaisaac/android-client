/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.model.objects.clients

import com.mifos.core.model.utils.Parcelable
import com.mifos.core.model.utils.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class ClientAddressRequest(
    var placeId: String? = null,

    @SerialName("description")
    var placeAddress: String? = null,

    var latitude: Double? = null,

    var longitude: Double? = null,

    // Defaults
    var dateFormat: String? = null,

    var locale: String? = null,
) : Parcelable
