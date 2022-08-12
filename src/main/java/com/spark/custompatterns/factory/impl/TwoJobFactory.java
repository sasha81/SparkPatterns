package com.spark.custompatterns.factory.impl;

import java.util.Map;

import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.factory.IFactory;
import com.spark.custompatterns.plans.IJobPlan;
import com.spark.custompatterns.plans.ITwoJobPlan;
import com.spark.custompatterns.plans.impl.EmptySaver;
import com.spark.custompatterns.plans.impl.JsonLoader;
import com.spark.custompatterns.plans.impl.SchemaSaver;
import com.spark.custompatterns.plans.impl.ShowSaver;
import com.spark.custompatterns.plans.impl.TwoJobPlan;
import com.spark.custompatterns.plans.impl.UnionTransformer;
import com.spark.custompatterns.utils.SparkSessionContainer;

public class TwoJobFactory extends SimpleJobFactory<ITwoJobPlan>{

	public TwoJobFactory(SparkSession sparkSession, Map<String,String> options) {
	
		super(sparkSession, new TwoJobPlan( sparkSession, options.get("jobName")),options);
	}

	@Override
	public void make() {
		super.make();
		super.getJob().setSaver(new EmptySaver());
		plan.setSecondSaver(new ShowSaver(sparkSession));
		plan.setSecondLoader(new JsonLoader(sparkSession,options.get("path2")));
		plan.setTwoTransformer(new UnionTransformer());
	}

	

	@Override
	public IJobPlan make(Map<String, String> options) {
		// TODO Auto-generated method stub
		return null;
	}

}
