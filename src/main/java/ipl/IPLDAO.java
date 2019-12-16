package ipl;

public class IPLDAO {

    String position;
    String playerName;
    String match;
    String innings;
    String runs;
    String highestScore;
    double average;
    String strikeRate;
    String century;
    String fifty;
    String four;
    String six;

    public IPLDAO() {
    }

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

    @Override
    public String toString() {
        return "IPLDAO{" +
                "position='" + position + '\'' +
                ", playerName='" + playerName + '\'' +
                ", match='" + match + '\'' +
                ", innings='" + innings + '\'' +
                ", runs='" + runs + '\'' +
                ", highestScore='" + highestScore + '\'' +
                ", average=" + average +
                ", strikeRate='" + strikeRate + '\'' +
                ", century='" + century + '\'' +
                ", fifty='" + fifty + '\'' +
                ", four='" + four + '\'' +
                ", six='" + six + '\'' +
                '}';
    }

    public IPLMostRun getIplDTO() {
        return new IPLMostRun(position, playerName, match, innings, runs, highestScore, average, strikeRate, century, fifty, four, six);
    }

}
