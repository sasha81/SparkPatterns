package com.spark.custompatterns.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SimpleDateValidator implements IChain {
    String shortDateTimePattern;
  //  DateFormat simpleDateFormatter;
    IChain nextValidator = null;

    public SimpleDateValidator(String pattern) {
        shortDateTimePattern = pattern;
     //   simpleDateFormatter = new SimpleDateFormat(shortDateTimePattern);
    }

    public SimpleDateValidator(String pattern, IChain nextValidator) {
        this(pattern);
        this.nextValidator = nextValidator;
    }

    public void doValidate(String json) throws ParseException {
    	DateFormat simpleDateFormatter=new SimpleDateFormat(shortDateTimePattern);
        simpleDateFormatter.parse(json);
    }


    public void setNextChain(IChain validator) {
        this.nextValidator = validator;
    }

    public boolean validate(String json) {
    	DateFormat simpleDateFormatter=new SimpleDateFormat(shortDateTimePattern);
        try {
            doValidate(json);

            return true;
        } catch (Exception e) {
            if (this.nextValidator != null) return this.nextValidator.validate(json);
            else return false;
        }
    }
}

