package ipltest;

import com.google.gson.Gson;
import ipl.IPLAnalyser;
import ipl.IPLException;
import ipl.IPLMostRun;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class iplTest {

    private static final String IPL_2019_MOST_RUN_CSV_FILE = "/home/mohit/IPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_WRONG_CSV_FILE_PATH = "/home/mohit/IPL2019/src/main/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_2019_MOST_WKTS_CSV_FILE = "/home/mohit/IPL2019/src/test/resources/IPL2019FactsheetMostWkts.csv";
    @Test
    public void readIPLMostRunsCsvFile_returnNumberOfRecords() {
        try{
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            List listOFRecords = iplAnalyser.loadIplMostRun(IPL_2019_MOST_RUN_CSV_FILE);
            listOFRecords.forEach(System.out::println);
            Assert.assertEquals(5, listOFRecords.size());
        } catch(IPLException e){}
    }

    @Test
    public void readWrongCsvFile_returnException() {
        try{
            IPLAnalyser iplAnalyser = new IPLAnalyser();
            List listOFRecords = iplAnalyser.loadIplMostRun(IPL_2019_WRONG_CSV_FILE_PATH);
        } catch(IPLException e){
            Assert.assertEquals(IPLException.ExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void readIPLMostRunsCsvFile_returnToppingBattingAveragePlayerName() throws IPLException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        String sortedData = iplAnalyser.sortForAverage(IPL_2019_MOST_RUN_CSV_FILE, IPLAnalyser.IPLParameter.AVERAGE);
        IPLMostRun[] ipl = new Gson().fromJson(sortedData, IPLMostRun[].class);
        Assert.assertEquals("MS Dhoni", ipl[0].getPlayerName());
    }

}
