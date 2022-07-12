import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport {
    int year;
    ArrayList<YearRecord> rows = new ArrayList<>();

    public YearlyReport(int year, String path) {
        String content = readFileContentsOrNull(path);
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
    public int maxExpense() {
        int max = 0;
        for (YearRecord row : rows) {
            if (row.isExpense) {
                if (row.amount > max) {
                    max = row.amount;
                }
            }
        }
        return max;
    }

    public void printYearlyReport() {
        for (YearRecord row : rows) {
            System.out.println(row.month + " " + row.amount + " " + row.isExpense);
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
