package main.java.inatel;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscaProfessor {

    BuscaService buscaService;
    boolean professorExists;
    String professorJson;
    JsonObject jsonObject;

    public BuscaProfessor(BuscaService buscaService) {
        this.buscaService = buscaService;
    }

    public boolean verifyProfessorExists(int id) {
        professorExists = buscaService.professorExists(id);

        if (professorExists) {
            return true;
        } else {
            return false;
        }
    }

    public Professor buscaProfessorById(int id) {

        professorJson = buscaService.buscaProfessor(id);

        // jsonObject é um objeto JSON feito a partir da string de retonro
        jsonObject = JsonParser.parseString(professorJson).getAsJsonObject();

        JsonArray predioArray = jsonObject.getAsJsonArray("Predio");
        String[] predio = new String[predioArray.size()];

        for (int i = 0; i < predioArray.size(); i++) {
            predio[i] = predioArray.get(i).getAsString();
        }

        return new Professor(
                jsonObject.get("ID").getAsInt(),
                jsonObject.get("NomeDoProfessor").getAsString(),
                jsonObject.get("HorarioDeAtendimento").getAsString(),
                jsonObject.get("Periodo").getAsString(),
                jsonObject.get("Sala").getAsString(),
                predio);
    }

    public List<Professor> buscaTodosProfessores() {

        // Cria uma lista vazia que armazena objetos Professor
        // List<Professor> professores = new ArrayList<>();

        List<Professor> professores = new ArrayList<>(null);

        for (int i = 1; i <= 4; i++) {
            professores.add(i, buscaProfessorById(i));
        }

        return professores;
    }
}