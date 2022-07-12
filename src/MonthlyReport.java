import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {

    ArrayList<MonthRecord> rows = new ArrayList<>();

    public MonthlyReport() {
        for (int i = 1; i <= 3; i++) {
            String content = readFileContentsOrNull("resources/m.20210" + i + ".csv");
            String[] lines = content.split("\r?\n");
            for (int j = 1; j < lines.length; j++) {
                String line = lines[j];
                String[] parts = line.split(",");
                String itemName = parts[0];
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);

                rows.add(new MonthRecord(i, itemName, isExpense, quantity, sumOfOne));
            }
        }
    }

    /*
    При вызове сверки данных программа должна:
    1. Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.
    2. Сверять полученные суммы с суммой доходов и расходов в отчёте по году.
    Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.
    Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.

 */

  // Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.

// ЗДЕСЬ НЕ ВЫХОДИТ РАЗБИТЬ СУММЫ ПО МЕСЯЦАМ
    int income() {
        int sum = 0;
        for (MonthRecord row : rows) {
            for (int i = 1; i <= 3; i++) {
                if (!row.isExpense && row.month = i) {
                    sum += row.quantity * row.sumOfOne;
                }
            }
        }
        return sum;
    }
// Здесь считается за все месяцы
    int income() {
        int sum = 0;
        for (MonthRecord row : rows) {
            if (!row.isExpense) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }

    int expense() {
        int sum = 0;
        for (MonthRecord row : rows) {
            if (row.isExpense) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }



    void printMonthlyReport() {
        for (MonthRecord row : rows) {
            System.out.println(row.month + " " + row.itemName + " " +
                    row.isExpense + " " + row.quantity + " " + row.sumOfOne);
        }
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
