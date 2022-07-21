package com.spark.plans.impl;

import com.spark.plans.IJob;

public class BasicJob implements IJob {

	public BasicJob(String jobName) {
		super();
		this.jobName = jobName;
	}
	String jobName;
	@Override
	public String getJobName() {
		return this.jobName;
	}

}
