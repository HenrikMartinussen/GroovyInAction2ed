import groovy.swing.SwingBuilder

//ReGinA p. 345

swing = new SwingBuilder()
frame = swing.frame(title:'Password') {
	passwordField(columns:10, actionPerformed: { event ->
		println event.source.text
		// any further processing is called here
		System.exit(0)
		}
	)
}
frame.pack()
frame.show()