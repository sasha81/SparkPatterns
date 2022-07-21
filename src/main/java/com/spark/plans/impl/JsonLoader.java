package com.spark.plans.impl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.plans.ILoader;
import com.spark.utils.SparkSessionContainer;

import java.io.Serializable;

public class JsonLoader extends SparkSessionContainer implements ILoader, Serializable {
    protected String path;

    public JsonLoader(SparkSession session, String path) {
        super(session);
        this.path = path;
    }

    @Override
    public Dataset<Row> load() {
        return this.sparkSession.read().format("json")
    	    	.option("multiline", true)
    	        .load(path);
    }
}
