def http = [100:'CONTINUE', 200:'OK', 400:'BAD REQUEST']
assert http.size() == 3
assert http[200] == 'OK'

http[500] = 'INTERNAL SERVER ERROR'
assert http.size() == 4

