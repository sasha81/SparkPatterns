package com.spark.drivers;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class JSONLinesParser {
	
	 
	 
	  public void parseJsonLines() {
	    SparkSession spark = SparkSession.builder()
	        .appName("JSON Lines to Dataframe")
	        .master("local")
	        .getOrCreate();
	    
//	    Dataset<Row> df = spark.read().format("json")
//		        .load("src/main/resources/simple.json");
	 
	    Dataset<Row> df2 = spark.read().format("json")
	    	.option("multiline", true)
	        .load("src/main/resources/multiline.json");
	 
	    df2.show(5, 150);
	    Row[] rows = (Row[]) df2.collect();
	    JavaRDD<Row> rdd = df2.toJavaRDD();
	    df2.printSchema();
	  }
	
	
}



