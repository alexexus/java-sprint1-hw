package ru.yandex.praktikum.calories;

import java.util.Scanner;

public class Main {

    public static final int SAVING_STEPS_PER_DAY = 1;
    public static final int STATISTICS_CALCULATION = 2;
    public static final int SETTING_STEP_GOAL = 3;
    public static final int EXIT_FROM_PROGRAM = 4;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (userInput != EXIT_FROM_PROGRAM) {
            if (userInput == SAVING_STEPS_PER_DAY) {
                System.out.println("Введите месяц:");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Введите номер месяца в пределах от 0 до 11!");
                } else {
                    System.out.println("Введите день:");
                    int day = scanner.nextInt();
                    if (day < 0 || day > 29) {
                        System.out.println("Введите номер дня в пределах от 0 до 29!");
                    } else {
                        System.out.println("Введите колличество пройденных шагов:");
                        int steps = scanner.nextInt();
                        if (steps < 0) {
                            System.out.println("Количество шагов должно быть неотрицательным!");
                        } else {
                            stepTracker.saveStepsPerDay(month, day, steps);
                        }
                    }
                }
            } else if (userInput == STATISTICS_CALCULATION) {
                System.out.println("Введите месяц:");
                int month = scanner.nextInt();
                if (month < 0 || month > 11) {
                    System.out.println("Введите номер месяца в пределах от 0 до 11!");
                } else {
                    System.out.println(stepTracker.printStepsPerDay(month));
                    System.out.println("Общее количество шагов за месяц: "
                            + stepTracker.printStepsInMonth(month));
                    System.out.println("Максимальное пройденное количество шагов в месяце: "
                            + stepTracker.printMaxStepsInMonth(month));
                    System.out.println("Среднее количество шагов в день: "
                            + stepTracker.printAverageStepsInMonth(month));
                    System.out.println("Пройденная дистанция (в км): "
                            + converter.printKilometers(stepTracker.printStepsInMonth(month)));
                    System.out.println("Количество сожжённых килокалорий: "
                            + converter.printBurntCalories(stepTracker.printStepsInMonth(month)));
                    System.out.println("Лучшая серия: "
                            + stepTracker.bestSeries(month));
                }
            } else if (userInput == SETTING_STEP_GOAL) {
                System.out.println("Введите новое целевое значения для шагов за день:");
                int newGoalPerDay = scanner.nextInt();
                if (newGoalPerDay < 0) {
                    System.out.println("Количество шагов должно быть неотрицательным!");
                } else {
                    stepTracker.setGoalPerDay(newGoalPerDay);
                }
            } else {
                System.out.println("Такой команды нет");
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
