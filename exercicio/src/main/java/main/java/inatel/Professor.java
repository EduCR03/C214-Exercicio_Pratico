package main.java.inatel;

// import java.time.LocalTime;

public class Professor {

    private int ID;
    private String NomeDoProfessor;
    private String HorarioDeAtendimento;
    private String Periodo;
    private String Sala;
    private String[] Predio;

    public Professor(int id, String nome, String horario, String periodo, String sala, String[] predio) {
        this.ID = id;
        this.NomeDoProfessor = nome;
        this.HorarioDeAtendimento = horario;
        this.Periodo = periodo;
        this.Sala = sala;
        this.Predio = predio;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getNomeDoProfessor() {
        return NomeDoProfessor;
    }

    public void setNomeDoProfessor(String nomeDoProfessor) {
        this.NomeDoProfessor = nomeDoProfessor;
    }

    public String getHorarioDeAtendimento() {
        return HorarioDeAtendimento;
    }

    public void setHorarioDeAtendimento(String horarioDeAtendimento) {
        this.HorarioDeAtendimento = horarioDeAtendimento;
    }

    public String getPeriodo() {
        return Periodo;
    }

    public void setPeriodo(String periodo) {
        this.Periodo = periodo;
    }

    public String getSala() {
        return Sala;
    }

    public void setSala(String sala) {
        this.Sala = sala;
    }

    public String[] getPredio() {
        return Predio;
    }

    public void setPredio(String[] predio) {
        this.Predio = predio;
    }
}
