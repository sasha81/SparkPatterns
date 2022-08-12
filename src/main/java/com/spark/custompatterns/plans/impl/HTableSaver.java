package com.spark.custompatterns.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;

import com.spark.custompatterns.plans.ISaver;

import java.io.Serializable;

public class HTableSaver implements ISaver, Serializable {
    private String tableName;

    public HTableSaver(String tableName) {
        this.tableName = tableName;
    }


    @Override
    public void save(Dataset<Row> ds) {
        ds.write().format("orc").mode(SaveMode.Overwrite).saveAsTable(this.tableName);
    }
}
