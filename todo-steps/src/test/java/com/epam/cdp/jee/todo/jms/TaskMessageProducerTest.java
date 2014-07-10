package com.epam.cdp.jee.todo.jms;

import lombok.extern.slf4j.Slf4j;

import java.util.Properties;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

@Slf4j
public class TaskMessageProducerTest {

    private static final String DEFAULT_MESSAGE = "New task";
    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "jms/queue/task";
    private static final String DEFAULT_MESSAGE_COUNT = "1";
    private static final String DEFAULT_USERNAME = "jndi";
    private static final String DEFAULT_PASSWORD = "jndi_123";
    private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
    private static final String PROVIDER_URL = "remote://192.168.56.102:4447";

    @Test
    public void shouldSendMessage() throws NamingException, JMSException {

        final Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
        env.put(Context.PROVIDER_URL, System.getProperty(Context.PROVIDER_URL, PROVIDER_URL));
        env.put(Context.SECURITY_PRINCIPAL, System.getProperty("username", DEFAULT_USERNAME));
        env.put(Context.SECURITY_CREDENTIALS, System.getProperty("password", DEFAULT_PASSWORD));
        Context context;
        context = new InitialContext(env);

        ConnectionFactory connectionFactory;
        connectionFactory = (ConnectionFactory) context.lookup(DEFAULT_CONNECTION_FACTORY);

        Destination destination;
        destination = (Destination) context.lookup(DEFAULT_DESTINATION);

        Connection connection;
        connection = connectionFactory.createConnection(DEFAULT_USERNAME, DEFAULT_PASSWORD);

        Session session;
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      session.run();
        org.jboss.naming.remote.client.InitialContextFactory tt;

        MessageProducer producer;
        producer = session.createProducer(destination);

        connection.start();

        TextMessage message;
        message = session.createTextMessage(DEFAULT_MESSAGE);
        producer.send(message);

//        MessageConsumer consumer = session.createConsumer(destination);
//        TextMessage receivedMessage = (TextMessage) consumer.receive(1000);
//        log.info("Received message is: '{}' ", receivedMessage.getText());

        context.close();
        connection.close();
    }
}
