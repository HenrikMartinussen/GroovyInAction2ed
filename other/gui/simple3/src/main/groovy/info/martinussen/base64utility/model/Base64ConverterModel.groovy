package info.martinussen.base64utility.model

import groovy.beans.Bindable

/**
 * model class is meant to reflect the display, 
 * registers, and operations of a simple 
 * rpn calculator (hp-style)
 */
class Base64ConverterModel {
  @Bindable String clearText = ''
  @Bindable String encodedText = ''
	
  def decode(){
	  setClearText(new String(encodedText.decodeBase64())) 
  }
  
  def encode(){
	  setEncodedText(clearText.bytes.encodeBase64().toString())
  }  
 
  
}
