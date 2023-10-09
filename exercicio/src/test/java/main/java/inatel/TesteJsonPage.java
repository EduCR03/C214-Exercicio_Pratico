package main.java.inatel;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
// import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;

public class TesteJsonPage {

    Gson gson;
    String objetoJson;
    Professor professor;

    int id;
    String nome;
    String horario;
    String periodo;
    int sala;
    String[] predio;

    String nomeErrado;
    String horarioErrado;
    String periodoErrado;
    int salaErrado;
    String[] predioErrado;

    @Before
    public void setup() {
        gson = new Gson();

        id = 0;
        nome = "Christopher";
        horario = "Sexta-feira 17:30";
        periodo = "Noturno";
        sala = 18;
        predio = new String[] { "4" };

        nomeErrado = "Guilherme";
        horarioErrado = "Segunda-feira 18:00";
        periodoErrado = "Integral";
        salaErrado = 6;
        predioErrado = new String[] { "1" };
    }

    @Test
    public void TesteGenerateJson() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);

        String expectedResult = "{\"ID\":" + id + ",\"NomeDoProfessor\":\"" + nome + "\",\"HorarioDeAtendimento\":\""
                + horario + "\",\"Periodo\":\"" + periodo + "\",\"Sala\":\"" + sala + "\",\"Predio\":[\"4\"]}";

        // Verificar se o JSON gerado é igual ao resultado esperado
        assertEquals(expectedResult, objetoJson);
    }

    @Test
    public void TesteGenerateJsonNome() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertEquals(nome, professor.getNomeDoProfessor());
    }

    @Test
    public void TesteGenerateJsonHorario() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertEquals(horario, professor.getHorarioDeAtendimento());
    }

    @Test
    public void TesteGenerateJsonPeriodo() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertEquals(periodo, professor.getPeriodo());
    }

    @Test
    public void TesteGenerateJsonSala() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertEquals(String.valueOf(sala), professor.getSala());
    }

    @Test
    public void TesteGenerateJsonPredio() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertArrayEquals(predio, professor.getPredio());
    }

    // # $$$$$$$$$$$$$$$$$$$$$$$$ Testes Falhos $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

    @Test
    public void TesteGenerateJsonNomeFalho() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertNotEquals(nomeErrado, professor.getNomeDoProfessor());
    }

    @Test
    public void TesteGenerateJsonHorarioFalho() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertNotEquals(horarioErrado, professor.getHorarioDeAtendimento());
    }

    @Test
    public void TesteGenerateJsonPeriodoFalho() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertNotEquals(periodoErrado, professor.getPeriodo());
    }

    @Test
    public void TesteGenerateJsonSalaFalho() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        assertNotEquals(String.valueOf(salaErrado), professor.getSala());
    }

    @Test
    public void TesteGenerateJsonPredioFalho() {

        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        professor = gson.fromJson(objetoJson, Professor.class);

        // OBS: Aparentemente não há um "assertArrayNotEquals". Além disso,
        // assertNotEquals utilizando "predio" e não "predioErrado" está funcionando.
        // BUG.
        assertNotEquals(predioErrado, professor.getPredio());
    }

}
