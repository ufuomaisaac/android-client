/*
 * Copyright 2025 Mifos Initiative
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 *
 * See https://github.com/openMF/android-client/blob/master/LICENSE.md
 */
package com.mifos.core.network.apis

import com.mifos.core.network.model.RetrieveOneResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Query

interface StaffApi {
    /**
     * Retrieve Staff
     * Returns the list of staff members.  Example Requests:  staff     Retrieve a Staff by status  Returns the details of a Staff based on status.  By default it Returns all the ACTIVE Staff.  If status&#x3D;INACTIVE, then it returns all INACTIVE Staff.  and for status&#x3D;ALL, it Returns both ACTIVE and INACTIVE Staff.  Example Requests:  staff?status&#x3D;active
     * Responses:
     *  - 200: OK
     *
     * @param officeId officeId (optional)
     * @param staffInOfficeHierarchy staffInOfficeHierarchy (optional, default to false)
     * @param loanOfficersOnly loanOfficersOnly (optional, default to false)
     * @param status status (optional, default to "active")
     * @return [kotlin.collections.List<RetrieveOneResponse]
     */
    @GET("staff")
    suspend fun retrieveAll16(
        @Query("officeId") officeId: Long? = null,
        @Query("staffInOfficeHierarchy") staffInOfficeHierarchy: Boolean? = false,
        @Query("loanOfficersOnly") loanOfficersOnly: Boolean? = false,
        @Query("status") status: String? = "active",
    ): List<RetrieveOneResponse>
}
