Book gina = new Book('Groovy in Action, 2nd ed.')

assert gina.getTitle() == 'Groovy in Action, 2nd ed.'
assert getTitleBackwards(gina) == '.de dn2 ,noitcA ni yvoorG'

String getTitleBackwards(book) {
	String title = book.getTitle()
	return title.reverse()
}