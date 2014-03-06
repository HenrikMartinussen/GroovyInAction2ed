package info.martinussen.base64utility.gui

import java.awt.*
import javax.swing.*
import groovy.swing.SwingBuilder
import info.martinussen.base64utility.model.Base64ConverterModel


def model = new Base64ConverterModel()
new SwingBuilder().edt {
	frame(title:'Base64 Converter', defaultCloseOperation:JFrame.EXIT_ON_CLOSE, size:[275,150], show: true) { // pack:true
		panel {
			vbox{
				clearTextField = textField(text: bind(source:model, sourceProperty: "clearText", mutual: true))
				hbox{
					button(text:'encode', actionPerformed: {
						println "encoding..."
						model.clearText = clearTextField.text
						model.encode()
					})
					button(text:'decode', actionPerformed: {
						println "decoding..."
						model.encodedText = encodedTextField.text
						model.decode()
					})
				}
				encodedTextField = textField(text: bind(source:model, sourceProperty: "encodedText", mutual: true))
				button(text:'Close',
				actionPerformed: {
					println "Closing window..."
					System.exit(0)//crude but effective
				})
			}
		}
	}
}