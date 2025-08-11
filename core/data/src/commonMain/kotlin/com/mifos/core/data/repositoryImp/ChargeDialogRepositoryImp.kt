/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.data.repositoryImp

import com.mifos.core.data.repository.ChargeDialogRepository
import com.mifos.core.model.objects.clients.ChargeCreationResponse
import com.mifos.core.model.objects.payloads.ChargesPayload
import com.mifos.core.model.objects.template.client.ChargeTemplate
import com.mifos.core.network.DataManager

/**
 * Created by Aditya Gupta on 13/08/23.
 */
class ChargeDialogRepositoryImp(
    private val dataManager: DataManager,
) : ChargeDialogRepository {

    override suspend fun getAllChargesV2(clientId: Int): ChargeTemplate {
        return dataManager.getAllChargesV2(clientId)
    }

    override suspend fun createCharges(
        clientId: Int,
        payload: ChargesPayload,
    ): ChargeCreationResponse {
        return dataManager.createCharges(clientId, payload)
    }
}
