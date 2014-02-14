package com.epam.cdp.jee.todo.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@WebListener
@Slf4j
public class RequestsListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(final ServletRequestEvent servletRequestEvent) {
        log.info("Request was destroyed {}", servletRequestEvent.getServletRequest().getParameterMap());
    }

    @Override
    public void requestInitialized(final ServletRequestEvent servletRequestEvent) {
        log.info("Request initialised {}", servletRequestEvent.getServletRequest().getParameterMap());
    }
}
