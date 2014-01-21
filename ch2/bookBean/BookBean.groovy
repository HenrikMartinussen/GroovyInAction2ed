class Book {
	String title
}


def groovyBook = new Book(title:'Groovy in Action')
assert groovyBook.title == 'Groovy in Action'

groovyBook.setTitle("Groovy in Action, 2nd ed.")
assert groovyBook.title == 'Groovy in Action, 2nd ed.'