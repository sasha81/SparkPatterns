package com.spark.custompatterns.drivers;

import java.util.HashMap;
import java.util.Map;

import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.factory.IFactory;
import com.spark.custompatterns.factory.ISimpleFactory;
import com.spark.custompatterns.factory.impl.SimpleJobFactory;
import com.spark.custompatterns.factory.impl.TwoJobFactory;
import com.spark.custompatterns.plans.IJobPlan;


public class JsonDriver {
	public static void main(String[] args) {
		  final SparkSession spark = SparkSession.builder()
			        .appName("JSON Lines to Dataframe")
			        .master("local")
			        .getOrCreate();
		  final String path = "src/main/resources/multiline.json";
		  final String path2 = "src/main/resources/multiline2.json";
		  Map<String, String> options = new HashMap<>();
		  options.put("path", path);
		  options.put("path2", path2);
		  options.put("jobName", "Job_1");
		  
		  IFactory factory = new TwoJobFactory(spark, options);
		  factory.make();
		  factory.getJob().run();
		  
//		  IJobPlan job = ISimpleFactory.make(spark, options);
//		  job.run();
		  
//		  IFactory factory = new SimpleJobFactory(spark,options);
//		 
//		  factory.make();
//		  factory.getJob().run();
	}
}
