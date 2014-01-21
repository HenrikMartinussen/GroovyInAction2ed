def roman = ['', 'I', 'II', 'III', 'IV', 'V', 'VI', 'VII']
assert roman[6] == 'VI'

assert roman.size() == 8
roman[8] = 'VIII'
assert roman.size() == 9