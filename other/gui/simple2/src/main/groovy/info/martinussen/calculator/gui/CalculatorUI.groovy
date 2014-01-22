package info.martinussen.calculator.gui

import java.awt.*
import javax.swing.*
import groovy.swing.SwingBuilder
import info.martinussen.calculator.model.*


def model = new CalculatorModel()
//test begin
model.disp = 41
model.enter()
model.disp = 1
model.add()
//test end
new SwingBuilder().edt {
	frame(title:'Calculator', defaultCloseOperation:JFrame.EXIT_ON_CLOSE, size:[275,150], show: true) { // pack:true
		vbox {
			hbox{
				displayField = textField(text: bind(source:model, sourceProperty: "disp"))
			}
			hbox {
				button(text:'1')
				button(text:'2')
				button(text:'3')
			}
			hbox {
				button(text:'4')
				button(text:'5')
				button(text:'6')
			}
			hbox {
				button(text:'7')
				button(text:'8')
				button(text:'9')
			}
			hbox {
				button(text:'Close',
				actionPerformed: {
					println "Closing window..."
					System.exit(0)//crude but effective
				})
			}
		}
	}
}