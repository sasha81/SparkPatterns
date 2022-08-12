package com.spark.custompatterns.plans;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ISaver {
	  void save(Dataset<Row> ds);
}
