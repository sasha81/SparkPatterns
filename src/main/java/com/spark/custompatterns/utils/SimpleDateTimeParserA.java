package com.spark.custompatterns.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateTimeParserA extends AChainDT{

	public SimpleDateTimeParserA(AChainDT nextParser, String shortDateTimePattern, Date defaultTime) {
		super(nextParser, shortDateTimePattern, defaultTime);
		
	}
	public SimpleDateTimeParserA(String shortDateTimePattern) {
		super(shortDateTimePattern);		
	}
	@Override
	public Date parseDateTime(String input) {
		DateFormat simpleDateFormatter=new SimpleDateFormat(shortDateTimePattern);
        try {
        	Date result = simpleDateFormatter.parse(input);

            return result;
        } catch (Exception e) {
            if (nextParser != null) return nextParser.parseDateTime(input);
            else return defaultTime;
        }
	}
}
