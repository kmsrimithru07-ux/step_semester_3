package main.java.week_11.practice_problem;
import java.util.*;

public class TransactionDuplicateCheck {
    public static boolean hasDuplicate(List<String> transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true;
            }
        }
        return false;
    }
}