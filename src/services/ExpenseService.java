package services;

import java.util.ArrayList;

public class ExpenseService {

    private ArrayList<Float> expensesList = new ArrayList<>();

    public boolean insertExpenses(float value) {
        return expensesList.add(value);
    }

    public int numberOfExpenses() {
        return expensesList.size();
    }

    public ArrayList<Float> getAllExpenses() {
        return expensesList;
    }

    @Override
    public String toString() {
        return "expensesList=" + expensesList;
    }
}
