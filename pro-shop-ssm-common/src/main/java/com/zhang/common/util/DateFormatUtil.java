package com.zhang.common.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 工具类
 */
@Component("dateFormatUtil")
public class DateFormatUtil
{
    private String dateTimeFormat = "yyyy-HH-dd HH:mm:ss" ;
    private String dateFormat = "yyyy-HH-dd";

    public Date strToDateTime(String now)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);

        try
        {
            return sdf.parse(now);
        } catch (ParseException e)
        {
        }
        return null ;
    }
}
