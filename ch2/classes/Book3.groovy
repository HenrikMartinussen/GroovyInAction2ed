import groovy.transform.Immutable

/* Groovy in Action SecondEdition MEAP v17
 * Page 36
 */
@Immutable class FixedBook {                                    //#A
  String title
}

def ginA = new FixedBook(title:'Groovy in Action')
assert ginA.title == 'Groovy in Action'

def ginA2 = new FixedBook('Groovy in Action')                        //#B
assert ginA2.title == 'Groovy in Action'

def reGinA = new FixedBook(title:'Groovy in Action, 2nd ed.')
assert reGinA.title == 'Groovy in Action, 2nd ed.'
assert  "${reGinA.title}" == 'Groovy in Action, 2nd ed.'
assert  "$reGinA.title" == 'Groovy in Action, 2nd ed.'             //apparently curly braces are optional in variables/expressions in GStrings
assert  "'$reGinA.title'" == '\'Groovy in Action, 2nd ed.\''       //single quotes is escaped
assert  "'$reGinA.title'" == /'Groovy in Action, 2nd ed.'/         //slashy string - single quotes are not escaped


assert ginA == ginA2                                                //#D

try {
  ginA.title = ".net is to rule the world"
  assert false, 'should not reach this line'
} catch (ReadOnlyPropertyException expected) {
  println "Expected Error: '${expected.message}'"
}

//#A AST annotation
//#B Positional constructor provided by the @Immutable AST
//#D Deep equals provided by default

