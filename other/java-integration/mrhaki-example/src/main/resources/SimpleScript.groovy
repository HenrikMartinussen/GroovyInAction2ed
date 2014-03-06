Map parseLine(num, line) {
	def returnMap = [:]
	if(num > 0){
		def values =  line.split(';')
		assert values.size() == 4

		returnMap.orderNumber = values[0]
		returnMap.lineNumber = values[1]
		returnMap.articleNumber = values[2]
		returnMap.quantity = values[3]
	}
	return returnMap
}

//Tests can be run from the project home folder like this: groovy src\main\resources\SampleScript.groovy
//test that first line is skipped
orderline = parseLine(0, 'ordernumber;orderlinenumber;articlenumber;quantity')
assert orderline.size() == 0

//test that consecutive lines are not skipped - and that the line is parsed correctly
def orderline = parseLine(2, '4711;2;VOE997581;24')
assert orderline.size() > 0
assert orderline.orderNumber == '4711'
assert orderline.lineNumber == '2'
assert orderline.quantity == '24'


print 'everything is ok...'


