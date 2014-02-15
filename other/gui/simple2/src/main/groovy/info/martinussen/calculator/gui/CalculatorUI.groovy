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
		borderLayout(vgap: 5)

		panel(constraints: BorderLayout.CENTER,
		border: compoundBorder([emptyBorder(10)])){
		tableLayout{
			
			tr {
				td(colspan:3){
					displayField = textField(text: bind(source:model, sourceProperty: "disp"))
				}
			}
			tr {
				td {
					button(text:'1')
				}
				td {
					button(text:'2')
			    }
				td {
					button(text:'3')
				}
			}
			tr {
				td {
					button(text:'4')
				}
				td {
					button(text:'5')
				}
				td {
					button(text:'6')
				}
			}
			tr {
				td {
					button(text:'7')
				}
				td {
					button(text:'8')
				}
				td {
					button(text:'9')
				}
			}
			tr {
				td(colspan:3){
					button(text:'Close',
							actionPerformed: {
						println "Closing window..."
						System.exit(0)//crude but effective
					})
				}
			}
		}
	}
		}
		
}