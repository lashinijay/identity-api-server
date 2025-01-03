/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.api.server.organization.role.management.v1.factories;

import org.wso2.carbon.identity.api.server.organization.role.management.common.OrganizationRoleManagementServiceHolder;
import org.wso2.carbon.identity.api.server.organization.role.management.v1.service.RoleManagementService;
import org.wso2.carbon.identity.organization.management.role.management.service.RoleManager;
import org.wso2.carbon.identity.organization.management.service.OrganizationUserResidentResolverService;

/**
 * Factory class for RoleManagementService.
 */
public class RoleManagementServiceFactory {

    private RoleManagementServiceFactory() {

    }

    private static class RoleManagementServiceHolder {

        private static final RoleManagementService SERVICE = createServiceInstance();
    }

    private static RoleManagementService createServiceInstance() {

        RoleManager roleManager = getRoleManagerService();
        OrganizationUserResidentResolverService organizationUserResidentResolverService =
                getOrganizationUserResidentResolverService();

        return new RoleManagementService(roleManager, organizationUserResidentResolverService);
    }

    /**
     * Get RoleManagementService.
     *
     * @return RoleManagementService.
     */
    public static RoleManagementService getRoleManagementService() {

        return RoleManagementServiceHolder.SERVICE;
    }

    private static RoleManager getRoleManagerService() {

        RoleManager service = OrganizationRoleManagementServiceHolder.getRoleManager();
        if (service == null) {
            throw new IllegalStateException("RoleManager service is not available from OSGi context.");
        }

        return service;
    }

    private static OrganizationUserResidentResolverService getOrganizationUserResidentResolverService() {

        OrganizationUserResidentResolverService service = OrganizationRoleManagementServiceHolder
                .getOrganizationUserResidentResolverService();
        if (service == null) {
            throw new IllegalStateException("OrganizationUserResidentResolverService is not available " +
                    "from OSGi context.");
        }

        return service;
    }
}
