/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.feature.loan.loanAccount

import com.mifos.core.model.objects.organisations.LoanProducts
import org.jetbrains.compose.resources.StringResource

sealed class LoanAccountUiState {

    data object Loading : LoanAccountUiState()

    data class AllLoan(val productLoans: List<LoanProducts>) : LoanAccountUiState()

    data class Error(val message: StringResource) : LoanAccountUiState()

    data object LoanAccountCreatedSuccessfully : LoanAccountUiState()
}
