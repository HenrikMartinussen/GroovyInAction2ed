package info.martinussen.calculator.model

import groovy.beans.Bindable

/**
 * model class is meant to reflect the display, 
 * registers, and operations of a simple 
 * rpn calculator (hp-style)
 */
class CalculatorModel {
  @Bindable int reg = 0
  @Bindable int disp = 0
  
 
  
  void enter(){
	  setReg(getDisp())
	  setDisp(0)
  }
  
  void rollDown(){
	  setDisp(getReg())
	  setReg(0)
  }
  
  void add(){
	  def tmp = getReg()
	  tmp += getDisp()
	  setDisp(tmp)
	  setReg(0) 
  }
  
  void subtract(){
	  def tmp = getReg()
	  tmp -= getDisp()
	  setDisp(tmp)
	  setReg(0)
  }
}
