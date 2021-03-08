package services;

import domain.Expense;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class ExpenseService implements Service<Expense> {

    private ArrayList<Expense> expensesList = new ArrayList<>();

    public Boolean insert(Expense value) {
        return expensesList.add(value);
    }

    public int numberOfExpenses() {
        return expensesList.size();
    }

    public ArrayList<Expense> getData() {
        return expensesList;
    }

    private Float calculateAverage() {
        return expensesList.isEmpty() ? 0.0f : calculateSum() / expensesList.size();
    }

    private Float calculateSum() {
        float sum = 0.0f;
        for (Expense expense: expensesList){
            sum += expense.getExpenseValue();
        }
        return sum;
    }

    public ArrayList<Expense> getExpensesOfGivenDate(LocalDateTime someDate) {
        ArrayList<Expense> filteredList = new ArrayList<>();
        for(Expense expense: expensesList){
            if(expense.getExpenseDate().getMonth().equals(someDate.getMonth())){
                filteredList.add(expense);
            }
        }
        return filteredList;
    }

    @Override
    public String toString() {
        Comparator<Expense> valueComparator = new Comparator<Expense>() {
            @Override
            public int compare(Expense o1, Expense o2) {
                return o1.getExpenseValue().compareTo(o2.getExpenseValue());
            }
        };

        expensesList.sort(valueComparator);
        return "expensesList=" + expensesList + "\naverage of " + calculateAverage();
    }


}
