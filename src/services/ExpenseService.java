package services;

import domain.Expense;

import java.util.ArrayList;
import java.util.Comparator;

public class ExpenseService {

    private ArrayList<Expense> expensesList = new ArrayList<>();

    public boolean insertExpenses(Expense value) {
        return expensesList.add(value);
    }

    public int numberOfExpenses() {
        return expensesList.size();
    }

    public ArrayList<Expense> getAllExpenses() {
        return expensesList;
    }

    private Float calculateAverage() {
        return expensesList.isEmpty() ? 0.0f : calculateSum() / expensesList.size();
    }

    private Float calculateSum() {
        float sum = 0.0f;
        for (Expense expense: expensesList){
            sum += expense.getValue();
        }
        return sum;
    }

    @Override
    public String toString() {
        Comparator<Expense> valueComparator = new Comparator<Expense>() {
            @Override
            public int compare(Expense o1, Expense o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        expensesList.sort(valueComparator);
        return "expensesList=" + expensesList + "\naverage of " + calculateAverage();
    }


}
