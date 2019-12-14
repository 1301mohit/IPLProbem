package ipltest;

import ipl.IPLAnalyser;
import ipl.IPLException;
import org.junit.Assert;
import org.junit.Test;

public class iplTest {

    private static final String IPL_2019_MOST_RUN_CSV_FILE = "/home/mohit/IPL2019/src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void readIPLMostRunsCsvFile_returnNumberOfRecords() throws IPLException {
        IPLAnalyser iplAnalyser = new IPLAnalyser();
        int numberOfRecords = iplAnalyser.loadIplMostRun(IPL_2019_MOST_RUN_CSV_FILE);
        Assert.assertEquals(101,numberOfRecords);
    }
}
