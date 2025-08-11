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
 * @param accountNo
 * @param currency
 * @param depositType
 * @param id
 * @param productId
 * @param productName
 * @param shortProductName
 * @param status
 */

@Serializable
data class GetClientsSavingsAccounts(

    val accountNo: String? = null,

    val currency: GetClientsSavingsAccountsCurrency? = null,

    val depositType: GetClientsSavingsAccountsDepositType? = null,

    val id: Long? = null,

    val productId: Long? = null,

    val productName: String? = null,

    val shortProductName: String? = null,

    val status: GetClientsSavingsAccountsStatus? = null,

)
