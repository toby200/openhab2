/**
 * Copyright (c) 2010-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.nest.internal.config;

/**
 * The configuration for the Nest bridge, allowing it to talk to Nest.
 *
 * @author David Bennett - initial contribution
 */
public class NestBridgeConfiguration {
    public static final String ACCESS_TOKEN = "accessToken";
    /** Product ID from the Nest product page. */
    public String productId;

    /** Product secret from the Nest product page. */
    public String productSecret;

    public static final String PINCODE = "pincode";
    /** Product pincode from the Nest authorization page. */
    public String pincode;

    /** The access token to use once retrieved from Nest. */
    public String accessToken;
}
