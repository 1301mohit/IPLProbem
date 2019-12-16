package ipl;

import com.opencsv.bean.CsvBindByName;

public class IPLDAO {

    String position;
    String playerName;
    String match;
    String innings;
    String runs;
    String highestScore;
    double  average;
    String strikeRate;
    String century;
    String fifty;
    String four;
    String six;

    public IPLDAO() { }

    public IPLDAO(IPLMostRun iplMostRun) {
        this.position = iplMostRun.position;
        this.playerName = iplMostRun.playerName;
        this.match = iplMostRun.match;
        this.innings = iplMostRun.innings;
        this.runs = iplMostRun.runs;
        this.highestScore = iplMostRun.highestScore;
        this.average = iplMostRun.average;
        this.strikeRate = iplMostRun.strikeRate;
        this.century = iplMostRun.century;
        this.fifty = iplMostRun.fifty;
        this.four = iplMostRun.four;
        this.six = iplMostRun.six;
    }
}
