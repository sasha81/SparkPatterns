package com.spark.custompatterns.factory.impl;

import java.util.Map;

import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.factory.IFactory;
import com.spark.custompatterns.plans.IJobPlan;
import com.spark.custompatterns.plans.impl.BasicJobPlan;
import com.spark.custompatterns.plans.impl.BasicTransformer;
import com.spark.custompatterns.plans.impl.JsonLoader;
import com.spark.custompatterns.plans.impl.JsonSaver;
import com.spark.custompatterns.plans.impl.ShowSaver;
import com.spark.custompatterns.utils.SparkSessionContainer;

public class SimpleJobFactory<I extends IJobPlan> extends SparkSessionContainer implements IFactory{
	
	String jobName;
	Map<String, String> options;
	I plan;
	
	public SimpleJobFactory(SparkSession sparkSession, Map<String, String> options) {
		super(sparkSession);
		plan = (I) new BasicJobPlan(sparkSession);
		this.options = options;
	}

	public SimpleJobFactory(SparkSession sparkSession, I plan, Map<String, String> options) {
		this(sparkSession,options);
		this.plan = plan;
	}
	
	public void setJobName(String name) {
		this.jobName = name;
	}
	
	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
	
	public void setJobPlan(I plan) {
		this.plan = plan;
	}
	public I getJob() {
		return this.plan;
	}
	
	@Override
	public void make() {
	
		plan.setJobName(this.jobName);
		plan.setLoader(new JsonLoader(sparkSession,options.get("path")));
	    plan.setSaver(new ShowSaver(sparkSession));
	    plan.setTransformer(new BasicTransformer(sparkSession));
	    
	}
	@Override
	public IJobPlan make(Map<String, String> options) {
		IJobPlan plan = new BasicJobPlan(sparkSession);
		plan.setJobName(this.jobName);
		plan.setLoader(new JsonLoader(sparkSession,options.get("path")));
	    plan.setSaver(new JsonSaver(sparkSession));
	    plan.setTransformer(new BasicTransformer(sparkSession));
	    return plan;
	    
	}
	

}
