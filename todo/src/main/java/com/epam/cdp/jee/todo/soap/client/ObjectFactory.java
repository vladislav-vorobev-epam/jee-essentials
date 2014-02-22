
package com.epam.cdp.jee.todo.soap.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.cdp.jee.todo.soap.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _TasksResponse_QNAME = new QName("http://soap.todo.jee.cdp.epam.com/", "tasksResponse");
    private final static QName _Tasks_QNAME = new QName("http://soap.todo.jee.cdp.epam.com/", "tasks");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.cdp.jee.todo.soap.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TasksResponse }
     * 
     */
    public TasksResponse createTasksResponse() {
        return new TasksResponse();
    }

    /**
     * Create an instance of {@link Tasks }
     * 
     */
    public Tasks createTasks() {
        return new Tasks();
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TasksResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.todo.jee.cdp.epam.com/", name = "tasksResponse")
    public JAXBElement<TasksResponse> createTasksResponse(TasksResponse value) {
        return new JAXBElement<TasksResponse>(_TasksResponse_QNAME, TasksResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Tasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.todo.jee.cdp.epam.com/", name = "tasks")
    public JAXBElement<Tasks> createTasks(Tasks value) {
        return new JAXBElement<Tasks>(_Tasks_QNAME, Tasks.class, null, value);
    }

}
