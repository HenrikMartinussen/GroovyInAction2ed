import groovy.swing.SwingBuilder

//ReGinA p. 349

swing = new SwingBuilder()
frame = swing.frame(title:'Demo') {
  menuBar {
    menu('File') {
      menuItem 'New'
      menuItem 'Open'
    }
  }
  panel {
    label 'Label 1'
    slider()
    comboBox(items:['one','two','three'])
  }
}
frame.pack()
frame.show()
