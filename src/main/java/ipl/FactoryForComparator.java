package ipl;

import java.util.Comparator;

public class FactoryForComparator {

    public static IComparator getComparator(IPLAnalyser.IPLParameter parameter) throws IPLException {
        if(parameter.equals(IPLAnalyser.IPLParameter.AVERAGE))
            return new ComparatorForAverage();
        else if(parameter.equals(IPLAnalyser.IPLParameter.STRIKE_RATE))
            return new ComparatorForStrikeRate();
        else if(parameter.equals(IPLAnalyser.IPLParameter.SIX))
            return new ComparatorForSix();
        else if(parameter.equals(IPLAnalyser.IPLParameter.FOUR))
            return new ComparatorForFour();
        throw new IPLException("Wrong field", IPLException.ExceptionType.NO_DATA_FOUND);
    }
}
