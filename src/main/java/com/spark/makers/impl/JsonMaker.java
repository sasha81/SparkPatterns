package com.spark.makers.impl;

import org.apache.spark.sql.SparkSession;

import com.spark.builders.IBuilder;
import com.spark.builders.impl.BasicBuilder;
import com.spark.makers.IMaker;
import com.spark.plans.impl.BasicTransformer;
import com.spark.plans.impl.JsonLoader;
import com.spark.plans.impl.JsonSaver;
import com.spark.utils.SparkSessionContainer;

public class JsonMaker extends SparkSessionContainer implements IMaker{
	IBuilder builder;
	String path;
	public JsonMaker(SparkSession session, String jobName, String path) {
		super(session);
		this.builder = new BasicBuilder(session, jobName);
		this.path=path;
	}
	
	public JsonMaker(SparkSession session, IBuilder builder, String path) {
		super(session);
		this.builder = builder;
		this.path=path;
	}
	
	@Override
	public void make() {
		   this.builder.setLoader(new JsonLoader(sparkSession,path));
	        this.builder.setSaver(new JsonSaver(sparkSession));
	        this.builder.setTransformer(new BasicTransformer(sparkSession));
		
	}

	@Override
	public IBuilder getBuilder() {
		
		return this.builder;
	}

}
