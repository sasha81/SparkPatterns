package com.spark.plans.impl;

import com.spark.plans.IJobPlan;
import com.spark.plans.ILoader;
import com.spark.plans.ISaver;
import com.spark.plans.ITransformer;

public class BasicJobPlan implements IJobPlan{
	 ILoader loader;
	    ITransformer transformer;
	    ISaver saver;

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
}
