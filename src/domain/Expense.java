package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {
    private String expenseName;
    private float expenseValue;
    private LocalDateTime expenseDate;

    public Expense(String expenseName, Float expenseValue, LocalDateTime expenseDate) {
        this.expenseName = expenseName;
        this.expenseValue = expenseValue;
        this.expenseDate = expenseDate;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Float getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(Float expenseValue) {
        this.expenseValue = expenseValue;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + expenseName + '\'' +
                ", value=" + expenseValue +
                ", expenseDate=" + expenseDate.format(DateTimeFormatter.ofPattern("YYYY-MM-dd, HH:mm:ss")) +
                '}';
    }
}
