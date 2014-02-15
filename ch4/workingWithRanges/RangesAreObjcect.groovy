//Listing 4.2 Ranges are objects
//ReGinA 2.ed p. 96/97

def result = '' //#A
(5..9).each { element -> 
    result += element 
} 
assert result == '56789'

assert 5 in 0..10 
assert (0..10).isCase(5) 

def age = 36
switch(age){
    case 16..20 : insuranceRate = 0.05 ; break
    case 21..50 : insuranceRate = 0.06 ; break
    case 51..65 : insuranceRate = 0.07 ; break
    default: throw new IllegalArgumentException()
}
assert insuranceRate == 0.06