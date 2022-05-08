# Search
SearchTool:
    Search for keyword in text file. It comprises of two phases: Preprocess and Search

Preprocess Phase:<br>
    - Only Alpha numerics are allowed including short forms such as I'll, I'm, etc,.    
    
Search Phase:<br>
    - Case insensitive comparison<br>
    - As there is no complex pattern matching and search is also going to be line by line basis, String.Contains() is used.

Usage:<br>
To get Exact keyword match
    - Enclose keyword in double quotes:<br>
java Search /Users/valli-4204/Downloads/Search/sample_text.txt \"Web\"

To get Substring matches also for the given keyword:<br>
java Search /Users/valli-4204/Downloads/Search/sample_text.txt Web
