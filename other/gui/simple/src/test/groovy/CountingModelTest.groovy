import org.junit.Test
import org.junit.Before
import org.junit.After
import static org.junit.Assert.assertEquals

class ArithmeticTest {

    def model

    @Before	
    void setUp(){
        model = new CountingModel()
    }

    @After
    void tearDown(){
        model = null
    }

    
    @Test
    void initializationIsWorking() {
        assertEquals 0 , model.count
    }


    @Test
    void additionIsWorking() {
        assertEquals 4, model.count + 4
    }

    
    @Test
    void incrementIsWorking() {
        model.count++
        assertEquals 1, model.count
    }


}

