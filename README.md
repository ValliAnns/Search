# Search
SearchTool:
    Search for keyword in text file. It comprises of two phases: Preprocess and Search

Preprocess Phase:
    Only Alpha numerics are allowed including short forms such as I'll, I'm, etc,.    
    
Search Phase:
    - Case insensitive comparison
    - As there is no complex pattern matching and search is also going to be line by line basis, String.Contains() is used.

Usage:
To get Exact keyword match
    - Enclose keyword in double quotes
java Search /Users/valli-4204/Downloads/Search/sample_text.txt \"Web\"

To get Substring matches also for the given keyword:
java Search /Users/valli-4204/Downloads/Search/sample_text.txt Web
