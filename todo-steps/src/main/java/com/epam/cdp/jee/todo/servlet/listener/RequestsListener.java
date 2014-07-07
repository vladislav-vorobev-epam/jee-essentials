package com.epam.cdp.jee.todo.servlet.listener;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class RequestsListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(final ServletRequestEvent servletRequestEvent) {
        log.info("Request was destroyed with parameters: \n{}", getParamsAsString(servletRequestEvent));
    }

    @Override
    public void requestInitialized(final ServletRequestEvent servletRequestEvent) {
        log.info("Request initialised with parameters:\n{}", getParamsAsString(servletRequestEvent));
    }

    private StringBuilder getParamsAsString(final ServletRequestEvent servletRequestEvent) {
        ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        Map<String, String[]> parameterMap = servletRequest.getParameterMap();
        StringBuilder params = new StringBuilder();
        for (Map.Entry<String, String[]> paramEntry : parameterMap.entrySet()) {
            String paramName = paramEntry.getKey();
            params.append(paramName).append("=").append(servletRequest.getParameter(paramName)).append("\n");
        }
        return params;
    }
}
