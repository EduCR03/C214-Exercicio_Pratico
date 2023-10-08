package main.java.inatel;

import java.util.ArrayList;
// import java.util.List;

public interface BuscaService {

    public boolean professorExists(int id);

    public String buscaProfessor(int id);

    public ArrayList<Professor> listaTodosProfessores();
}
