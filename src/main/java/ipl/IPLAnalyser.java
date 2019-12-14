package ipl;

import com.opencsvbuilder.CSVBuilderException;
import com.opencsvbuilder.CSVBuilderFactory;
import com.opencsvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IPLAnalyser {
    public int loadIplMostRun(String csvFilePath) throws IPLException {
        List<IPLMostRun> iplList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplList = csvBuilder.getCsvFileList(reader, IPLMostRun.class);
            return iplList.size();
        } catch (IOException e) {
            throw new IPLException("Wrong Input", IPLException.ExceptionType.NO_SUCH_FILE);
        } catch (CSVBuilderException e) {
            throw new IPLException("Not build properly", IPLException.ExceptionType.NO_SUCH_FILE);
        }
    }
}
