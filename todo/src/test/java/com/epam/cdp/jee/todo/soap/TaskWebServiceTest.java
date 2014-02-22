package com.epam.cdp.jee.todo.soap;

import static org.junit.Assert.assertFalse;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.junit.Test;

import com.epam.cdp.jee.todo.soap.client.Task;
import com.epam.cdp.jee.todo.soap.client.TaskWebService;
import com.epam.cdp.jee.todo.soap.client.TaskWebServiceService;

public class TaskWebServiceTest {

    @Test
    public void shouldExecuteTaskWebService() throws MalformedURLException {
        URL serviceUrl = new URL("http://192.168.56.75:8080/todo/TaskWebService?wsdl");
        QName qname = new QName("http://soap.todo.jee.cdp.epam.com/", "TaskWebServiceService");

        Service service = TaskWebServiceService.create(serviceUrl, qname);
        TaskWebService port = service.getPort(TaskWebService.class);
        List<Task> tasks = port.tasks();
        assertFalse(tasks.isEmpty());
    }
}
