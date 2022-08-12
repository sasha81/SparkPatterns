package com.spark.custompatterns.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import com.spark.custompatterns.plans.ITwoTransformer;

public class UnionTransformer implements ITwoTransformer{

	@Override
	public Dataset<Row> transform(Dataset<Row> ds1, Dataset<Row> ds2) {
		
		return ds1.union(ds2);
	}

}
