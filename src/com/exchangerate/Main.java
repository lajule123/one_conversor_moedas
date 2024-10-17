package com.exchangerate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        System.out.print("Digite a moeda de origem (ex: USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite a moeda de destino (ex: EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Digite o valor a ser convertido: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = converter.convert(fromCurrency, toCurrency, amount);
            System.out.printf("Valor convertido: %.2f %s%n", convertedAmount, toCurrency);
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
