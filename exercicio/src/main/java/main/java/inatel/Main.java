package main.java.inatel;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String nome;
        String horario;
        String periodo;
        int sala;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Professor: ");
        nome = scanner.nextLine();

        System.out.print("Horário de Atendimento: ");
        horario = scanner.nextLine();

        System.out.print("Período: ");
        periodo = scanner.nextLine();

        System.out.print("Sala: ");
        sala = scanner.nextInt();
        // Consuma o caractere de nova linha
        scanner.nextLine();

        // Não esqueça de fechar o Scanner quando não for mais necessário.
        scanner.close();

        System.out.println(JsonPage.generateJsonPage(nome, horario, periodo, sala));
    }

}
