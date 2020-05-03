//http://groovy.codehaus.org/Regular+Expressions
import java.util.regex.Pattern
import java.util.regex.Matcher

def javaPattern = Pattern.compile("foo")
assert javaPattern instanceof Pattern
assert javaPattern.class.name == 'java.util.regex.Pattern'
def javaMatcher = javaPattern.matcher("foobar")
assert javaMatcher instanceof Matcher
assert javaMatcher.class.name == 'java.util.regex.Matcher'
assert !javaMatcher.matches() //foo (Pattern) doesn't match exactly foobar (Matcher)
assert javaMatcher.find()     //-but foobar (Matcher) contains foo (Pattern)
javaMatcher.reset("foo")      //re-use the Matcher  - the Pattern is unchanged
assert javaMatcher.matches()  //foo (Pattern) matches exactly foo (Pattern)

assert 'abc123,.-'.matches('.*123.*')   //The String.matches method accepts a regex pattern
assert 'abc123,.-'.matches(/.*\d{3}.*/)

// ~ creates a Pattern from String
def pattern = ~/foo/
assert pattern instanceof Pattern
assert pattern.class.name == 'java.util.regex.Pattern'
assert pattern.matcher("foo").matches() 
assert !pattern.matcher("foobar").matches() // matches() must match whole String
assert pattern.matcher('foobar').find()     // find() accepts partial match

assert "cheesechesse" =~ 'cheese' //String
assert "cheesechesse" =~ "cheese" //GString
assert "cheesechesse" =~ /cheese/ //Slashy String
assert "cheese" == 'cheese'
assert "cheese" == /cheese/

assert "2014" ==~ /\d*/          //matches 0 or more digits
assert "2014" ==~ /\d+/          //matches 1 or more digits
assert "2014" ==~ /\d{4}/        //matches exactly 4 digits
assert !("2014" ==~ /\d{3}/)     //doesn't match exactly 3 digits

assert !("Laforge" ==~ /\d*/)    //doesn't match 0 or more digits
assert !("Laforge" ==~ /\d+/)    //doesn't match 1 or more digits
assert !("Laforge" ==~ /\d{0}/)  //doesn't match exactly 0 digit characters
assert "Laforge" ==~ /\D*/       //matches 0 or more non digit characters


assert "Laforge" ==~ /\w*/       //matches 0 or more word characters
assert "Laforge" ==~ /\w+/       //matches 1 or more word characters
assert "Laforge" ==~ /\w{7}/     //matches exactly 7 word characters
assert !("Laforge" ==~ /\w{6}/)  //doesn't match exactly 6 word characters


def matcher = "cheesecheese" =~ /cheese/
assert matcher instanceof Matcher

def cheese = ("cheesecheese" =~ /cheese/).replaceFirst('nice')
assert cheese == 'nicecheese'

assert "color" == "colour".replaceFirst(/ou/, 'o')
cheese = ("cheesecheese" =~ /cheese/).replaceAll('nice')
assert cheese == 'nicenice'


def m = "foobarfoo" =~ /o(b.*r)f/
assert m[0][0] == 'obarf'
assert m[0][1] == 'bar'

print 'OK'