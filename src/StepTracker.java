public class StepTracker {
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    int goalPerDay = 10000;

    void changeGoalPerDay(int newGoalPerDay) {
        if (newGoalPerDay < 0) {
            System.out.println("Количество шагов должно быть неотрицательным!");
        } else {
            goalPerDay = newGoalPerDay;
        }
    }

    class MonthData {
        int[] daysInMonth = new int[30];

        void saveStepsPerDay(int month, int day, int steps) {
            if (steps < 0) {
                System.out.println("Количество шагов должно быть неотрицательным!");
            } else {
                monthToData[month].daysInMonth[day] = steps;
            }
        }

        void printStepsPerDay(int month) {
            for (int i = 0; i < daysInMonth.length; i++) {
                System.out.printf((i + 1) + " день:" + " " + daysInMonth[i] + ", ");
            }
            System.out.println();
        }

        int printStepsInMonth(int month) {
            int sum = 0;
            for (int i = 0; i < daysInMonth.length; i++) {
                sum = sum + daysInMonth[i];
            }
            return sum;
        }

        int printMaxStepsInMonth(int month) {
            int max = 0;
            for (int i = 0; i < daysInMonth.length; i++) {
                if (daysInMonth[i] > max) {
                    max = daysInMonth[i];
                }
            }
            return max;
        }

        double printAverageStepsInMonth(int month) {
            double sum = 0;
            for (int i = 0; i < daysInMonth.length; i++) {
                sum = sum + daysInMonth[i];
            }
            sum = sum / 30;
            return sum;
        }

        int bestSeries(int month) {
            int maxCount = 0;
            int count = 0;
            for (int i = 0; i < daysInMonth.length; i++) {
                if (daysInMonth[i] >= goalPerDay) {
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
}

