The main functionality of this application is counting and ranking by the frequency of occurrence of characters in an 
arbitrary text.
The text is transmitted via the endpoint "/count" through the request body. The response is a JSON in which the key is 
a character, and the value is the frequency of its occurrence in the text. Pairs are ranked from the most encountered 
character to the least encountered. A character is any letter, digit, special character, space and a newline hyphen.
For example, if you send the text: "111 ## FFFF f" to the endpoint "host:8080/count", you will get the answer:
[
{
"F": 4
},
{
" ": 3
},
{
"1": 3
},
{
"#": 2
},
{
"f": 1
}
]
Output Features:
Letters in different case are considered different characters and are counted separately.
The character " will be output as \" .
The character \ will be output as \\ .
The newline character will be output as \n .

