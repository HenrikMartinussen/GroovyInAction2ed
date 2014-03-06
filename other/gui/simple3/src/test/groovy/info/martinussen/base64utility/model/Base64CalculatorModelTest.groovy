package info.martinussen.base64utility.model
import org.junit.Test
import org.junit.Before
import org.junit.After
import static org.junit.Assert.assertEquals
import static org.junit.Assert.fail

class CalculatorModelTest {

    def model

    @Before	
    void setUp(){
        model = new Base64ConverterModel()
    }

    @After
    void tearDown(){
        model = null
    }

    
    @Test
    void initializationIsWorking() {
        assertEquals '' , model.clearText
		assertEquals '', model.encodedText  
    }


	@Test
	void decodeIsWorking() {
		def encoded = 'VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wZWQgb3ZlciB0aGUgbGF6eSBkb2c='
		def clearExpected = 'The quick brown fox jumped over the lazy dog'
		model.encodedText = encoded
		model.decode()
		assertEquals clearExpected, model.clearText
		//		fail()
	}

    
    @Test
    void encodeIsWorking() {
		def clear = 'The quick brown fox jumped over the lazy dog'
		def encodedExpected = 'VGhlIHF1aWNrIGJyb3duIGZveCBqdW1wZWQgb3ZlciB0aGUgbGF6eSBkb2c='
		model.clearText = clear
		model.encode()
		assertEquals encodedExpected, model.encodedText
    }
}

