
package com.airhacks.pizza.notifications.boundary;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author airhacks.com
 */
@Singleton
@Startup
@ServerEndpoint("/notifications")
public class OrderNotificationEndpoint {

    private Session session;

    @OnOpen
    public void onInit(Session session) {
        this.session = session;
    }

    @OnMessage
    public void onMessage(String message) {
        try {
            this.session.getBasicRemote().sendText("echo from server: " + message);
        } catch (IOException ex) {
            Logger.getLogger(OrderNotificationEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Schedule(minute = "*", second = "*/2", hour = "*")
    public void pushToClient() {
        if (this.session != null && this.session.isOpen()) {
            try {
                this.session.getBasicRemote().sendText("heartbeat --> nothing happened: " + System.currentTimeMillis());
            } catch (IOException ex) {
                Logger.getLogger(OrderNotificationEndpoint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



}
