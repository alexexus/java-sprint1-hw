package ru.yandex.praktikum.calories;

public class Converter {

    private static final double CENTIMETERS_IN_STEP = 75.0;
    private static final double CALORIES_IN_STEP = 50.0;
    private static final int CENTIMETERS_IN_KILOMETRES = 100_000;
    private static final int CALORIES_IN_KILOCALORIES = 1_000;

    public double printKilometers(int steps) {
        return steps * CENTIMETERS_IN_STEP / CENTIMETERS_IN_KILOMETRES;
    }

    public double printBurntCalories(int steps) {
        return steps * CALORIES_IN_STEP / CALORIES_IN_KILOCALORIES;
    }

}
