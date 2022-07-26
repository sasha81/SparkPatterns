package com.spark.factory;

import java.util.Map;

import org.apache.spark.sql.SparkSession;

import com.spark.plans.IJobPlan;
import com.spark.plans.impl.BasicJobPlan;
import com.spark.plans.impl.BasicTransformer;
import com.spark.plans.impl.JsonLoader;
import com.spark.plans.impl.JsonSaver;
import com.spark.utils.SparkSessionContainer;

public class SimpleJobFactory extends SparkSessionContainer implements IFactory{
	
	String jobName;
	Map<String, String> options;
	IJobPlan plan;
	
	public SimpleJobFactory(SparkSession sparkSession, Map<String, String> options) {
		super(sparkSession);
		plan = new BasicJobPlan(sparkSession);
		this.options = options;
	}

	public SimpleJobFactory(SparkSession sparkSession, IJobPlan plan, Map<String, String> options) {
		this(sparkSession,options);
		this.plan = plan;
	}
	
	public void setJobName(String name) {
		this.jobName = name;
	}
	
	public void setOptions(Map<String, String> options) {
		this.options = options;
	}
	
	public void setJobPlan(IJobPlan plan) {
		this.plan = plan;
	}
	public IJobPlan getJob() {
		return this.plan;
	}
	
	@Override
	public void make() {
	
		plan.setJobName(this.jobName);
		plan.setLoader(new JsonLoader(sparkSession,options.get("path")));
	    plan.setSaver(new JsonSaver(sparkSession));
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
