/*
 * Copyright (c) 2023-2024, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.api.server.organization.configs.v1.factories;

import org.wso2.carbon.identity.api.server.organization.configs.v1.OrganizationConfigsApiService;
import org.wso2.carbon.identity.api.server.organization.configs.v1.impl.OrganizationConfigsApiServiceImpl;

/**
 * Factory class for OrganizationConfigsApiService.
 */
public class OrganizationConfigsApiServiceFactory {

   private final static OrganizationConfigsApiService SERVICE = new OrganizationConfigsApiServiceImpl();

   /**
    * Get OrganizationConfigsApiService.
    *
    * @return OrganizationConfigsApiService.
    */
   public static OrganizationConfigsApiService getOrganizationConfigsApi()
   {
      return SERVICE;
   }
}
