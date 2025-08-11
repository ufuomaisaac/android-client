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

import com.mifos.core.common.utils.DataState
import com.mifos.room.entities.survey.QuestionDatasEntity
import com.mifos.room.entities.survey.ResponseDatasEntity
import com.mifos.room.entities.survey.SurveyEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Aditya Gupta on 08/08/23.
 */
interface SurveyListRepository {

    fun allSurvey(): Flow<DataState<List<SurveyEntity>>>

    fun databaseSurveys(): Flow<DataState<List<SurveyEntity>>>

    fun getDatabaseQuestionData(surveyId: Int): Flow<DataState<List<QuestionDatasEntity>>>

    fun getDatabaseResponseDatas(questionId: Int): Flow<DataState<List<ResponseDatasEntity>>>
}
