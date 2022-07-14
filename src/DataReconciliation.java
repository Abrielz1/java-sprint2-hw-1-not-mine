public class DataReconciliation {
/*
    При вызове сверки данных программа должна:
    1. Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.
    2. Сверять полученные суммы с суммой доходов и расходов в отчёте по году.
    Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.
    Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.

 */

    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();

    public void reconciliation() {


        if (monthlyReport.incomeOfMonth1() == yearlyReport.getIncome1() && monthlyReport.expenseOfMonth1() == yearlyReport.getExpense1()) {

        } else {
            System.out.println("В январе обнаружено несоответствие. Проверьте исходные данные!");
        }
        if (monthlyReport.incomeOfMonth2() == yearlyReport.getIncome2() && monthlyReport.expenseOfMonth2() == yearlyReport.getExpense2()) {

        } else {
            System.out.println("В феврале обнаружено несоответствие. Проверьте исходные данные!");
        }
        if (monthlyReport.incomeOfMonth3() == yearlyReport.getIncome3() && monthlyReport.expenseOfMonth3() == yearlyReport.getExpense3()) {

        } else {
            System.out.println("В марте обнаружено несоответствие. Проверьте исходные данные!");
        }
            System.out.println("Операция успешно завершена!");


    }


