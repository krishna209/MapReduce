package com.cloudick.training.mrtask3;

import java.io.IOException;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;

public class LogDriver {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException
	{
		if(args.length!=2)
		{
			System.err.print("error");
			System.exit(-1);
		}
		Job job=new Job();
		job.setJarByClass(LogDriver.class);
		job.setJobName("LogDriver");
		
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(logmapper.class);
		job.setNumReduceTasks(0);
		
		job.setMapOutputKeyClass(NullOutputFormat.class);
		job.setMapOutputValueClass(NullOutputFormat.class);
		
		System.exit(job.waitForCompletion(true)?0:1);
	}

}
