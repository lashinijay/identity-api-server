/*
 * Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.api.expired.password.identification.v1.factories;

import org.wso2.carbon.identity.api.expired.password.identification.common.PasswordExpiryServiceHolder;
import org.wso2.carbon.identity.api.expired.password.identification.v1.core.PasswordExpiredUsersManagementApiService;
import org.wso2.carbon.identity.password.expiry.services.ExpiredPasswordIdentificationService;

/**
 * Factory class for PasswordExpiredUsersManagementApiService.
 */
public class PasswordExpiredUsersManagementApiServiceFactory {

    private static final PasswordExpiredUsersManagementApiService SERVICE;

    static {
        ExpiredPasswordIdentificationService expiredPasswordIdentificationService =
                PasswordExpiryServiceHolder.getExpiredPasswordIdentificationService();

        if (expiredPasswordIdentificationService == null) {
            throw new IllegalStateException("RolePermissionManagementService is not available from OSGi context.");
        }

        SERVICE = new PasswordExpiredUsersManagementApiService(expiredPasswordIdentificationService);
    }

    /**
     * Get PasswordExpiredUsersManagementApiService service instance.
     *
     * @return PasswordExpiredUsersManagementApiService service.
     */
    public static PasswordExpiredUsersManagementApiService getExpiredPasswordIdentificationService() {

        return SERVICE;
    }
}
