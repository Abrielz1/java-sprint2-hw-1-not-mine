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
    public void printMonthlyReport() {
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
