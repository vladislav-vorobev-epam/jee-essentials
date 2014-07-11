package com.epam.cdp.jee.todo.jms.listener;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.joda.time.DateTime;

import com.epam.cdp.jee.todo.persistence.Jpa;
import com.epam.cdp.jee.todo.persistence.entity.Task;
import com.epam.cdp.jee.todo.persistence.repository.TaskRepository;

@MessageDriven(name = "TaskQueueMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "java:jboss/exported/jms/queue/task")})
@Slf4j
public class TaskMessageListener implements MessageListener {

    @Inject
    @Jpa
    private TaskRepository taskRepository;

    @Override
    public void onMessage(final Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String taskName = textMessage.getText();
            Task task = new Task(new Date().getTime(), taskName, new DateTime());
            taskRepository.add(task);
        } catch (JMSException e) {
            log.error("Unable to process JMS message", e);
        }
    }
}
