package com.spark.executors.impl;

import org.apache.spark.sql.SparkSession;

import com.spark.executors.IJobExecutor;
import com.spark.plans.impl.BasicJob;
import com.spark.plans.impl.BasicJobPlan;
import com.spark.plans.impl.BasicTransformer;
import com.spark.plans.impl.JsonLoader;
import com.spark.plans.impl.JsonSaver;

public class JsonExecutor extends BasicJobExecutor implements IJobExecutor{

	public JsonExecutor(SparkSession sparkSession, String path, String jobName) {
		super(sparkSession);
		   this.jobPlan = new BasicJobPlan();
	        this.jobPlan.setLoader(new JsonLoader(sparkSession,path));
	        this.jobPlan.setSaver(new JsonSaver(sparkSession));
	        this.jobPlan.setTransformer(new BasicTransformer(sparkSession));
	        this.job = new BasicJob(jobName);
	}

}
