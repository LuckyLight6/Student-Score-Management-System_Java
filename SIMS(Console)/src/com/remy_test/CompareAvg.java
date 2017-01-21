package com.remy_test;

import java.util.Comparator;

public class CompareAvg implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getScoreAvg() < o2.getScoreAvg()) {
			return 1;
		}

		if (o1.getScoreAvg() > o2.getScoreAvg()) {
			return -1;
		}

		return 0;
	}

}