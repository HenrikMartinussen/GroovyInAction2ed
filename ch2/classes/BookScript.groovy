Book gina = new Book('Groovy in Action, 2nd edition')

assert gina.getTitle() == 'Groovy in Action, 2nd edition'
assert getTitleBackwards(gina) == 'noitide dn2 ,noitcA ni yvoorG'

String getTitleBackwards(book){
    String title = book.getTitle()
    return title.reverse()
}