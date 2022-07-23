package com.spark.drivers;

import org.apache.spark.sql.SparkSession;

import com.spark.builders.IBuilder;
import com.spark.builders.impl.BasicBuilder;
import com.spark.makers.IMaker;
import com.spark.makers.impl.JsonMaker;

public class JsonDriver2 {
	public static void main(String[] args) {
	  final SparkSession spark = SparkSession.builder()
		        .appName("JSON Lines to Dataframe")
		        .master("local")
		        .getOrCreate();
	  final String path = "src/main/resources/multiline.json";
	  IBuilder builder = new BasicBuilder(spark,"Job1");
	  IMaker maker = new JsonMaker(spark,builder,path);
	  maker.make();
	  maker.getBuilder().getJob().run();
	}
}
