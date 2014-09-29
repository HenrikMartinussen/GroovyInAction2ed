import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenSpec extends spock.lang.Specification {

	@Unroll
	def "#name should have length #length"() {
		expect: name.size() == length

		where:
		name     | length
		"Jess"   | 4
		"Søren"  | 5
		"Mogens" | 6
		"Henrik" | 6
	}
	
	def "Check length using Lists"(){
		expect: name.size() == length

		where:
		name << ['Spock', 'Kirk', 'Scotty']
		length << [5, 4, 6]
		
	}
}