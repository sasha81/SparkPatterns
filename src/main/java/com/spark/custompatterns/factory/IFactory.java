package com.spark.custompatterns.factory;

import java.util.Map;

import com.spark.custompatterns.plans.IJobPlan;

public interface IFactory {
	void make();
	public IJobPlan getJob();
	public IJobPlan make(Map<String, String> options);
}
