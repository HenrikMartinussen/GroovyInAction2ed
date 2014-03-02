class SampleScript {
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
}