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

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import com.epam.cdp.jee.todo.DateFormatConstants;

@Produces(MediaType.APPLICATION_JSON)
@Provider
public class JodaDateTimeAwareBodyWriter implements MessageBodyWriter<DateTime> {
    @Override
    public boolean isWriteable(final Class<?> aClass, final Type type, final Annotation[] annotations,
            final MediaType mediaType) {
        return type == DateTime.class;
    }

    @Override
    public long getSize(final DateTime dateTime, final Class<?> aClass, final Type type,
            final Annotation[] annotations, final MediaType mediaType) {
        // deprecated by JAX-RS 2.0 and ignored by Jersey runtime
        return 0;
    }

    @Override
    public void writeTo(final DateTime dateTime, final Class<?> aClass, final Type type,
            final Annotation[] annotations, final MediaType mediaType,
            final MultivaluedMap<String, Object> stringObjectMultivaluedMap, final OutputStream outputStream)
            throws IOException, WebApplicationException {
        String dateTimeString = dateTime.toString(DateTimeFormat.forPattern(DateFormatConstants.DATE_TIME));
        outputStream.write(dateTimeString.getBytes());
    }
}
