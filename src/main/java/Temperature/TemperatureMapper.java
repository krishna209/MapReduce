package Temperature;

import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class TemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	public static final int MISSING=9999;
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{
		String Line=value.toString();
		String year=Line.substring(15,19);
		int airTemperature;
		if(Line.charAt(87)=='+')
		{
			airTemperature=Integer.parseInt(Line.substring(88,92));	
		}
		else
		{
			airTemperature=Integer.parseInt(Line.substring(81,92));
		}
		String quality=Line.substring(92,93);
		if(airTemperature!=MISSING && quality.matches("[01459]"))
		{
			context.write(new Text(year),new IntWritable(airTemperature));
		}
		
	}
}
