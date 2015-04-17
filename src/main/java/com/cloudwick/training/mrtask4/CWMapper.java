package com.cloudwick.training.mrtask4;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class CWMapper extends Mapper<LongWritable, Text, TextPair, IntWritable> {
	//public TextPair textpair=new TextPair();
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String word[] = line.split(" ");
		context.write(new TextPair(word[0],word[1]),new IntWritable(1));	
	}
}
