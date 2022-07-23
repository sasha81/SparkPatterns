package com.spark.builders.impl;

import org.apache.spark.sql.SparkSession;

import com.spark.builders.IBuilder;
import com.spark.plans.IJobPlan;
import com.spark.plans.ILoader;
import com.spark.plans.ISaver;
import com.spark.plans.ITransformer;
import com.spark.plans.impl.BasicJobPlan;
import com.spark.plans.impl.BasicTransformer;
import com.spark.plans.impl.JsonLoader;
import com.spark.plans.impl.JsonSaver;
import com.spark.utils.SparkSessionContainer;

public class BasicBuilder extends SparkSessionContainer implements IBuilder{
	IJobPlan plan;
	public BasicBuilder(SparkSession sparkSession) {
		super(sparkSession);
		 this.plan = new BasicJobPlan(sparkSession);
	}

	public BasicBuilder(SparkSession sparkSession,String jobName) {
		this(sparkSession);
		 this.plan = new BasicJobPlan(sparkSession,jobName);
	}	

	@Override
	public void setLoader(ILoader loader) {
		 this.plan.setLoader(loader);
		
	}

	@Override
	public void setSaver(ISaver saver) {
		  this.plan.setSaver(saver);
		
	}

	@Override
	public void setTransformer(ITransformer transformer) {
		 this.plan.setTransformer(transformer);
		
	}

	@Override
	public IJobPlan getJob() {
		return this.plan;
		
	}

}
