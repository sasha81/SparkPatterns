package com.spark.plans;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface ILoader {
    Dataset<Row> load();
}


