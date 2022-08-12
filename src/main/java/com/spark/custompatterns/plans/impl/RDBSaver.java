package com.spark.custompatterns.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.plans.ISaver;
import com.spark.custompatterns.utils.SparkSessionContainer;

import java.io.Serializable;
import java.util.Map;

public class RDBSaver extends SparkSessionContainer implements Serializable, ISaver {
    Map<String, String> options;
     public RDBSaver(SparkSession sparkSession, Map<String, String> options) {
        super(sparkSession);
        this.options = options;
    }

    @Override
    public void save(Dataset<Row> ds) {
        ds.write().options(options).save();
    }
}
