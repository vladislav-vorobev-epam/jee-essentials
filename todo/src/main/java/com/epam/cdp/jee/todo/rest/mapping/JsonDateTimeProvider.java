package com.epam.cdp.jee.todo.rest.mapping;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;

@Provider
public class JsonDateTimeProvider implements ContextResolver<ObjectMapper> {
    @Override
    public ObjectMapper getContext(final Class<?> aClass) {
        ObjectMapper mapper = new ObjectMapper();
        JodaModule jodaModule = new JodaModule();
        mapper.registerModule(jodaModule);
        return mapper;
    }
}
