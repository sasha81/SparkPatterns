package com.spark.executors.impl;

import java.io.Serializable;

import org.apache.spark.SparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;


import com.spark.executors.IJobExecutor;
import com.spark.plans.IJob;
import com.spark.plans.IJobPlan;
import com.spark.utils.SparkSessionContainer;

public class BasicJobExecutor extends SparkSessionContainer implements IJobExecutor, Serializable{
	protected IJobPlan jobPlan;
    protected IJob job;
 
    public BasicJobExecutor(SparkSession sparkSession) {
        super(sparkSession);
    }

    public void setPlan(IJobPlan plan){
        this.jobPlan = plan;
    }

    public void setJob(IJob job){
        this.job = job;
    }


    @Override
    public void run() {
        SparkContext sparkContext = this.sparkSession.sparkContext();
        sparkContext.setJobDescription(job.getJobName());
        Dataset<Row> ds = jobPlan.getLoader().load();
        ds = jobPlan.getTransformer().transform(ds);
        jobPlan.getSaver().save(ds);
    }
}
