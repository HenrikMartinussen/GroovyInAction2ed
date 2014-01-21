import javax.swing.JFrame
import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL

count = 0

def model = new CountingModel()
new SwingBuilder().edt {
  frame(title:'Frame', defaultCloseOperation:JFrame.EXIT_ON_CLOSE, size:[275,150], show: true) { // pack:true
    borderLayout()
    textlabel = label(
                  text: bind(source:model, 
                             sourceProperty: "count", 
                             converter: {v ->  v? "Clicked $v times": '' }), 
                  constraints: BL.NORTH)
    hbox (constraints:BL.SOUTH){
      button(text:'Increment',
         actionPerformed: {
            model.count++ 
            println "${model.count} mal geklickt geworden..."
         }
      )
      button(text:'Decrement',
         actionPerformed: {
             if (model.count > 0){
                 model.count-- 
                 println "${model.count} mal geklickt geworden..."
             }    
         }
      )

      button(text:'Close', 
        actionPerformed: {
            println "Fenster schliessen bitte..."
            System.exit(0)//crude but effective
        }
      )
    }
  }
}