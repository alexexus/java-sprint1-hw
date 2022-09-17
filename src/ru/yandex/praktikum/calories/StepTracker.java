package ru.yandex.praktikum.calories;

public class StepTracker {
    private final MonthData[] monthToData;
    private int goalPerDay = 10_000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setGoalPerDay(int goalPerDay) {
        this.goalPerDay = goalPerDay;
    }

    public void saveStepsPerDay(int month, int day, int steps) {
        monthToData[month].getDaysInMonth()[day] = steps;
    }

    public StringBuilder printStepsPerDay(int month) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < monthToData[month].getDaysInMonth().length; i++) {
            stringBuilder.append(i + 1)
                    .append(" день: ")
                    .append(monthToData[month].getDaysInMonth()[i]);
            if (i < 29) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder;
    }

    public int printStepsInMonth(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month].getDaysInMonth().length; i++) {
            sum = sum + monthToData[month].getDaysInMonth()[i];
        }
        return sum;
    }

    public int printMaxStepsInMonth(int month) {
        int max = 0;
        for (int i = 0; i < monthToData[month].getDaysInMonth().length; i++) {
            if (monthToData[month].getDaysInMonth()[i] > max) {
                max = monthToData[month].getDaysInMonth()[i];
            }
        }
        return max;
    }

    public double printAverageStepsInMonth(int month) {
        return printStepsInMonth(month) / 30.0;
    }

    public int bestSeries(int month) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < monthToData[month].getDaysInMonth().length; i++) {
            if (monthToData[month].getDaysInMonth()[i] >= goalPerDay) {
                count++;
            } else {
                count = 0;
            }
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}

