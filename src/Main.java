import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();


        while (userInput != 4) {

            if (userInput < 1 || userInput > 4) {
                System.out.println("Такой команды нет");
            } else if (userInput == 1) {
                System.out.println("Введите месяц:");
                int month = scanner.nextInt();
                System.out.println("Введите день:");
                int day = scanner.nextInt();
                System.out.println("Введите колличество пройденных шагов:");
                int steps = scanner.nextInt();
                stepTracker.monthToData[month].saveStepsPerDay(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("Введите месяц:");
                int month = scanner.nextInt();
                stepTracker.monthToData[month].printStepsPerDay(month);
                System.out.println("Общее количество шагов за месяц: " + stepTracker.monthToData[month].printStepsInMonth(month));
                System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.monthToData[month].printMaxStepsInMonth(month));
                System.out.println("Среднее количество шагов в день: " + stepTracker.monthToData[month].printAverageStepsInMonth(month));
                System.out.println("Пройденная дистанция (в км): " + converter.printKilometers(month, stepTracker.monthToData[month].printStepsInMonth(month)));
                System.out.println("Количество сожжённых килокалорий: " + converter.printBurnedCalories(month, stepTracker.monthToData[month].printStepsInMonth(month)));
                System.out.println("Лучшая серия: " + stepTracker.monthToData[month].bestSeries(month));
            } else {
                System.out.println("Введите новое целевое значения для шагов за день:");
                int newGoalPerDay = scanner.nextInt();
                stepTracker.changeGoalPerDay(newGoalPerDay);
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Выйти из приложения");
    }
}
