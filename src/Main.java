import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();

        while (true) {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                // Считать все месячные отчёты
            } else if (userInput == 2) {
                // Считать годовой отчёт
            } else if (userInput == 3) {
                // Сверить отчёты
            } else if (userInput == 4) {
                // Вывести информацию о всех месячных отчётах
            } else if (userInput == 5) {
                // Вывести информацию о годовом отчёте
            } else if (userInput == 0) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды нет")
            }
        }
    }
        public static void printMenu() {
            System.out.print("Выберите пункт меню");
            System.out.print("1 - Считать все месячные отчёты");
            System.out.print("2 - Считать годовой отчёт");
            System.out.print("3 - Сверить отчёты");
            System.out.print("4 - Вывести информацию о всех месячных отчётах");
            System.out.print("5 - Вывести информацию о годовом отчёте");
            System.out.print("0 - Выход из программы");
        }

}

