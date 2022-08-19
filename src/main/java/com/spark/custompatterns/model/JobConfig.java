package com.spark.custompatterns.model;

public class JobConfig {
	  public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getHiveTable() {
		return hiveTable;
	}
	public void setHiveTable(String hiveTable) {
		this.hiveTable = hiveTable;
	}
	public String getSelect() {
		return rdbTable;
	}
	public void setSelect(String select) {
		this.rdbTable = select;
	}
	public int getRepartition() {
		return repartition;
	}
	public void setRepartition(int repartition) {
		this.repartition = repartition;
	}
	public int getFetchSize() {
		return fetchSize;
	}
	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}
	private String jobName;
	    private String hiveTable;	  
	    private String rdbTable;
	    private int repartition;
	    private int fetchSize;
}
