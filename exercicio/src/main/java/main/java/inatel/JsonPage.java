package main.java.inatel;

import java.io.FileWriter;
import java.io.IOException;

// import java.util.Scanner;
import com.google.gson.Gson;

public class JsonPage {

    public static String generateJsonPage(String nome, String horario, String periodo, int sala) {

        String salaString;

        // String stringPage = "{"
        // + "\"nomeDoProfessor\": \"" + professor.nome + "\","
        // + "\"horarioDeAtendimento\": \"" + professor.horario + "\","
        // + "\"periodo\": \"" + professor.periodo + "\","
        // + "\"sala\": \"" + professor.sala + "\""
        // + "}";

        salaString = String.valueOf(sala);

        Professor professor = new Professor(null, null, null, null);
        professor.setNomeDoProfessor(nome);
        professor.setHorarioDeAtendimento(horario);
        professor.setPeriodo(periodo);
        professor.setSala(salaString);

        if (sala >= 1 && sala <= 5) {
            professor.setPredio(new String[] { "1" });
        } else if (sala >= 6 && sala <= 10) {
            professor.setPredio(new String[] { "2" });
        } else if (sala >= 11 && sala <= 15) {
            professor.setPredio(new String[] { "3" });
        } else if (sala >= 16 && sala <= 20) {
            professor.setPredio(new String[] { "4" });
        } else if (sala >= 21 && sala <= 25) {
            professor.setPredio(new String[] { "5" });
        } else if (sala >= 26 && sala <= 30)
            professor.setPredio(new String[] { "6" });
        else
            professor.setPredio(new String[] { "Null" });

        // Use a biblioteca Gson para converter o objeto em JSON
        Gson gson = new Gson();
        String jsonPage = gson.toJson(professor);

        return jsonPage;
    }

    public static void saveJsonFiles(String jsonPage) {

        // Escrevendo o json criado no arquivo musicas.json
        FileWriter writer;
        try {
            writer = new FileWriter("jsonStore");
            writer.write(jsonPage);
            writer.close();
            System.out.println();
            System.out.println("JSON(s) salvo(s) em jsonStore.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
