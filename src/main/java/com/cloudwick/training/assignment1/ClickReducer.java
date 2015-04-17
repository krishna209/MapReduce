package com.cloudwick.training.assignment1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class ClickReducer extends Reducer<Text,Text,Text,IntWritable> {	
	Set<Text> ipRed;
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException
	{
		ipRed=new HashSet<Text>();	
		for(Text value:values)
		{
			ipRed.add(value);
			
		}
		context.write(key, new IntWritable(ipRed.size()));
	}
}
