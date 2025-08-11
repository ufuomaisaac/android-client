/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.room.entities.client

import com.mifos.room.entities.Timeline

/**
 * Created by ishankhanna on 09/02/14.
 */
data class PageItem(
    val id: Int = 0,

    val accountNo: String? = null,

    val status: ClientStatusEntity? = null,

    val isActive: Boolean = false,

    val activationDate: List<Int> = emptyList(),

    val firstname: String? = null,

    val middlename: String? = null,

    val lastname: String? = null,

    val displayName: String? = null,

    val officeId: Int = 0,

    val officeName: String? = null,

    val staffId: Int = 0,

    val staffName: String? = null,

    val timeline: Timeline? = null,

    val fullname: String? = null,

    val imageId: Int = 0,

    val isImagePresent: Boolean = false,

    val externalId: String? = null,
)
