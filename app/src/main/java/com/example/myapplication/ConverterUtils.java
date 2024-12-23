package com.example.myapplication;

public class ConverterUtils {

    // Константы для конвертации
    private static final double GALLONS_TO_LITERS = 3.78541;
    private static final double PINTS_TO_LITERS = 0.473176;
    private static final double QUARTS_TO_LITERS = 0.946353;

    public static double convert(double value, String conversionType) {
        switch (conversionType) {
            case "Gallons to Liters":
                return value * GALLONS_TO_LITERS;
            case "Liters to Gallons":
                return value / GALLONS_TO_LITERS;
            case "Pints to Liters":
                return value * PINTS_TO_LITERS;
            case "Liters to Pints":
                return value / PINTS_TO_LITERS;
            case "Quarts to Liters":
                return value * QUARTS_TO_LITERS;
            case "Liters to Quarts":
                return value / QUARTS_TO_LITERS;
            default:
                throw new IllegalArgumentException("Unknown conversion type");
        }
    }
}
