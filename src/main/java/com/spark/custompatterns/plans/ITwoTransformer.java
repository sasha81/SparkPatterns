package com.spark.custompatterns.plans;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ITwoTransformer {
	Dataset<Row> transform(Dataset<Row> ds1, Dataset<Row> ds2);
}
