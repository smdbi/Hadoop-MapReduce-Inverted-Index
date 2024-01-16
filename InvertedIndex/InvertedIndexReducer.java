// Reducer.java
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class InvertedIndexReducer extends Reducer<Text, Text, Text, Text> {
    private Text result = new Text();

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuilder docIds = new StringBuilder();

        for (Text value : values) {
            if (docIds.length() > 0) {
                docIds.append(", ");
            }
            docIds.append(value.toString());
        }

        result.set(docIds.toString());
        context.write(key, result);
    }
}

