package main.java.inatel;

// import java.util.ArrayList;
// import com.google.gson.JsonObject;
// import com.google.gson.JsonParser;

public class BuscaProfessor {

    BuscaService buscaService;
    boolean professorExists;

    public BuscaProfessor(BuscaService buscaService) {
        this.buscaService = buscaService;
    }

    public boolean ProfessorExists(int id) {
        professorExists = buscaService.professorExists(id);

        if (professorExists) {
            return true;
        } else {
            return false;
        }
    }

}