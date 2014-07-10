package com.epam.cdp.jee.todo.jms.listener;

import lombok.extern.slf4j.Slf4j;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(name = "TaskQueueMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:jboss/exported/jms/queue/task") })
@Slf4j
public class TaskMessageListener implements MessageListener {

    @Override
    public void onMessage(final Message message) {
        log.info("Message was received: '{}'", message);
    }
}
