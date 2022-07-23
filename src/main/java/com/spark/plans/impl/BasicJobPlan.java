package com.spark.plans.impl;

import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import com.spark.plans.IJobPlan;
import com.spark.plans.ILoader;
import com.spark.plans.ISaver;
import com.spark.plans.ITransformer;
import com.spark.utils.SparkSessionContainer;

public class BasicJobPlan extends SparkSessionContainer implements IJobPlan{
	
	public BasicJobPlan(SparkSession sparkSession, String jobName) {
		this(sparkSession);
		this.jobName = jobName;
	}

	public BasicJobPlan(SparkSession sparkSession) {
		super(sparkSession);
		
	}

	String jobName;
	 ILoader loader;
	    ITransformer transformer;
	    ISaver saver;

	    public void setJobName(String jobName) {
			this.jobName = jobName;
		}
	    
	    @Override
	    public void setLoader(ILoader loader) {
	        this.loader = loader;
	    }

	    @Override
	    public void setTransformer(ITransformer transformer) {
	        this.transformer = transformer;
	    }

	    @Override
	    public void setSaver(ISaver saver) {
	        this.saver = saver;
	    }

	    public ILoader getLoader() {
	        return loader;
	    }

	    public ITransformer getTransformer() {
	        return transformer;
	    }

	    public ISaver getSaver() {
	        return saver;
	    }

		@Override
		public void run() {
			SparkContext sparkContext = this.sparkSession.sparkContext();
	        sparkContext.setJobDescription(jobName);
	        Dataset<Row> ds = loader.load();
	        ds = transformer.transform(ds);
	        saver.save(ds);
			
		}

		@Override
		public String getJobName() {
			// TODO Auto-generated method stub
			return null;
		}
}
