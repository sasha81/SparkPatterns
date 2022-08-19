package com.spark.custompatterns.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class SimpleDateTimeParser implements IChainDT {

	 String shortDateTimePattern;
	
	    IChainDT dateTimeParser = null;
	    Date defaultTime = new Date(0L);

	    public SimpleDateTimeParser(String pattern) {
	        shortDateTimePattern = pattern;
	       
	    }

	    public SimpleDateTimeParser(String pattern, IChainDT nextValidator) {
	        this(pattern);
	        this.dateTimeParser = nextValidator;
	    }

	    public LocalDate getDateTime(String json)  {
	    	Date result =parseDateTime(json);
	    	LocalDate localDate = result.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    	    return localDate;
	    }


	    public void setNextChain(IChainDT validator) {
	        this.dateTimeParser = validator;
	    }

	    public Date parseDateTime(String json) {
	    	DateFormat simpleDateFormatter=new SimpleDateFormat(shortDateTimePattern);
	        try {
	        	Date result = simpleDateFormatter.parse(json);

	            return result;
	        } catch (Exception e) {
	            if (this.dateTimeParser != null) return this.dateTimeParser.parseDateTime(json);
	            else return defaultTime;
	        }
	    }

}
