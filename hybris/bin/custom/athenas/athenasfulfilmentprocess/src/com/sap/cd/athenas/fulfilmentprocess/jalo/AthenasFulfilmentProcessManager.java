/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.sap.cd.athenas.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.sap.cd.athenas.fulfilmentprocess.constants.AthenasFulfilmentProcessConstants;

@SuppressWarnings("PMD")
public class AthenasFulfilmentProcessManager extends GeneratedAthenasFulfilmentProcessManager
{
	public static final AthenasFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (AthenasFulfilmentProcessManager) em.getExtension(AthenasFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
