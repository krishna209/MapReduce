package com.cloudick.training.mrtask3;

import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class logmapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	//List<String> err =new ArrayList<String>();
	public static enum CODE_COUNTER{
		STATUS_CODE_200,
		STATUS_CODE_400
	};
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line=value.toString();
		String[] StringSplit=line.split(" ");
		String errCode=StringSplit[7];
		//err.add(errCode);
		if(errCode.equals("200"))
		{
			context.getCounter(CODE_COUNTER.STATUS_CODE_200).increment(1);
		}
		else if(errCode.equals("400"))
		{
			context.getCounter(CODE_COUNTER.STATUS_CODE_400).increment(1);
		}
	}
	/*public void cleanup(Context context) throws IOException, InterruptedException
	{
		for(String e: err)
		{
			context.write(new Text(e), new IntWritable(Collections.frequency(err,e)));
		}		
	}*/

}
