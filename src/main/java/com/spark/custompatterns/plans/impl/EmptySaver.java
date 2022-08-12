package com.spark.custompatterns.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.spark.custompatterns.plans.ISaver;

public class EmptySaver implements ISaver{

	@Override
	public void save(Dataset<Row> ds) {
		// TODO Auto-generated method stub
		
	}

}
