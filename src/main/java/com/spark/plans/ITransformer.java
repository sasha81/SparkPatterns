package com.spark.plans;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ITransformer {
	Dataset<Row> transform(Dataset<Row> ds);
}
