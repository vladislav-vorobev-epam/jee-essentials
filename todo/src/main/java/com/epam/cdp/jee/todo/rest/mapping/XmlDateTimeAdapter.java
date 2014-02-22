package com.epam.cdp.jee.todo.rest.mapping;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.epam.cdp.jee.todo.DateFormatConstants;

public class XmlDateTimeAdapter extends XmlAdapter<String, DateTime> {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat
            .forPattern(DateFormatConstants.DATE_TIME);

    @Override
    public DateTime unmarshal(final String dateString) throws Exception {
        return DATE_TIME_FORMATTER.parseDateTime(dateString);
    }

    @Override
    public String marshal(final DateTime dateTime) throws Exception {
        return dateTime.toString(DATE_TIME_FORMATTER);
    }
}
