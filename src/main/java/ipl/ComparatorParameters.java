package ipl;

import java.util.Comparator;

public class ComparatorParameters {

    public enum Parameter {
        AVERAGE{
            public Comparator getComparator(){
                return Comparator.<IPLMostRun, Double>comparing(census -> census.average);
            }
        },
        STRIKE_RATE{
            public Comparator getComparator(){
                return Comparator.<IPLMostRun, String>comparing(census -> census.strikeRate);
            }
        };

        public Comparator getComparator() {
            return null;
        }
    }

    public Comparator getCompartor(Parameter parameter) {
        return parameter.getComparator();
    }
}
