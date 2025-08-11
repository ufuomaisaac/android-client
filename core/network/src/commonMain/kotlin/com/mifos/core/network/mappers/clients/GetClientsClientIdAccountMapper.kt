/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.network.mappers.clients

import com.mifos.core.network.data.AbstractMapper
import com.mifos.core.network.model.GetClientsClientIdAccountsResponse
import com.mifos.core.network.model.GetClientsLoanAccounts
import com.mifos.core.network.model.GetClientsLoanAccountsStatus
import com.mifos.core.network.model.GetClientsLoanAccountsType
import com.mifos.core.network.model.GetClientsSavingsAccounts
import com.mifos.core.network.model.GetClientsSavingsAccountsCurrency
import com.mifos.core.network.model.GetClientsSavingsAccountsDepositType
import com.mifos.core.network.model.GetClientsSavingsAccountsStatus
import com.mifos.room.entities.accounts.ClientAccounts
import com.mifos.room.entities.accounts.loans.LoanAccountEntity
import com.mifos.room.entities.accounts.loans.LoanTypeEntity
import com.mifos.room.entities.accounts.savings.SavingAccountCurrencyEntity
import com.mifos.room.entities.accounts.savings.SavingAccountDepositTypeEntity
import com.mifos.room.entities.accounts.savings.SavingsAccountEntity
import com.mifos.room.entities.accounts.savings.SavingsAccountStatusEntity

/**
 * Created by Aditya Gupta on 30/08/23.
 */

object GetClientsClientIdAccountMapper :
    AbstractMapper<GetClientsClientIdAccountsResponse, ClientAccounts>() {

    override fun mapFromEntity(entity: GetClientsClientIdAccountsResponse): ClientAccounts {
        return ClientAccounts(
            savingsAccounts = entity.savingsAccounts?.map {
                SavingsAccountEntity(
                    id = it.id?.toInt(),
                    accountNo = it.accountNo,
                    productId = it.productId?.toInt(),
                    productName = it.productName,
                    depositType = it.depositType?.let { deposit ->
                        SavingAccountDepositTypeEntity(
                            id = deposit.id?.toInt(),
                            code = deposit.code,
                            value = deposit.value,
                        )
                    },
                    status = it.status?.let { status ->
                        SavingsAccountStatusEntity(
                            id = status.id?.toInt(),
                            code = status.code,
                            value = status.value,
                            submittedAndPendingApproval = status.submittedAndPendingApproval,
                            approved = status.approved,
                            rejected = status.rejected,
                            withdrawnByApplicant = status.withdrawnByApplicant,
                            active = status.active,
                            closed = status.closed,
                        )
                    },
                    currency = it.currency?.let { currency ->
                        SavingAccountCurrencyEntity(
                            code = currency.code,
                            name = currency.name,
                            nameCode = currency.nameCode,
                            decimalPlaces = currency.decimalPlaces,
                            displaySymbol = currency.displaySymbol,
                            displayLabel = currency.displayLabel,
                        )
                    },
                )
            } ?: emptyList(),

            loanAccounts = entity.loanAccounts?.map {
                LoanAccountEntity(
                    id = it.id?.toInt(),
                    accountNo = it.accountNo,
                    externalId = it.externalId ?: "",
                    productId = it.productId?.toInt(),
                    productName = it.productName,
                    status = it.status?.let { status ->
                        com.mifos.room.entities.accounts.loans.LoanStatusEntity(
                            id = status.id?.toInt(),
                            code = status.code,
                            value = status.description,
                            pendingApproval = status.pendingApproval,
                            waitingForDisbursal = status.waitingForDisbursal,
                            active = status.active,
                            closedObligationsMet = status.closedObligationsMet,
                            closedWrittenOff = status.closedWrittenOff,
                            closedRescheduled = status.closedRescheduled,
                            closed = status.closed,
                            overpaid = status.overpaid,
                        )
                    },
                    loanType = it.loanType?.let { loanType ->
                        LoanTypeEntity(
                            id = loanType.id?.toInt(),
                            code = loanType.code,
                            value = loanType.description,
                        )
                    },
                    loanCycle = it.loanCycle,
                )
            } ?: emptyList(),
        )
    }

    override fun mapToEntity(domainModel: ClientAccounts): GetClientsClientIdAccountsResponse {
        return GetClientsClientIdAccountsResponse(
            savingsAccounts = domainModel.savingsAccounts.map {
                GetClientsSavingsAccounts(
                    id = it.id?.toLong(),
                    accountNo = it.accountNo,
                    productId = it.productId?.toLong(),
                    productName = it.productName,
                    depositType = GetClientsSavingsAccountsDepositType(
                        id = it.depositType?.id?.toLong(),
                        code = it.depositType?.code,
                        value = it.depositType?.value,
                    ),
                    status = GetClientsSavingsAccountsStatus(
                        id = it.status?.id?.toLong(),
                        code = it.status?.code,
                        value = it.status?.value,
                        submittedAndPendingApproval = it.status?.submittedAndPendingApproval,
                        approved = it.status?.approved,
                        rejected = it.status?.rejected,
                        withdrawnByApplicant = it.status?.withdrawnByApplicant,
                        active = it.status?.active,
                        closed = it.status?.closed,
                    ),
                    currency = GetClientsSavingsAccountsCurrency(
                        code = it.currency!!.code,
                        name = it.currency!!.name,
                        nameCode = it.currency!!.nameCode,
                        decimalPlaces = it.currency!!.decimalPlaces,
                        displaySymbol = it.currency!!.displaySymbol,
                    ),
                )
            }.toSet(),
            loanAccounts = domainModel.loanAccounts.map {
                GetClientsLoanAccounts(
                    id = it.id?.toLong(),
                    accountNo = it.accountNo,
                    externalId = it.externalId,
                    productId = it.productId?.toLong(),
                    productName = it.productName,
                    status = GetClientsLoanAccountsStatus(
                        id = it.status?.id?.toLong(),
                        code = it.status?.code,
                        description = it.status?.value,
                        pendingApproval = it.status?.pendingApproval,
                        waitingForDisbursal = it.status?.waitingForDisbursal,
                        active = it.status?.active,
                        closedObligationsMet = it.status?.closedObligationsMet,
                        closedWrittenOff = it.status?.closedWrittenOff,
                        closedRescheduled = it.status?.closedRescheduled,
                        closed = it.status?.closed,
                        overpaid = it.status?.overpaid,
                    ),
                    loanType = GetClientsLoanAccountsType(
                        id = it.loanType?.id?.toLong(),
                        code = it.loanType?.code,
                        description = it.loanType?.value,
                    ),
                    loanCycle = it.loanCycle,
                )
            }.toSet(),
        )
    }
}
