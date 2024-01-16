// Mapper.java
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;
import java.util.StringTokenizer;

public class InvertedIndexMapper extends Mapper<LongWritable, Text, Text, Text> {
    private Text term = new Text();
    private Text docId = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] parts = value.toString().split(":\\s", 2);

        if (parts.length == 2) {
            String[] words = parts[1].split("\\s+");

            for (String word : words) {
		if (!word.isEmpty()) {
		    term.set(word);
                    docId.set(parts[0]);
                    context.write(term, docId);
		}
            }
	}
    }
}

