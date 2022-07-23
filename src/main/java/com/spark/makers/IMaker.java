package com.spark.makers;

import com.spark.builders.IBuilder;

public interface IMaker {
	void make();
	IBuilder getBuilder();
}
