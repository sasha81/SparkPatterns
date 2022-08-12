package com.spark.custompatterns.plans;

public interface ITwoJobPlan extends IJobPlan{
	void setSecondSaver(ISaver saver);
	void setSecondLoader(ILoader loader);
	void setTwoTransformer(ITwoTransformer twoTransformer);
}
