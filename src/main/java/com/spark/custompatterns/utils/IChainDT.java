package com.spark.custompatterns.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface IChainDT {
	LocalDate getDateTime(String input);
	Date parseDateTime(String input);
	void setNextChain(IChainDT element);
}
