/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.network.mappers.centers

import com.mifos.core.network.data.AbstractMapper
import com.mifos.core.network.model.GetCentersPageItems
import com.mifos.core.network.model.GetCentersStatus
import com.mifos.room.entities.client.ClientStatusEntity
import com.mifos.room.entities.group.CenterEntity

object CenterMapper : AbstractMapper<GetCentersPageItems, CenterEntity>() {

    override fun mapFromEntity(entity: GetCentersPageItems): CenterEntity {
        return CenterEntity(
            id = entity.id?.toInt(),
            active = entity.active,
            name = entity.name,
            officeName = entity.officeName,
            officeId = entity.officeId?.toInt(),
            hierarchy = entity.hierarchy,
            status = ClientStatusEntity(
                id = entity.status?.id!!.toInt(),
                code = entity.status?.code,
                value = entity.status?.description,
            ),
        )
    }

    override fun mapToEntity(domainModel: CenterEntity): GetCentersPageItems {
        return GetCentersPageItems(
            id = domainModel.id?.toLong(),
            active = domainModel.active,
            name = domainModel.name,
            officeName = domainModel.officeName,
            officeId = domainModel.officeId?.toLong(),
            hierarchy = domainModel.hierarchy,
            status = GetCentersStatus(
                id = domainModel.status?.id?.toLong(),
                code = domainModel.status?.code,
                description = domainModel.status?.value,
            ),
        )
    }
}
