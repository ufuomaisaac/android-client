/*
 * Copyright 2024 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.room.entities.zipmodels

import com.mifos.room.entities.accounts.savings.SavingsAccountWithAssociationsEntity
import com.mifos.room.entities.templates.savings.SavingsAccountTransactionTemplateEntity

/**
 * Created by Rajan Maurya on 21/08/16.
 */
class SavingsAccountAndTransactionTemplate {
    var savingsAccountWithAssociations: SavingsAccountWithAssociationsEntity? = null
    var savingsAccountTransactionTemplate: SavingsAccountTransactionTemplateEntity? = null

    constructor()
    constructor(
        savingsAccountWithAssociations: SavingsAccountWithAssociationsEntity?,
        savingsAccountTransactionTemplate: SavingsAccountTransactionTemplateEntity?,
    ) {
        this.savingsAccountWithAssociations = savingsAccountWithAssociations
        this.savingsAccountTransactionTemplate = savingsAccountTransactionTemplate
    }

    override fun toString(): String {
        return "SavingsAccountAndTransactionTemplate{" +
            "savingsAccountWithAssociations=" + savingsAccountWithAssociations +
            ", savingsAccountTransactionTemplate=" + savingsAccountTransactionTemplate +
            '}'
    }
}
