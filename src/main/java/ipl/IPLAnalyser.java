package ipl;

import com.google.gson.Gson;
import com.opencsvbuilder.CSVBuilderException;
import com.opencsvbuilder.CSVBuilderFactory;
import com.opencsvbuilder.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLAnalyser {

    public enum IPLParameter {
        AVERAGE, STRIKE_RATE, SIX, FOUR;
    }

    List<IPLMostRun> iplList = null;

    public List<IPLDAO> loadIplMostRun(String csvFilePath) throws IPLException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<IPLMostRun> iplList = csvBuilder.getCsvFileList(reader, IPLMostRun.class);
            List<IPLDAO> listOfDAO = iplList.stream().map(iplDTO -> new IPLDAO(iplDTO)).collect(Collectors.toList());
            return listOfDAO;
        } catch (IOException e) {
            throw new IPLException("Wrong Input", IPLException.ExceptionType.NO_SUCH_FILE);
        } catch (CSVBuilderException e) {
            throw new IPLException("Not build properly", IPLException.ExceptionType.NO_SUCH_FILE);
        }
    }

    public String sortForAverage(String csvFilePath, IPLParameter parameter) throws IPLException {
        IComparator comparator = FactoryForComparator.getComparator(parameter);
        List<IPLDAO> listOfRecords = loadIplMostRun(csvFilePath);
        if (listOfRecords.size() == 0)
            throw new IPLException("List is empty", IPLException.ExceptionType.NO_DATA_FOUND);
        Comparator<IPLDAO> comparatorForAverage = comparator.getComparator();
        iplList = listOfRecords.stream().sorted(comparatorForAverage).map(ipl -> ipl.getIplDTO()).collect(Collectors.toList());
        String iplJson = new Gson().toJson(iplList);
        return iplJson;
    }

    public String sortForMaximumSixAndFour(String csvFilePath, IPLParameter parameterForSix, IPLParameter parameterForFour) throws IPLException {
        IComparator comparatorForSix = FactoryForComparator.getComparator(parameterForSix);
        IComparator comparatorForFour = FactoryForComparator.getComparator(parameterForFour);
        List<IPLDAO> listOfRecords = loadIplMostRun(csvFilePath);
        if(listOfRecords.size() == 0)
            throw new IPLException("List is empty", IPLException.ExceptionType.NO_DATA_FOUND);
        Comparator<IPLDAO> comparator = comparatorForSix.getComparator().thenComparing(comparatorForFour.getComparator());
        iplList = listOfRecords.stream().sorted(comparator).map(ipl -> ipl.getIplDTO()).collect(Collectors.toList());
        iplList.stream().forEach(System.out::println);
        String iplJson = new Gson().toJson(iplList);
        return iplJson;
    }

}
