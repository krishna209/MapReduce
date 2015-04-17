package com.cloudwick.training.mrtask4;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class CWReducer extends
		Reducer<TextPair, IntWritable, TextPair, IntWritable> {
	public void reduce(TextPair key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		int count = 0;
		for (IntWritable value: values) {
			count+= value.get();
		}
		//String k = key.toString();
		context.write( key , new IntWritable(count));
	}
}

