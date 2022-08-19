package com.spark.custompatterns.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class AChainDT {
	public AChainDT(AChainDT nextParser, String shortDateTimePattern, Date defaultTime) {		
		this.nextParser = nextParser;
		this.shortDateTimePattern = shortDateTimePattern;
		this.defaultTime = defaultTime;
	}
	public AChainDT( String shortDateTimePattern) {			
		this.shortDateTimePattern = shortDateTimePattern;		
	}
	protected AChainDT nextParser=null;
	protected String shortDateTimePattern;	  
	protected Date defaultTime = new Date(0L);
	
	public void setNext(AChainDT nextParser) {
		this.nextParser = nextParser;
	}
	
	 public LocalDate getDateTime(String input) {
		 Date result =parseDateTime(input);
	    	LocalDate localDate = result.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    	    return localDate;
	 }
	 public abstract Date parseDateTime(String input);

}
