package main.java.inatel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // JsonPage jsonPage;
        String jsonFile;
        String nome;
        String horario;
        String periodo;
        int sala = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Professor (Inatel): ");
        nome = scanner.nextLine();

        System.out.print("Horário de Atendimento (HH:mm): ");
        horario = scanner.nextLine();

        System.out.print("Período (Integral ou Noturno): ");
        periodo = scanner.nextLine();

        do {
            try {
                System.out.print("Sala (1 a 30): ");
                sala = scanner.nextInt();
                // Consuma o caractere de nova linha
                scanner.nextLine();

                // Verifique se o valor está fora do intervalo permitido
                if (sala <= 0 || sala >= 31) {
                    System.out.println("Erro. Por favor entrar com um valor válido (1 a 30)!");
                } else {
                    // Saia do loop se o valor for válido
                    break;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e);
                System.out.println("Por favor digite um valor válido (Inteiro)!");
                // Limpe o buffer de entrada para evitar um loop infinito
                scanner.nextLine();
            }
        } while (true);

        jsonFile = JsonPage.generateJsonPage(nome, horario, periodo, sala);
        System.out.println(jsonFile);

        JsonPage.saveJsonFiles(jsonFile);

        // Não esqueça de fechar o Scanner quando não for mais necessário.
        scanner.close();
    }
}
