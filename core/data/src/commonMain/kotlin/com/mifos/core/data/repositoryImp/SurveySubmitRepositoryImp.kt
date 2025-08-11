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

import com.mifos.core.common.utils.DataState
import com.mifos.core.common.utils.asDataStateFlow
import com.mifos.core.data.repository.SurveySubmitRepository
import com.mifos.core.model.objects.surveys.Scorecard
import com.mifos.core.network.datamanager.DataManagerSurveys
import kotlinx.coroutines.flow.Flow

/**
 * Created by Aditya Gupta on 13/08/23.
 */
class SurveySubmitRepositoryImp(
    private val dataManagerSurveys: DataManagerSurveys,
) : SurveySubmitRepository {

    override fun submitScore(surveyId: Int, scorecardPayload: Scorecard?): Flow<DataState<Scorecard>> {
        return dataManagerSurveys.submitScore(surveyId, scorecardPayload)
            .asDataStateFlow()
    }
}
