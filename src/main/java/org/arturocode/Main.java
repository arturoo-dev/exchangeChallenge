package org.arturocode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        List<List<String>> historicalExchange = new ArrayList<>();
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        String menu = """
                 \n***********************************************
                 Bienvenido/a al Conversor de monedas =]
                 Todas las monedas soportadas.
                                \s
                 [ARS] [AUD] [BOB] [BRL] [CAD] [CLP] [COP] [CRC]
                 [CUP] [DOP] [EUR] [GTQ] [HKD] [HNL] [INR] [JPY]
                 [MXN] [NIO] [NZD] [PEN] [PYG] [USD] [VES] [ZAR]
                                \s
                 1) Convertir una moneda
                 2) Historial de conversiones.
                 3 Salir.
                                \s
                 Elija una opcion valida! :
                 ************************************************
                """;

        while (option != 3) {
            System.out.println(menu);
            option = input.nextInt();
            switch (option) {
                case 1:
                    LocalDateTime localDate = LocalDateTime.now();
                    DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String registrationDate = localDate.format(formatDate);
                    System.out.print("Ingresa tu moneda local: ");
                    String baseCode = input.next().toUpperCase();
                    System.out.print("Ingrese la moneda que desea convertir: ");
                    String targetCode = input.next().toUpperCase();
                    System.out.print("Ingrese el monto que desea convertir: ");
                    double mount = input.nextDouble();

                    System.out.println("\n");

                    ExchangeDivisa request = new ExchangeDivisa();
                    Currency currency = request.searchDivisa(baseCode, targetCode, mount);
                    System.out.println(GREEN + mount + " " + baseCode + " equivale a ==> " + currency.conversion_result() + " " + targetCode + "\n" + RESET);
                    String result = String.valueOf(currency.conversion_result());
                    List<String> list = new ArrayList<>();
                    list.add(baseCode);
                    list.add(targetCode);
                    list.add(result);
                    list.add(registrationDate);

                    historicalExchange.add(list);

                    break;

                case 2:
                    System.out.println("Historial de Conversiones.");
                    System.out.println("**************************");
                    for (List<String> listHistorical : historicalExchange) {
                        System.out.println(GREEN + listHistorical + RESET);
                    }
                    break;
                case 3:
                    System.out.println(GREEN + "Saliendo del sistema!!" + RESET);
                    break;

                default:
                    System.out.println(GREEN + "Opcion no valida!!" + RESET);
            }
        }


    }
}
