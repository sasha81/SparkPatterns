package com.spark.custompatterns.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.plans.ILoader;
import com.spark.custompatterns.plans.ISaver;
import com.spark.custompatterns.plans.ITwoJobPlan;
import com.spark.custompatterns.plans.ITwoTransformer;

public class TwoJobPlan extends BasicJobPlan implements ITwoJobPlan{
	ISaver secondSaver;
	ILoader secondLoader;
	ITwoTransformer unionTransformer;
	Dataset<Row> ds2;
	public TwoJobPlan(SparkSession sparkSession, String jobName) {
		super(sparkSession, jobName);
		
	}

	@Override
	public void setSecondSaver(ISaver saver) {
		
		this.secondSaver = saver;
	}
	
	public void run() {
		this.ds2 = secondLoader.load();
		super.run();
		this.ds2=this.unionTransformer.transform(super.ds, this.ds2);
		this.secondSaver.save(this.ds2);
	}

	@Override
	public void setSecondLoader(ILoader loader) {
		this.secondLoader = loader;
		
	}

	@Override
	public void setTwoTransformer(ITwoTransformer twoTransformer) {
		this.unionTransformer = twoTransformer;
		
	}

}
