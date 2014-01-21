class BookBean {
String title //#A
}

def groovyBook = new BookBean(title:'Groovy in Action')
assert groovyBook.getTitle() == 'Groovy in Action' //#B

groovyBook.setTitle('Groovy in Action, 2nd ed.') //#B
assert groovyBook.getTitle() == 'Groovy in Action, 2nd ed.' //#B


groovyBook.title = 'Groovy conquers the world' //#C
assert groovyBook.title == 'Groovy conquers the world' //#C