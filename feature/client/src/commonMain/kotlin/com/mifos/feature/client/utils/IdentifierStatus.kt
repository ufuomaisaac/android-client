/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.feature.client.utils

import com.mifos.core.ui.components.Status

fun getClientIdentifierStatus(status: String?): Status? {
    return if (status != null) {
        if (status.lowercase().endsWith("inactive")) {
            Status.Inactive
        } else if (status.lowercase()
                .endsWith("active")
        ) {
            Status.Active
        } else {
            Status.Pending
        }
    } else {
        null
    }
}
