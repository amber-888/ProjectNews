package HadoopDemo;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.util.GenericOptionsParser;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 统计网站最多，男、女最多的网站
public class hadoopOne {
    public static class WCMap extends Mapper<LongWritable, Text, Text,IntWritable > {
        private final static IntWritable one = new IntWritable(1);
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException, NoSuchElementException {
            StringTokenizer itr = new StringTokenizer(value.toString(),",");
            if(itr.hasMoreTokens()) {
                String num = itr.nextToken();
                String name = itr.nextToken();
                String sex = itr.nextToken();
                String time = itr.nextToken();
                String web = itr.nextToken();
                context.write(new Text( sex + "," + web), one);
            }
        }
    }
    public static class WCReduce extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context)throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values)
                sum += val.get();
            result.set(sum);
            context.write(key, result);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "one");
        job.setJarByClass(hadoopOne.class);
        job.setMapperClass(WCMap.class);
        job.setCombinerClass(WCReduce.class);
        job.setReducerClass(WCReduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path("hdfs://192.168.43.20:9000/input/students.txt"));
        FileSystem fs = FileSystem.get(conf);
        Path op = new Path("hdfs://192.168.43.20:9000/output8");
        if (fs.exists(op)) {
            fs.delete(op, true);
        }
        FileOutputFormat.setOutputPath(job, op);
        job.waitForCompletion(true);
    }
}

