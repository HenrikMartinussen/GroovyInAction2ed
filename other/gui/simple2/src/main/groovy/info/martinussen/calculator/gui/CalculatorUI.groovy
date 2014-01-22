package info.martinussen.calculator.gui

import javax.sound.midi.MidiDevice.Info;
import javax.swing.JFrame
import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL
import info.martinussen.calculator.model.*


def model = new CalculatorModel()
new SwingBuilder().edt {
	frame(title:'Frame', defaultCloseOperation:JFrame.EXIT_ON_CLOSE, size:[275,150], show: true) { // pack:true
		borderLayout()
		textlabel = label(
				text: bind(source:model,
				sourceProperty: "disp",
				converter: {v ->  v? "Clicked $v times": '' }),
				constraints: BL.NORTH)
		hbox (constraints:BL.SOUTH){
			button(text:'Increment',
			actionPerformed: {
				model.enter()
				model.disp = 2
				model.add()
				println "display: ${model.disp}"
			})
			button(text:'Decrement',
			actionPerformed: {
				model.enter()
				model.disp = 3
				model.subtract()
				println "display: ${model.disp}"

			})

			button(text:'Close',
			actionPerformed: {
				println "Fenster schliessen bitte..."
				System.exit(0)//crude but effective
			})
		}
	}
}