package ipl;

import java.util.Comparator;

public class ComparatorForSix implements IComparator{

    @Override
    public Comparator getComparator() {
        return Comparator.<IPLDAO, String>comparing(ipl -> ipl.six, Comparator.reverseOrder());
    }

}
