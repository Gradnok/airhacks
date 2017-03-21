
package com.airhacks.pizza.notifications.boundary;

import com.airhacks.pizza.configuration.boundary.RaphaelConfigurationProperty;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.inject.Inject;
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

    @Inject
    @RaphaelConfigurationProperty(defaultValue = "4", propertyName = "hugo")
    private String seconds;

    @Resource
    TimerService service;
    private Timer timer;

    @PostConstruct
    public void init() {
        System.out.println("--- seconds: " + this.seconds);
        ScheduleExpression expression = new ScheduleExpression();
        expression.hour("*").minute("*").second("*/" + this.seconds);
        this.timer = service.createCalendarTimer(expression);
    }


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

    @Timeout
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
