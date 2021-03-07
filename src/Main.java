import domain.Expense;
import domain.Income;
import services.ExpenseService;
import services.IncomeService;
import ui.UI;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UI ui = new UI();
        IncomeService incomeService = new IncomeService();
        ExpenseService expenseService = new ExpenseService();
        Income temp1 = new Income("Freelancing", 2000, LocalDateTime.of(2021,1,21,12,20,30));

        do {
            System.out.println(ui.mainMenu());
            int input = scanner.nextInt();
            if (input == -1)
                break;
            switch (input) {
                case 1:
                    System.out.println(ui.newIncomeMenu());
                    String incomeName = scanner.next();
                    float incomeValue = scanner.nextFloat();

                    if (incomeValue == -1 || incomeName.equals("-1"))
                        break;

                    Income income = new Income(incomeName,incomeValue,LocalDateTime.now());

                    if (incomeService.insertIncome(income))
                        System.out.println("Your income recorded as "+incomeService.numberOfIncomes());
                    else
                        System.out.println("Sorry Incomes are full!");
                    break;
                case 2:
                    System.out.println(ui.newExpenseMenu());
                    String expenseName = scanner.next();
                    float expenseValue = scanner.nextFloat();

                    if (expenseValue == -1 || expenseName == "-1")
                        break;

                    Expense expense = new Expense(expenseName, expenseValue, System.currentTimeMillis());

                    if (expenseService.insertExpenses(expense))
                        System.out.println("Your expense recorded as "+expenseService.numberOfExpenses());
                    else
                        System.out.println("Sorry Expenses are full!");
                    break;
                case 3:
                    System.out.println("List income is selected");
                    System.out.println(incomeService);
                    break;
                case 4:
                    System.out.println("List expense is selected");
                    System.out.println(expenseService);
                    break;
                case 5:
                    System.out.println(incomeService.getIncomesOfGivenDate(LocalDateTime.now()));
                default:
                    System.out.println("please use numbers between 1 and 4");
                    break;
            }
        } while (true);
    }
}
