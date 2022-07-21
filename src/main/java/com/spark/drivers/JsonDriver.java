package com.spark.drivers;

import org.apache.spark.sql.SparkSession;

import com.spark.executors.IJobExecutor;
import com.spark.executors.impl.JsonExecutor;

public class JsonDriver {
	
public static void main(String[] args) {
		
	  final SparkSession spark = SparkSession.builder()
		        .appName("JSON Lines to Dataframe")
		        .master("local")
		        .getOrCreate();
	  
	  
	  IJobExecutor executor = new JsonExecutor(spark,"src/main/resources/multiline.json","JsonJob_1");
	  executor.run();
	}

}
