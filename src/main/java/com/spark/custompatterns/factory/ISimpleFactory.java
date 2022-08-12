package com.spark.custompatterns.factory;

import java.util.Map;

import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.plans.IJobPlan;
import com.spark.custompatterns.plans.impl.BasicJobPlan;
import com.spark.custompatterns.plans.impl.BasicTransformer;
import com.spark.custompatterns.plans.impl.JsonLoader;
import com.spark.custompatterns.plans.impl.JsonSaver;

public interface ISimpleFactory {
	static IJobPlan make(SparkSession sparkSession, Map<String, String> options) {
		IJobPlan plan = new BasicJobPlan(sparkSession);
		if(options.containsKey("jobName")) plan.setJobName(options.get("jobName"));
		plan.setLoader(new JsonLoader(sparkSession,options.get("path")));
	    plan.setSaver(new JsonSaver(sparkSession));
	    plan.setTransformer(new BasicTransformer(sparkSession));
	    return plan;
	}
}
