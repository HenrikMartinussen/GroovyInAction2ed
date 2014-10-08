//http://groovy.codehaus.org/Regular+Expressions
import java.util.regex.Pattern
import java.util.regex.Matcher


// ~ creates a Pattern from String
def pattern = ~/foo/
assert pattern instanceof Pattern
assert pattern.matcher("foo").matches() 
assert !pattern.matcher("foobar").matches() // matches() must match whole String

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