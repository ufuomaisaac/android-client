/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.model.objects.template.saving

import com.mifos.core.model.objects.account.loan.InterestType
import com.mifos.core.model.utils.Parcelable
import com.mifos.core.model.utils.Parcelize
import kotlinx.serialization.Serializable

/*
 * This project is licensed under the open source MPL V2.
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
/**
 * Created by rajan on 13/3/16.
 */
@Parcelize
@Serializable
data class AccountOptions(
    var id: Int? = null,

    var name: String? = null,

    var glCode: Int? = null,

    var disabled: Boolean? = null,

    var manualEntriesAllowed: Boolean? = null,

    var type: InterestType? = null,

    var usage: InterestType? = null,

    var nameDecorated: String? = null,

    var tagId: TagId? = null,
) : Parcelable
