package info.martinussen.calculator.model
import org.junit.Test
import org.junit.Before
import org.junit.After
import static org.junit.Assert.assertEquals

class CalculatorModelTest {

    def model

    @Before	
    void setUp(){
        model = new CalculatorModel()
    }

    @After
    void tearDown(){
        model = null
    }

    
    @Test
    void initializationIsWorking() {
        assertEquals 0 , model.disp
    }


    @Test
    void additionIsWorking() {
		model.disp = 40
		model.enter()
		model.disp = 2
		model.add()
        assertEquals 42, model.disp
    }

    
    @Test
    void subtractionIsWorking() {
        model.disp = 44
		model.enter()
		model.disp = 2
		model.subtract()
        assertEquals 42, model.disp
    }
}

