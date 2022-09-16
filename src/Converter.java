public class Converter {

    double centimeters = 75.0;
    double calories = 50.0;

    double printKilometers(int month, int steps) {
        return steps * centimeters / 100000;
    }

    double printBurnedCalories(int month, int steps) {
        return steps * calories / 1000;
    }

}
