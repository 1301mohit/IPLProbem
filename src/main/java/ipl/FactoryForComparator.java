package ipl;

import java.util.Comparator;

public class FactoryForComparator {

    public static IComparator getComparator(IPLAnalyser.IPLParameter parameter) throws IPLException {
        if(parameter.equals(IPLAnalyser.IPLParameter.AVERAGE))
            return new ComparatorForAverage();
        throw new IPLException("Wrong field", IPLException.ExceptionType.NO_DATA_FOUND);
    }
}
