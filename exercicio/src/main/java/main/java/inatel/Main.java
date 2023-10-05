package main.java.inatel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String jsonPage;
        String nome;
        String horario;
        String periodo;
        int sala = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Professor: ");
        nome = scanner.nextLine();

        System.out.print("Horário de Atendimento (HH:mm): ");
        horario = scanner.nextLine();

        System.out.print("Período (Integral ou Noturno): ");
        periodo = scanner.nextLine();

        do {
            try {
                System.out.print("Sala: ");
                sala = scanner.nextInt();
                // Consuma o caractere de nova linha
                scanner.nextLine();

                // Saia do loop se o valor for válido
                break;
            } catch (Exception e) {
                System.out.println("Erro: " + e);
                System.out.println("Por favor digite um valor válido (Inteiro)!");
                // Limpe o buffer de entrada para evitar um loop infinito
                scanner.nextLine();
            }
        } while (true);

        jsonPage = JsonPage.generateJsonPage(nome, horario, periodo, sala);
        System.out.println(jsonPage);

        // Escrevendo o json criado no arquivo musicas.json
        FileWriter writer;
        try {
            writer = new FileWriter("jsonPageGenerator");
            writer.write(jsonPage);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Não esqueça de fechar o Scanner quando não for mais necessário.
        scanner.close();
    }

}
