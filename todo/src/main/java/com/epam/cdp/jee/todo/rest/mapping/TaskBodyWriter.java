package com.epam.cdp.jee.todo.rest.mapping;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.epam.cdp.jee.todo.persistence.entity.Task;

@Produces(MediaType.APPLICATION_JSON)
@Provider
public class TaskBodyWriter implements MessageBodyWriter<Task> {
    @Override
    public boolean isWriteable(final Class<?> aClass, final Type type, final Annotation[] annotations,
            final MediaType mediaType) {
        return false;
    }

    @Override
    public long getSize(final Task task, final Class<?> aClass, final Type type, final Annotation[] annotations,
            final MediaType mediaType) {
        return 0;
    }

    @Override
    public void writeTo(final Task task, final Class<?> aClass, final Type type, final Annotation[] annotations,
            final MediaType mediaType, final MultivaluedMap<String, Object> stringObjectMultivaluedMap,
            final OutputStream outputStream) throws IOException, WebApplicationException {
        if (task != null) {

        }
    }
}
