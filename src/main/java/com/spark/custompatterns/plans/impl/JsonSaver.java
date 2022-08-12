package com.spark.custompatterns.plans.impl;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import com.spark.custompatterns.plans.ISaver;
import com.spark.custompatterns.utils.SparkSessionContainer;

import java.io.Serializable;

public class JsonSaver extends SparkSessionContainer implements Serializable, ISaver {
    

    public JsonSaver(SparkSession sparkSession) {
        super(sparkSession);
      
      
    }

    @Override
    public void save(Dataset<Row> ds) {
    	ds.show(5, 150);
	  
	    ds.printSchema();
    }
}
