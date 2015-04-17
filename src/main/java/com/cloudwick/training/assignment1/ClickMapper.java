package com.cloudwick.training.assignment1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ClickMapper extends Mapper<LongWritable, Text, Text, Text>{
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String line=value.toString();
		String[] splitValue=line.split(" ");
		String ip=splitValue[0];
		String year=splitValue[3];
		String url=splitValue[10];
		if(year.contains("/2002:"))
		{			
			context.write(new Text(url), new Text(ip));
		}
	}
}
