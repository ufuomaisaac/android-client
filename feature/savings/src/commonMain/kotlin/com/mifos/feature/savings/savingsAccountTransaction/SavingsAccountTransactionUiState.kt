/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.feature.savings.savingsAccountTransaction

import com.mifos.core.model.objects.account.saving.SavingsAccountTransactionResponse
import com.mifos.room.entities.templates.savings.SavingsAccountTransactionTemplateEntity

/**
 * Created by Aditya Gupta on 13/08/23.
 */
sealed class SavingsAccountTransactionUiState {

    data object ShowProgressbar : SavingsAccountTransactionUiState()

    data class ShowError(val message: String) : SavingsAccountTransactionUiState()

    data class ShowSavingAccountTemplate(val savingsAccountTransactionTemplate: SavingsAccountTransactionTemplateEntity) :
        SavingsAccountTransactionUiState()

    data class ShowTransactionSuccessfullyDone(val savingsAccountTransactionResponse: SavingsAccountTransactionResponse) :
        SavingsAccountTransactionUiState()

    data object ShowSavingAccountTransactionExistInDatabase : SavingsAccountTransactionUiState()

    data object ShowSavingAccountTransactionDoesNotExistInDatabase : SavingsAccountTransactionUiState()
}
