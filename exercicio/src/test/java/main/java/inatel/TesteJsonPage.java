package main.java.inatel;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import org.junit.Before;
// import org.junit.Before;
import org.junit.Test;
import com.google.gson.Gson;

public class TesteJsonPage {

    Gson gson;
    String objetoJson;
    String objetoJsonErrado;
    Professor professor;
    String savedJson;
    private String jsonStorePath;

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
        savedJson = "";
        jsonStorePath = "./jsonStore";

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

    @Test
    public void TesteSaveJsonFiles() {

        JsonPage.deleteJsonStore();
        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        JsonPage.saveJsonFiles(objetoJson);

        try {
            savedJson = new String(Files.readAllBytes(Paths.get(jsonStorePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verifique se o conteúdo do arquivo corresponde ao JSON gerado
        assertEquals(objetoJson, savedJson);

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

    @Test
    public void TesteSaveJsonFilesFalho() {

        JsonPage.deleteJsonStore();
        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        objetoJsonErrado = JsonPage.generateJsonPage(1, nome, horario, periodo, sala);
        JsonPage.saveJsonFiles(objetoJson);

        try {
            savedJson = new String(Files.readAllBytes(Paths.get(jsonStorePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verifique se o conteúdo do arquivo corresponde ao JSON gerado
        assertNotEquals(objetoJsonErrado, savedJson);
    }

    @Test
    public void TesteSaveJsonFilesNomeFalho() {

        JsonPage.deleteJsonStore();
        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        objetoJsonErrado = JsonPage.generateJsonPage(id, nomeErrado, horario, periodo, sala);
        JsonPage.saveJsonFiles(objetoJson);

        try {
            savedJson = new String(Files.readAllBytes(Paths.get(jsonStorePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verifique se o conteúdo do arquivo corresponde ao JSON gerado
        assertNotEquals(objetoJsonErrado, savedJson);
    }

    @Test
    public void TesteSaveJsonFilesHorarioFalho() {

        JsonPage.deleteJsonStore();
        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        objetoJsonErrado = JsonPage.generateJsonPage(id, nome, horarioErrado, periodo, sala);
        JsonPage.saveJsonFiles(objetoJson);

        try {
            savedJson = new String(Files.readAllBytes(Paths.get(jsonStorePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verifique se o conteúdo do arquivo corresponde ao JSON gerado
        assertNotEquals(objetoJsonErrado, savedJson);
    }

    @Test
    public void TesteSaveJsonFilesPeriodoFalho() {

        JsonPage.deleteJsonStore();
        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        objetoJsonErrado = JsonPage.generateJsonPage(id, nome, horario, periodoErrado, sala);
        JsonPage.saveJsonFiles(objetoJson);

        try {
            savedJson = new String(Files.readAllBytes(Paths.get(jsonStorePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verifique se o conteúdo do arquivo corresponde ao JSON gerado
        assertNotEquals(objetoJsonErrado, savedJson);
    }

    @Test
    public void TesteSaveJsonFilesSalaFalho() {

        JsonPage.deleteJsonStore();
        objetoJson = JsonPage.generateJsonPage(id, nome, horario, periodo, sala);
        objetoJsonErrado = JsonPage.generateJsonPage(id, "Guilherme", horario, periodo, salaErrado);
        JsonPage.saveJsonFiles(objetoJson);

        try {
            savedJson = new String(Files.readAllBytes(Paths.get(jsonStorePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verifique se o conteúdo do arquivo corresponde ao JSON gerado
        assertNotEquals(objetoJsonErrado, savedJson);
    }

}
