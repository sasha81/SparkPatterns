package com.spark.custompatterns.plans.impl;

import java.io.Serializable;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.plans.ISaver;
import com.spark.custompatterns.utils.SparkSessionContainer;

public class ShowSaver extends SparkSessionContainer implements Serializable, ISaver{

	public ShowSaver(SparkSession sparkSession) {
		super(sparkSession);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Dataset<Row> ds) {
		ds.show(5, 150);
		
	}
	
	

}
