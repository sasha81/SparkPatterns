package com.spark.custompatterns.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.plans.ILoader;
import com.spark.custompatterns.utils.SparkSessionContainer;

import java.io.Serializable;
import java.util.Map;

public class RDBLoader extends SparkSessionContainer implements ILoader, Serializable {

protected Map<String, String> options;

    public RDBLoader(SparkSession session, Map<String, String> options) {
        super(session);

        this.options = options;
    }

    @Override
    public Dataset<Row> load() {
        Dataset<Row> jdbcDF = sparkSession.read().format("jdbc").options(this.options).load();
        return jdbcDF;
    }
}
