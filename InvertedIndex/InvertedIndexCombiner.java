// Combiner.java
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class InvertedIndexCombiner extends Reducer<Text, Text, Text, Text> {
    public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // Combine the document IDs for the same word
        StringBuilder combinedDocIds = new StringBuilder();
        for (Text docId : values) {
            combinedDocIds.append(docId.toString()).append(",");
        }

        context.write(key, new Text(combinedDocIds.toString()));
    }
}
