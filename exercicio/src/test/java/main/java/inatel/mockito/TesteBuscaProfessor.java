package main.java.inatel.mockito;

import static org.junit.Assert.assertEquals;

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
    public void setup(){
        buscaProfessor = new BuscaProfessor(buscaService);
    }

    @Test
    public void TesteBuscaProfessorChris(){
        Mockito.when(buscaService.buscaProfessor(2)).thenReturn(InfoProfessor.Chris);

        Professor chris = buscaProfessor.buscaProfessorById(2);

        assertEquals("Chris", chris.getNomeDoProfessor());
    }

    @Test
    public void TesteBuscaProfessorRenzo(){

    }
}
