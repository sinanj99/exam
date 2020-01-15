package facades;

import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class ServerFacadeTest {

    private static EntityManagerFactory emf;
    private static StudentFacade facade;

    public ServerFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       facade = StudentFacade.getStudentFacade(emf);
    }
    @BeforeEach
    public void setup() {
        
    }
    
    @Test
    public void get() {
        
    }
}
