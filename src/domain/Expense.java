package domain;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Expense {
    private String name;
    private float value;
    private long expenseDate;

    private SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd:HH.mm.ss");

    public Expense(String name, float value, long expenseDate) {
        this.name = name;
        this.value = value;
        this.expenseDate = expenseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public long getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(long expenseDate) {
        this.expenseDate = expenseDate;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", expenseDate=" + dtf.format(new Timestamp(expenseDate)) +
                '}';
    }
}
