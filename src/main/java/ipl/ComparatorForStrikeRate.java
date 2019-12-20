package ipl;

import java.util.Comparator;

public class ComparatorForStrikeRate implements IComparator {
    @Override
    public Comparator getComparator() {
        return Comparator.<IPLDAO, String>comparing(census -> census.strikeRate, Comparator.reverseOrder());
    }
}
