package com.spark.drivers;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.sql.SparkSession;

import com.spark.factory.IFactory;
import com.spark.factory.SimpleJobFactory;


public class JsonDriver3 {
	public static void main(String[] args) {
		  final SparkSession spark = SparkSession.builder()
			        .appName("JSON Lines to Dataframe")
			        .master("local")
			        .getOrCreate();
		  final String path = "src/main/resources/multiline.json";
		  Map<String, String> options = new HashMap<>();
		  options.put("path", path);
		  
		  IFactory factory = new SimpleJobFactory(spark,options);
		 
		  factory.make();
		  factory.getJob().run();
	}
}
