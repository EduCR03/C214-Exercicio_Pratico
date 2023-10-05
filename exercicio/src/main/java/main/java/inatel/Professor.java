package main.java.inatel;

// import java.time.LocalTime;

public class Professor {

    private int id; // ID único para cada objeto criado
    private static int idNext = 1;
    private String NomeDoProfessor;
    private String HorarioDeAtendimento;
    private String Periodo;
    private String Sala;
    private String[] Predio;

    public Professor(int id, String nome, String horario, String periodo, String sala) {
        this.NomeDoProfessor = nome;
        this.HorarioDeAtendimento = horario;
        this.Periodo = periodo;
        this.Sala = sala;
        this.Predio = new String[] { "1", "2", "3", "4", "5", "6" };
    }

    public Professor(String nome, String horario, String periodo, String sala) {
        this.NomeDoProfessor = nome;
        this.HorarioDeAtendimento = horario;
        this.Periodo = periodo;
        this.Sala = sala;
        this.Predio = new String[] { "1", "2", "3", "4", "5", "6" };
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        if (id >= idNext) {
            idNext = id + 1; // Atualize o próximo ID disponível
        }
    }
}
