package ru.yandex.praktikum.calories;

public class Converter {

    public static final double CENTIMETERS_IN_STEP = 75.0;
    public static final double CALORIES_IN_STEP = 50.0;
    public static final int CENTIMETERS_IN_KILOMETRES = 100_000;
    public static final int CALORIES_IN_KILOCALORIES = 1_000;

    public double printKilometers(int steps) {
        return steps * CENTIMETERS_IN_STEP / CENTIMETERS_IN_KILOMETRES;
    }

    public double printBurntCalories(int steps) {
        return steps * CALORIES_IN_STEP / CALORIES_IN_KILOCALORIES;
    }

}
