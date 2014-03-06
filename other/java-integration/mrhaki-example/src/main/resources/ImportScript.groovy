import info.martinussen.regina.integration.mrhakiex.OrderBuilder

OrderBuilder importFile(builder, file){
	builder.clear()
	def lineCounter = 0
	file.eachLine {
		if (lineCounter != 0) {
			def values =  it.split(';')
			assert values.size() == 4
			if (!builder.isInitialized()){
				builder.setOrderNumber(values[0])
				builder.init()
			}
			builder.setLineNumber(values[1].toInteger())
			builder.setArticleNumber(values[2])
			builder.setQuantity(values[3].toDouble())
			builder.addOrderLine()
		}
		lineCounter++
	}
	builder.buildOrder()
	return builder
}
