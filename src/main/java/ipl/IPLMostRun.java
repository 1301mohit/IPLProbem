package ipl;

import com.opencsv.bean.CsvBindByName;

public class IPLMostRun {
   // POS,PLAYER,Mat,Inns,NO,Runs,HS,Avg,BF,SR,100,50,4s,6s
    @CsvBindByName(column = "POS", required = false)
    String position;

    @CsvBindByName(column = "PLAYER", required = true)
    String playerName;

    @CsvBindByName(column = "Mat", required = false)
    String match;

    @CsvBindByName(column = "Inns", required = false)
    String innings;

    @CsvBindByName(column = "Runs", required = false)
    String runs;

    @CsvBindByName(column = "HS", required = false)
    String highestScore;

    @CsvBindByName(column = "Avg", required = false)
    double average;

    @CsvBindByName(column = "SR", required = false)
    String strikeRate;

    @CsvBindByName(column = "100", required = false)
    String century;

    @CsvBindByName(column = "50", required = false)
    String fifty;

    @CsvBindByName(column = "4s", required = false)
    String four;

    @CsvBindByName(column = "6s", required = false)
    String six;

    public IPLMostRun() {
    }

    public IPLMostRun(String position, String playerName, String match, String innings, String runs, String highestScore, double  average, String strikeRate, String century, String fifty, String four, String six) {
        this.position = position;
        this.playerName = playerName;
        this.match = match;
        this.innings = innings;
        this.runs = runs;
        this.highestScore = highestScore;
        this.average = average;
        this.strikeRate = strikeRate;
        this.century = century;
        this.fifty = fifty;
        this.four = four;
        this.six = six;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getInnings() {
        return innings;
    }

    public void setInnings(String innings) {
        this.innings = innings;
    }

    public String getRuns() {
        return runs;
    }

    public void setRuns(String runs) {
        this.runs = runs;
    }

    public String getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(String highestScore) {
        this.highestScore = highestScore;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStrikeRate() {
        return strikeRate;
    }

    public void setStrikeRate(String strikeRate) {
        this.strikeRate = strikeRate;
    }

    public String getCentury() {
        return century;
    }

    public void setCentury(String century) {
        this.century = century;
    }

    public String getFifty() {
        return fifty;
    }

    public void setFifty(String fifty) {
        this.fifty = fifty;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }

    public String getSix() {
        return six;
    }

    public void setSix(String six) {
        this.six = six;
    }

    @Override
    public String toString() {
        return "IPLMostRun{" +
                "position=" + position +
                ", playerName='" + playerName + '\'' +
                ", match=" + match +
                ", innings=" + innings +
                ", runs=" + runs +
                ", highestScore=" + highestScore +
                ", average=" + average +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", fifty=" + fifty +
                ", four=" + four +
                ", six=" + six +
                '}';
    }

}
