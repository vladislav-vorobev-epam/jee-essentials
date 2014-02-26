package com.epam.cdp.jee.todo.soap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;

import org.junit.Test;

public class TaskWebServiceTest {

    @Test
    public void shouldExecuteTaskWebService() throws MalformedURLException {
        URL serviceUrl = new URL("http://192.168.56.75:8080/todo/TaskWebService?wsdl");
        QName qname = new QName("http://soap.todo.jee.cdp.epam.com/", "TaskWebServiceService");

//        Service service = TaskWebServiceService.create(serviceUrl, qname);
//        TaskWebService port = service.getPort(TaskWebService.class);
//        List<Task> tasks = port.tasks();
//        assertFalse(tasks.isEmpty());
    }
}
