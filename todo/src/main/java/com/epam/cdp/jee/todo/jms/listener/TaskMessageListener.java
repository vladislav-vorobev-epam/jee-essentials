package com.epam.cdp.jee.todo.jms.listener;

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
public class TaskMessageListener implements MessageListener {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(TaskMessageListener.class);

    @Override
    public void onMessage(final Message message) {
        LOGGER.info("Message was received: '{}'", message);
    }
}
