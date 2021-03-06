package com.hadoop_project.mapreduce.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper <LongWritable, Text, Text, LongWritable>{
	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		// Read the line
		String line = value.toString();

		// Split the line in to words
		String[] words = line.split(" ");

		// Assign Count(1)to each word
		for (String word : words) {
			context.write(new Text(word), new LongWritable(1));
		}
	}
}
