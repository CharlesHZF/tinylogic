/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.importsource.tinylogic.net.httpserver.impl;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.importsource.tinylogic.net.httpserver.HttpServer;
import com.importsource.tinylogic.net.httpserver.HttpsServer;
import com.importsource.tinylogic.net.httpserver.spi.HttpServerProvider;

public class DefaultHttpServerProvider extends HttpServerProvider {
    public HttpServer createHttpServer (InetSocketAddress addr, int backlog) throws IOException {
        return new HttpServerImpl (addr, backlog);
    }

    public HttpsServer createHttpsServer (InetSocketAddress addr, int backlog) throws IOException {
        return new HttpsServerImpl (addr, backlog);
    }
}
