package com.spark.builders;

import com.spark.plans.IJobPlan;
import com.spark.plans.ILoader;
import com.spark.plans.ISaver;
import com.spark.plans.ITransformer;

public interface IBuilder {

	void setLoader(ILoader loader);
	void setSaver(ISaver saver);
	void setTransformer(ITransformer transformer);
IJobPlan getJob();
}
