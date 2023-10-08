package main.java.inatel.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.inatel.BuscaProfessor;
import main.java.inatel.BuscaService;
import main.java.inatel.InfoProfessor;
import main.java.inatel.Professor;

@RunWith(MockitoJUnitRunner.class)
public class TesteBuscaProfessor {

    @Mock
    private BuscaService buscaService;

    private BuscaProfessor buscaProfessor;

    @Before
    public void setup() {
        buscaProfessor = new BuscaProfessor(buscaService);
    }

    @Test
    public void TesteBuscaProfessorAquino() {
        Mockito.when(buscaService.buscaProfessor(1)).thenReturn(InfoProfessor.Aquino);

        Professor aquino = buscaProfessor.buscaProfessorById(1);

        assertEquals("Guilherme Aquino", aquino.getNomeDoProfessor());
    }

    @Test
    public void TesteBuscaProfessorChris() {
        Mockito.when(buscaService.buscaProfessor(2)).thenReturn(InfoProfessor.Chris);

        Professor chris = buscaProfessor.buscaProfessorById(2);

        assertEquals("Christopher Lima", chris.getNomeDoProfessor());
    }

    @Test
    public void TesteBuscaProfessorRenzo() {
        Mockito.when(buscaService.buscaProfessor(3)).thenReturn(InfoProfessor.Renzo);

        Professor renzo = buscaProfessor.buscaProfessorById(3);

        assertEquals("Renzo Mesquita", renzo.getNomeDoProfessor());
    }

    @Test
    public void TesteBuscaProfessorSamuel() {
        Mockito.when(buscaService.buscaProfessor(4)).thenReturn(InfoProfessor.Samuel);

        Professor samuel = buscaProfessor.buscaProfessorById(4);

        assertEquals("Samuel Baraldi", samuel.getNomeDoProfessor());
    }

    @Test
    public void TesteBuscaProfessorSalaAquino() {
        Mockito.when(buscaService.buscaProfessor(4)).thenReturn(InfoProfessor.Aquino);

        Professor aquino = buscaProfessor.buscaProfessorById(4);

        assertEquals("8", aquino.getSala());
    }

    @Test
    public void TesteBuscaProfessorValido() {
        Mockito.when(buscaService.professorExists(1)).thenReturn(true);

        boolean professorValido = buscaService.professorExists(1);

        assertTrue(professorValido);
    }

    @Test
    public void TesteBuscaProfessorNull() {
        Mockito.when(buscaService.buscaProfessor(0)).thenReturn(InfoProfessor.Null);

        Professor inexistente = buscaProfessor.buscaProfessorById(0);

        assertEquals("Null", inexistente.getNomeDoProfessor());
    }

}
