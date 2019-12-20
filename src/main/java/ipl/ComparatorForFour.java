package ipl;

import java.util.Comparator;

public class ComparatorForFour implements IComparator {
    @Override
    public Comparator getComparator() {
        return Comparator.<IPLDAO, String>comparing(ipl -> ipl.four, Comparator.reverseOrder());
    }
}
