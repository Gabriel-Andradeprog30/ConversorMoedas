package main;
import models.Currency;
import utils.Api;
import utils.SaveFiles;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    static List<Currency> history = new ArrayList<>();

    public void showMenu () throws IOException {

        Scanner scan = new Scanner(System.in);
        int choice;
        Currency currency;

        do {
            System.out.println(menu());
            choice = scan.nextInt();

            switch (choice) {

                case 1:
                    currency = Api.
                            checkConvertionRate("USD", "BRL", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 2:
                    currency = Api.
                            checkConvertionRate("BRL", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 3:
                    currency = Api.
                            checkConvertionRate("USD", "ARS", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 4:
                    currency = Api.
                            checkConvertionRate("ARS", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 5:
                    currency = Api.
                            checkConvertionRate("USD", "COP", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 6:
                    currency = Api.
                            checkConvertionRate("COP", "USD", scan);
                    System.out.println(currency);
                    history.add(currency);
                    break;

                case 7:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("""
                    *********************** - ERRO - *******************************
                    
                                         Opção inválida
                   
                            Pressione 'Enter' para voltar ao menu principal
                    
                    ****************************************************************
                    
                    """);
                    scan.nextLine(); // Limpa o buffer
                    scan.nextLine(); // Aguarda a entrada do usuário
            }

            System.out.println("Deseja continuar consultando conversões?");
            System.out.println("       s - SIM   |   n - Não");
            char exit =  scan.next().toLowerCase().charAt(0);
            if (exit == 'n'){
                break;
            }

        } while ( choice != 8);
        scan.close();
        saveHistoryFile();
    }

    private String menu(){
        return """
                ----------------------------------------------------------------
                
                1) Dólar =>> Real Brasileiro
                2) Real Brasileiro =>> Dólar
                3) Dólar =>> Peso Argentino
                4) Peso Argentino =>> Dólar
                5) Dólar =>> Peso Colombiano
                6) Peso Colombiano =>> Dólar
                7) Sair

                Escolha uma opção válida:
                """;
    }

    public static void saveHistoryFile () throws IOException {
        var fileSaver = new SaveFiles();
        fileSaver.saveJson(history);
    }
}