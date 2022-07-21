package com.spark.plans.impl;

import java.io.Serializable;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.plans.ITransformer;
import com.spark.utils.SparkSessionContainer;

public class BasicTransformer extends SparkSessionContainer implements ITransformer, Serializable {
	  public BasicTransformer(SparkSession session) {
	       super(session);
	    }


	    @Override
	    public Dataset<Row> transform(Dataset<Row> ds) {
	        return  ds;
	    }
}
