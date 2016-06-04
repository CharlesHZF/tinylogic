/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.net.httpserver.*;
import com.sun.net.httpserver.spi.*;

class Event {

    ExchangeImpl exchange;

    protected Event (ExchangeImpl t) {
        this.exchange = t;
    }
}

class WriteFinishedEvent extends Event {
    WriteFinishedEvent (ExchangeImpl t) {
        super (t);
        assert !t.writefinished;
        t.writefinished = true;
    }
}
