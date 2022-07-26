package com.spark.plans;

public interface IJobPlan {
	    void setLoader(ILoader loader);
	    void setTransformer(ITransformer transformer);
	    void setSaver(ISaver saver);
	    ILoader getLoader();

	    ITransformer getTransformer();

	    ISaver getSaver();
	    
	    void run();
	    String getJobName();
		void setJobName(String jobName);
}
