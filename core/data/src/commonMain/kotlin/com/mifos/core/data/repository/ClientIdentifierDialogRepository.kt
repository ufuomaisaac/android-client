/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.data.repository

import com.mifos.core.model.objects.noncoreobjects.IdentifierCreationResponse
import com.mifos.core.model.objects.noncoreobjects.IdentifierPayload
import com.mifos.core.model.objects.noncoreobjects.IdentifierTemplate

/**
 * Created by Aditya Gupta on 16/08/23.
 */
interface ClientIdentifierDialogRepository {

    suspend fun getClientIdentifierTemplate(clientId: Int): IdentifierTemplate

    suspend fun createClientIdentifier(
        clientId: Int,
        identifierPayload: IdentifierPayload,
    ): IdentifierCreationResponse
}
