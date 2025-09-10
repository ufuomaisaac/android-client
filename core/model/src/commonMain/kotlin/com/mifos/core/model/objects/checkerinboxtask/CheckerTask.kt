/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.model.objects.checkerinboxtask

import com.mifos.core.model.utils.Parcelable
import com.mifos.core.model.utils.Parcelize
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Parcelize
@Serializable
data class CheckerTask(
    val id: Int,
    val madeOnDate: Long,
    val processingResult: String,
    val maker: String,
    val actionName: String,
    val entityName: String,
    val resourceId: String,
) : Parcelable {

    var selectedFlag = false

    @OptIn(ExperimentalTime::class)
    fun getDate(): String {
        val instant = Instant.fromEpochMilliseconds(madeOnDate)
        val localDate = instant.toLocalDateTime(TimeZone.currentSystemDefault()).date
        return "${localDate.day} ${
            localDate.month.name.take(3).lowercase().replaceFirstChar { it.uppercase() }
        } ${localDate.year}"
    }

    @OptIn(ExperimentalTime::class)
    fun getTimeStamp(): Instant {
        return Instant.fromEpochMilliseconds(madeOnDate)
    }
}
