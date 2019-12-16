package ipl;

import com.opencsvbuilder.CSVBuilderException;
import com.opencsvbuilder.CSVBuilderFactory;
import com.opencsvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser {
    public List<IPLMostRun> loadIplMostRun(String csvFilePath) throws IPLException {
        List<IPLMostRun> iplList = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            iplList = csvBuilder.getCsvFileList(reader, IPLMostRun.class);
            return iplList;
        } catch (IOException e) {
            throw new IPLException("Wrong Input", IPLException.ExceptionType.NO_SUCH_FILE);
        } catch (CSVBuilderException e) {
            throw new IPLException("Not build properly", IPLException.ExceptionType.NO_SUCH_FILE);
        }
    }

    public List<IPLMostRun> sort(String csvFilePath) throws IPLException {
        List<IPLMostRun> listOfRecords = loadIplMostRun(csvFilePath);
        if(listOfRecords.size() == 0)
            throw new IPLException("List is empty", IPLException.ExceptionType.NO_DATA_FOUND);
        Comparator<IPLMostRun> comparatorForAverage = Comparator.comparing(census -> census.average, Comparator.reverseOrder());
        listOfRecords = listOfRecords.stream().sorted(comparatorForAverage).collect(Collectors.toList());
        return listOfRecords;
    }
}
