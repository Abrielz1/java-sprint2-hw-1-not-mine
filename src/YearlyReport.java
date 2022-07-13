import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
   int year;
    ArrayList<YearRecord> rows = new ArrayList<>();

   // HashMap<Integer, ArrayList<YearRecord>> reportYearly = new HashMap<>();

     public YearlyReport(int year) {
        String content = readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = content.split("\r?\n");
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");
            int month = Integer.parseInt(parts[0]);
            int amount = Integer.parseInt(parts[1]);
            boolean isExpense = Boolean.parseBoolean(parts[2]);
            rows.add(new YearRecord(month, amount, isExpense));

        }

    }

    /*
    Информация о годовом отчёте
    При вызове этой функции программа должна выводить следующие данные:
    1. Рассматриваемый год;
    2. Прибыль по каждому месяцу. Прибыль — это разность доходов и расходов;
    3. Средний расход за все месяцы в году;
    4. Средний доход за все месяцы в году.

 */
//Метод выводит на печать годовой отчёт
    public void printYearlyReport() {

        //System.out.println("Прибыль за год: " + profitYearly());
        //System.out.println("Прибыль по каждому месяцу: " + profitMonthly());
        System.out.println("Средний расход за все месяцы в году: " + getAverageExpenses());
        System.out.println("Средний доход за все месяцы в году: " + getAverageIncome());



    }

    // Метод выводит Прибыль по каждому месяцу
    public void profitMonthly() {
        for (int i = 1; i <= 3; i++) {
            int income = 0;
            int expenses = 0;
            for (YearRecord row : rows) {
                if (row.month == i && (!row.isExpense)) {
                    income += row.amount;
                }
                if (row.month == i && (row.isExpense)) {
                    expenses += row.amount;
                }
            }
            int profit = income - expenses;
            System.out.println("Прибыль за месяц " + i + ": " + profit);
        }

    }

// Метод выводит прибыль за год
    public int profitYearly() {
        int income = 0;
        int expenses = 0;
        for (YearRecord row : rows) {
            if (!row.isExpense) {
                income +=  row.amount;
            } if (row.isExpense) {
                expenses +=  row.amount;
            }
        }
        int profit = income - expenses;
        return profit;
    }

    // Метод считает Средний расход за все месяцы в году
    public int getAverageExpenses() {
        int expenses = 0;
        for (YearRecord row : rows) {
             if (row.isExpense) {
                expenses +=  row.amount;
            }
        }
        int averageExpenses = expenses / 3;
        return averageExpenses;
    }
    // Метод считает Средний доход за все месяцы в году
    public int getAverageIncome() {
        int income = 0;
        for (YearRecord row : rows) {
            if (!row.isExpense) {
            income +=  row.amount;
        }
    }
    int averageIncome = income / 3;
        return averageIncome;
    }
// Метод считает доход за Январь
    public int getIncome1() {
        int income = 0;
        for (YearRecord row : rows) {
            if ((!row.isExpense) && (row.month == 1)) {
                income =  row.amount;
            }
        }
        return income;
    }

    // Метод считает доход за Февраль
    public int getIncome2() {
        int income = 0;
        for (YearRecord row : rows) {
            if ((!row.isExpense) && (row.month == 2)) {
                income =  row.amount;
            }
        }
        return income;
    }
    // Метод считает доход за Март
    public int getIncome3() {
        int income = 0;
        for (YearRecord row : rows) {
            if ((!row.isExpense) && (row.month == 3)) {
                income =  row.amount;
            }
        }
        return income;
    }


    // Метод считает расход за Январь
    public int getExpense1() {
        int expense = 0;
        for (YearRecord row : rows) {
            if ((row.isExpense) && (row.month == 1)) {
                expense =  row.amount;
            }
        }
        return expense;
    }

    // Метод считает расход за Февраль
    public int getExpense2() {
        int expense = 0;
        for (YearRecord row : rows) {
            if ((row.isExpense) && (row.month == 2)) {
                expense =  row.amount;
            }
        }
        return expense;
    }
    // Метод считает доход за Февраль
    public int getExpense3() {
        int expense = 0;
        for (YearRecord row : rows) {
            if ((row.isExpense) && (row.month == 3)) {
                expense =  row.amount;
            }
        }
        return expense;
    }
    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
