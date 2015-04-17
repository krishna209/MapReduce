package com.cloudwick.training.mrtask4;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class CWDriver {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		if(args.length!=2)
		{
			System.err.println("error");
			System.exit(0);
		}
		
		Job job=new Job();
		job.setJarByClass(CWDriver.class);
		job.setJobName("CWDriver");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		
		job.setMapperClass(CWMapper.class);
		job.setReducerClass(CWReducer.class);
		
		//job.setMapOutputKeyClass(TextPair.class);
		//job.setMapOutputValueClass(IntWritable.class);
		
		job.setOutputKeyClass(TextPair.class);
		job.setOutputValueClass(IntWritable.class);
		
		System.exit(job.waitForCompletion(true)?0:1);
	}
}
