package com.spark.utils;

import org.apache.spark.sql.SparkSession;

public class SparkSessionContainer {
	  protected SparkSession sparkSession;
	    public SparkSessionContainer(SparkSession sparkSession) {
	        this.sparkSession = sparkSession;
	    }

	   
}
