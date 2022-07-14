import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    
ArrayList<MonthRecord> rows = new ArrayList<>(); // Список отчёта за все месяцы
    ArrayList<MonthRecord> rows1 = new ArrayList<>(); // Список отчёта за 1-й месяц Январь
    ArrayList<MonthRecord> rows2 = new ArrayList<>(); // Список отчёта за 2-й месяц Февраль
    ArrayList<MonthRecord> rows3 = new ArrayList<>(); // Список отчёта за 3-й месяц Март

    //HashMap<Integer, ArrayList<MonthRecord>> reportOfMonth = new HashMap<>();



    // Метод заполняет списки rows - rows3
    public void getMonthlyReport() {
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



    /*
    При вызове сверки данных программа должна:
    1. Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.
    2. Сверять полученные суммы с суммой доходов и расходов в отчёте по году.
    Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.
    Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.

 */

  // Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев

    int incomeOfMonth1() {
        int income1 = 0;
        for (MonthRecord row : rows1) {
            if (!row.isExpense) {
                income1 += row.quantity * row.sumOfOne;
            }
        }
        return income1;
    }
    int incomeOfMonth2() {
        int income2 = 0;
        for (MonthRecord row : rows2) {
            if (!row.isExpense) {
                income2 += row.quantity * row.sumOfOne;
            }
        }
        return income2;
    }
    int incomeOfMonth3() {
        int income3 = 0;
        for (MonthRecord row : rows3) {
            if (!row.isExpense) {
                income3 += row.quantity * row.sumOfOne;
            }
        }
        return income3;
    }

    // Методы вычисляют помесячные расходы
    int expenseOfMonth1() {
        int expense1 = 0;
        for (MonthRecord row : rows1) {
            if (row.isExpense) {
                expense1 += row.quantity * row.sumOfOne;
            }
        }
        return expense1;
    }
    int expenseOfMonth2() {
        int expense2 = 0;
        for (MonthRecord row : rows2) {
            if (row.isExpense) {
                expense2 += row.quantity * row.sumOfOne;
            }
        }
        return expense2;
    }
    int expenseOfMonth3() {
        int expense3 = 0;
        for (MonthRecord row : rows3) {
            if (row.isExpense) {
                expense3 += row.quantity * row.sumOfOne;
            }
        }
        return expense3;
    }
/*
    Информация о всех месячных отчётах
    При вызове этой функции программа должна выводить следующие данные:
    1. Название месяца;
    2. Самый прибыльный товар, то есть товар для которого is_expense == false, а произведение количества (quantity) на сумму (sum_of_one) максимально. Вывести название товара и сумму;
    3. Самую большую трату. Вывести название товара и сумму.
    Эта информация должна выводиться по каждому из месяцев.
 */

// Метод выводит на печать все помесячные отчёты

    void printMonthlyReport() {

        System.out.println("\nЯнварь");
        int income1 = 0;
        String product1 = "";
        for (MonthRecord row : rows1) {
            if (!row.isExpense) {
                if (row.quantity * row.sumOfOne > income1) {
                    income1 = row.quantity * row.sumOfOne;
                    product1 = row.itemName;
                }
            }
        }
        int expense1 = 0;
        String expProduct1 = "";
        for (MonthRecord row : rows1) {
            if (row.isExpense) {
                if (row.quantity * row.sumOfOne > expense1) {
                    expense1 = row.quantity * row.sumOfOne;
                    expProduct1 = row.itemName;
                }
            }
        }

        System.out.println("Самый прибыльный товар: " + product1 + ". Стоимость: " + income1);
        System.out.println("Самая большая трата: " + expProduct1 + ". Стоимость: " + expense1);


        System.out.println("\nФевраль");
        int income2 = 0;
        String product2 = "";
        for (MonthRecord row : rows2) {
            if (!row.isExpense) {
                if (row.quantity * row.sumOfOne > income2) {
                    income2 = row.quantity * row.sumOfOne;
                    product2 = row.itemName;
                }
            }
        }
        int expense2 = 0;
        String expProduct2 = "";
        for (MonthRecord row : rows2) {
            if (row.isExpense) {
                if (row.quantity * row.sumOfOne > expense2) {
                    expense2 = row.quantity * row.sumOfOne;
                    expProduct2 = row.itemName;
                }
            }
        }

        System.out.println("Самый прибыльный товар: " + product2 + ". Стоимость: " + income2);
        System.out.println("Самая большая трата: " + expProduct2 + ". Стоимость: " + expense2);

        System.out.println("\nМарт");
        int income3 = 0;
        String product3 = "";
        for (MonthRecord row : rows3) {
            if (!row.isExpense) {
                if (row.quantity * row.sumOfOne > income3) {
                    income3= row.quantity * row.sumOfOne;
                    product3 = row.itemName;
                }
            }
        }
        int expense3 = 0;
        String expProduct3 = "";
        for (MonthRecord row : rows2) {
            if (row.isExpense) {
                if (row.quantity * row.sumOfOne > expense3) {
                    expense3 = row.quantity * row.sumOfOne;
                    expProduct3 = row.itemName;
                }
            }
        }

        System.out.println("Самый прибыльный товар: " + product3 + ". Стоимость: " + income3);
        System.out.println("Самая большая трата: " + expProduct3 + ". Стоимость: " + expense3);

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
