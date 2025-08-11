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
 * PostAuthenticationResponse
 *
 * @param authenticated
 * @param base64EncodedAuthenticationKey
 * @param officeId
 * @param officeName
 * @param organisationalRole
 * @param permissions
 * @param roles
 * @param staffDisplayName
 * @param staffId
 * @param userId
 * @param username
 */

@Serializable
data class PostAuthenticationResponse(

    val authenticated: Boolean? = null,

    val base64EncodedAuthenticationKey: String? = null,

    val officeId: Long? = null,

    val officeName: String? = null,

    val organisationalRole: EnumOptionData? = null,

    val permissions: List<String>? = null,

    val roles: List<RoleData>? = null,

    val staffDisplayName: String? = null,

    val staffId: Long? = null,

    val userId: Long? = null,

    val username: String? = null,
)
