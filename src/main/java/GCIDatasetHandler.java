import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class GCIDatasetHandler {

    private String datasetPath;
    public enum Headers {
        Placement, Dataset, Edition, GlobalID, SeriesCode
    }

    public GCIDatasetHandler(String datasetPath) {
        this.datasetPath = datasetPath;
    }

    public void transform() {
        try {
            Reader in = new FileReader(this.datasetPath);
            Iterable<CSVRecord> records = CSVFormat.EXCEL.withDelimiter(';').withHeader(Headers.class).parse(in);
            for (CSVRecord record : records) {
                String placement = record.get(Headers.Placement);
                String datasetIndex = record.get(Headers.Dataset);
                String seriesCode = record.get(Headers.SeriesCode);
                System.out.println(placement + " -- " + datasetIndex + " -- " + seriesCode);
            }
        } catch(IOException e) {
            System.out.println(e.getStackTrace().toString());
        }
    }


}
