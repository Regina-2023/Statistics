package ru.netology.stats;

public class StatsService {
    //п.1 - сумма всех продаж
    public long sumSales(long[] sales) {
        long totalSale = 0;
        for (long sale : sales) {
            totalSale += sale;
        }
        return totalSale;
    }

    //п.2 - средняя сумма продаж в месяц
    public long averageSales(long[] sales) {
        if (sales.length > 0) {
            return sumSales(sales) / sales.length;
        }
        return 0;
    }

    //п.3 - номер месяца, в котором были продажи на максимальную сумму
    public int maxSales(long[] sales) {
        int maxMonth = 0; // номер месяца с максимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= sales[maxMonth]) { // значит, в рассматриваемом i-м месяце продаж больше
                maxMonth = i; // запомним его как максимальный
            }
        }
        return maxMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    //п.4 - номер месяца, в котором были продажи на минимальную сумму
    public int minSales(long[] sales) {
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }
        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    //п.5 - кол-во месяцев, в которых продажи были ниже среднего
    public int minAverageSales(long[] sales) {
        int minAverageMonth = 0;

        for (long sale : sales) {
            if (sale < averageSales(sales)) {
                minAverageMonth++;
            }
        }
        return minAverageMonth;
    }

    //п.6 - кол-во месяцев, в которых продажи были выше среднего
    public int maxAverageSales(long[] sales) {
        int maxAverageMonth = 0;

        for (long sale : sales) {
            if (sale > averageSales(sales)) {
                maxAverageMonth++;
            }
        }
        return maxAverageMonth;
    }

}

