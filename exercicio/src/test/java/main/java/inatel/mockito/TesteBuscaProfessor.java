package main.java.inatel.mockito;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import main.java.inatel.BuscaProfessor;
import main.java.inatel.BuscaService;

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

    }

    @Test
    public void TesteBuscaProfessorRenzo(){

    }
}
