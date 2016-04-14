package com.studenttest.Logic;

import java.util.Comparator;

import com.studenttest.pojos.ExtraCourses;

public class MyComp implements Comparator<ExtraCourses>
{
	public int compare(ExtraCourses o1, ExtraCourses o2) 
	{
		return o1.compareTo(o2);
	}
}
