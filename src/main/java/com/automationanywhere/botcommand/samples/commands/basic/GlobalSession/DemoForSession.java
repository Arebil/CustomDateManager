/*
 * Copyright (c) 2022 Automation Anywhere.
 * All rights reserved.
 *
 * This software is the proprietary information of Automation Anywhere.
 * You shall use it only in accordance with the terms of the license agreement
 * you entered into with Automation Anywhere.
 */
package com.automationanywhere.botcommand.samples.commands.basic.GlobalSession;

import com.automationanywhere.toolchain.runtime.session.CloseableSessionObject;

import java.io.IOException;

public class DemoForSession implements CloseableSessionObject
{
    public void setClose(boolean close) {
        this.close = close;
    }

    boolean close=false;
    public String getDemo() {
        return demo;
    }

    public void setDemo(String demo) {
        this.demo = demo;
    }
    public DemoForSession(String demo){
        this.demo=demo;
    }
    String demo;

    @Override
    public boolean isClosed() {
        return close;
    }

    @Override
    public void close() throws IOException {

    }
}
