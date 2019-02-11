# Source Code Search Engine

The task is to implement simple search engine on top of source code repositories.

## Description

Your program receives a path to a directory that contains source code. It will traverse the directory 
recursively and index the text files. Your program then will provide users the ability to query the indexed files.

### Reverse index

Imagine you have 2 documents `doc1` and `doc2`. `doc1` contains words `a` and `b`. 
`doc2` contains words `a` and `c`. Let's say that 
`doc1` has number `1` and `doc2` has number `2`. Reverse index is a data structure that looks like this:
```
a - 1,2
b - 1
c - 1
```

## Supported commands

* `index ${abs_path_to_dir}` - creates index directory for the directory
* `search ${query}` - searches the reverse index and returns the files that match the `${query}`
    
### Query format

* `+word` - document must contain this word
* `-word` - document cannot contain this word
* `word` - optional words - if provided then document must contain at least one of these words

#### Examples
* `+class` - finds all files that contain word `class`
* `+main -int` - finds all files that contain word `main` but do not contain word `int`
* `+String` `equals` `trim` - finds all files that contain word `String` and either `equals` or `trim` or both

## Requirements

* commands are read from standard input ("CLI")
* persistent - must retain all data on restart

### Output format

* `index`: 
    * Successfully created index for ${project_name}.
* `search`: 
    * Found ${x} documents for ${query}. List of files: <br/> * file1 <br/> * file2 
 
## Test files

### Simple Test

Command: `index tests/SimpleTest`

Expected output: `Successfully created index for SimpleTest.`

---

Command: `search +a`

Expected output: 
```
Found ${x} documents for ${query}. List of files: 
* doc1.txt 
* doc2.txt
```

---

Command: `search +a -b`

Expected output: 
```
Found ${x} documents for ${query}. List of files: 
* doc2.txt
```

---

Command: `search b c`

Expected output: 
```
Found ${x} documents for ${query}. List of files: 
* doc1.txt 
* doc2.txt
```

### Complex Test

Command: `index tests/ComplexTest`

Expected output: `Successfully created index for ComplexTest.`

---

Command: `search +MyFileUtils`

Expected output: 
```
Found ${x} documents for ${query}. List of files: 
* AntExercise/src/cz/cuni/mff/fileutils/MyFileUtils.java
* README.md
```

---

Good luck :)