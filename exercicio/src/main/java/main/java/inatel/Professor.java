package main.java.inatel;

// import java.time.LocalTime;

public class Professor {

    private String NomeDoProfessor;
    private String HorarioDeAtendimento;
    private String Periodo;
    private String Sala;
    private int Predio;

    // public Professor(String nome, String horario, String periodo, int sala) {
    // this.nome = nome;
    // this.horario = LocalTime.parse(horario);
    // this.periodo = periodo;
    // this.sala = sala;
    // }

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

    public int getPredio() {
        return Predio;
    }

    public void setPredio(int predio) {
        this.Predio = predio;
    }
}
