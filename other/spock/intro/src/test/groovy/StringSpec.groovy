import spock.lang.Specification

class StringSpec extends Specification {
	String llap

	def setup() { llap = 'Live Long and Prosper' }

	def "Llap has 21 characters"() {
		expect: llap.size() == 21
	}	

	def "Llap has 4 words"() {
		expect: llap.split(/\W/).size() == 4
	}

	def "Llap has 6 vowels"() {
		expect: llap.findAll(/[aeiouyæøå]/)
	}

	def "Access inside the string doesn't throw an exception"() {
		when: llap.charAt(llap.size() - 1) 
		then: notThrown(IndexOutOfBoundsException)
	}

	def "Access beyond the end of the string throws an exception"() {
		when: llap.charAt(llap.size() + 1) 
		then: thrown(IndexOutOfBoundsException)
	}
}