/*
 *  Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.wso2.am.custom;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.gateway.handlers.WebsocketHandler;

/**
 * Custom web socket frame handler extending the default APIM WebsocketHandler for any customizations.
 */
public class CustomWebsocketHandler extends WebsocketHandler {

    public static final Log log = LogFactory.getLog(CustomWebsocketHandler.class);

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {

        if (msg instanceof WebSocketFrame) {
            log.warn("Websocket frame observed.");
        }

        super.write(ctx, msg, promise);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof FullHttpRequest) {
            String origin = ((FullHttpRequest)msg).headers().get("Origin");
            // The origin can be verified here against any trusted origins to allow e.g. CORS.
            log.warn("HTTP Handshake received with Origin : " + origin);
        }

        super.channelRead(ctx, msg);

    }
}
