/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.core.internal.icon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This servlet answers requests to /images (which was the openHAB 1 location for icons)
 * with HTTP 301 (permanently moved) with the new location /icon
 *
 * @author Kai Kreuzer
 * @author Markus Rathgeb - using OSGi annotations
 */
@Component(name = "org.openhab.ui.iconforwarder")
public class IconForwarder extends HttpServlet {

    private static final long serialVersionUID = 5220836868829415723L;

    final static private Logger logger = LoggerFactory.getLogger(IconForwarder.class);

    private static final String IMAGES_ALIAS = "/images";

    private HttpService httpService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY, policy = ReferencePolicy.STATIC, unbind = "unsetHttpService")
    protected void setHttpService(HttpService httpService) {
        this.httpService = httpService;
        try {
            this.httpService.registerServlet(IMAGES_ALIAS, this, null, httpService.createDefaultHttpContext());
        } catch (final ServletException | NamespaceException ex) {
            logger.error("Could not register icon forwarder servlet: {}", ex.getMessage());
        }
    }

    protected void unsetHttpService(HttpService httpService) {
        httpService.unregister(IMAGES_ALIAS);
        this.httpService = null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setStatus(301);
        resp.setHeader("Location", "/icon" + req.getPathInfo());
        resp.setHeader("Connection", "close");
    }
}
