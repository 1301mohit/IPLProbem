package ipl;

import java.util.Comparator;

public class ComparatorForAverage implements IComparator {

    @Override
    public Comparator getComparator() {
        return Comparator.<IPLDAO, Double>comparing(census -> census.average, Comparator.reverseOrder());
    }

}
