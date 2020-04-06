package HadoopDemo;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

public class hadooptest3 {

    public static void main(String[] args) throws Exception {
        String uri = "hdfs://192.168.43.20:9000/";
        Configuration config = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), config);

        // 显示在hdfs的/out1下指定文件的内容
        InputStream is = fs.open(new Path("/out1/part-r-00000"));
        IOUtils.copyBytes(is, System.out, 1024, true);
    }
}
