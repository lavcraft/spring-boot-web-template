package sample

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry

/**
 * @author tolkv
 * @version 18/11/14
 */
@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
    void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint('/logs').withSockJS()
    }
}