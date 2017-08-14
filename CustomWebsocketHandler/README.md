This project shows how to extend the existing WebsocketHandler in WSO2 APIM 2.1.0 and inject custom implementation to the flow. 

Installation instructions :

1. Build the project : mvn clean install
2. Copy the generated jar file to APIM_HOME/repository/components/lib directory.
3. Change the Class configured at APIM_HOME/repository/deployment/server/synapse-configs/default/inbound-endpoints/WebSocketInboundEndpoint.xml

<parameter name="ws.pipeline.handler.class">org.wso2.am.custom.CustomWebsocketHandler</parameter>
<!--parameter name="ws.pipeline.handler.class">org.wso2.carbon.apimgt.gateway.handlers.WebsocketHandler</parameter-->

4. Restart the server. 
