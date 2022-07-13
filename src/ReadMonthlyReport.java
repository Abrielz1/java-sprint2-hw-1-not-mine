import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReadMonthlyReport {

    // Метод считывает данные
    ArrayList<MonthRecord> rows = new ArrayList<>(); // Список отчёта за все месяцы
    ArrayList<MonthRecord> rows1 = new ArrayList<>(); // Список отчёта за 1-й месяц Январь
    ArrayList<MonthRecord> rows2 = new ArrayList<>(); // Список отчёта за 2-й месяц Февраль
    ArrayList<MonthRecord> rows3 = new ArrayList<>(); // Список отчёта за 3-й месяц Март

    public void readOfMonthlyReport() {
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

                if ( i == 1) {
                    rows1.add(new MonthRecord(i, itemName, isExpense, quantity, sumOfOne));
                } if ( i == 2) {
                    rows2.add(new MonthRecord(i, itemName, isExpense, quantity, sumOfOne));
                } if ( i == 3) {
                    rows3.add(new MonthRecord(i, itemName, isExpense, quantity, sumOfOne));
                }
            }
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
