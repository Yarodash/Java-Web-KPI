# Task #17
Get all .txt files from one folder and save them to other folder after sorting lines in each.
Must be done with using Runnable and Executors.

# Program execution #1
```
Input folder: test_1
Output folder: test_2
nThreads: 2
Thread 'pool-1-thread-1' (a.txt) started.
Thread 'pool-1-thread-2' (b.txt) started.
Thread 'pool-1-thread-1' (a.txt) read file.
Thread 'pool-1-thread-2' (b.txt) read file.
Thread 'pool-1-thread-2' (b.txt) sorted lines.
Thread 'pool-1-thread-1' (a.txt) sorted lines.
Thread 'pool-1-thread-1' (a.txt) finished.
Thread 'pool-1-thread-2' (b.txt) finished.
Thread 'pool-1-thread-2' (d.txt) started.
Thread 'pool-1-thread-1' (c.txt) started.
Thread 'pool-1-thread-2' (d.txt) read file.
Thread 'pool-1-thread-1' (c.txt) read file.
Thread 'pool-1-thread-1' (c.txt) sorted lines.
Thread 'pool-1-thread-2' (d.txt) sorted lines.
Thread 'pool-1-thread-1' (c.txt) finished.
Thread 'pool-1-thread-1' (e.txt) started.
Thread 'pool-1-thread-2' (d.txt) finished.
Thread 'pool-1-thread-1' (e.txt) read file.
Thread 'pool-1-thread-1' (e.txt) sorted lines.
Thread 'pool-1-thread-1' (e.txt) finished.
Executor terminated.
```

# Program execution #2
```
Input folder: test_1
Output folder: test_2
nThreads: 64
Thread 'pool-1-thread-1' (a.txt) started.
Thread 'pool-1-thread-2' (b.txt) started.
Thread 'pool-1-thread-5' (e.txt) started.
Thread 'pool-1-thread-4' (d.txt) started.
Thread 'pool-1-thread-3' (c.txt) started.
Thread 'pool-1-thread-4' (d.txt) read file.
Thread 'pool-1-thread-5' (e.txt) read file.
Thread 'pool-1-thread-1' (a.txt) read file.
Thread 'pool-1-thread-2' (b.txt) read file.
Thread 'pool-1-thread-3' (c.txt) read file.
Thread 'pool-1-thread-5' (e.txt) sorted lines.
Thread 'pool-1-thread-1' (a.txt) sorted lines.
Thread 'pool-1-thread-3' (c.txt) sorted lines.
Thread 'pool-1-thread-4' (d.txt) sorted lines.
Thread 'pool-1-thread-2' (b.txt) sorted lines.
Thread 'pool-1-thread-1' (a.txt) finished.
Thread 'pool-1-thread-2' (b.txt) finished.
Thread 'pool-1-thread-3' (c.txt) finished.
Thread 'pool-1-thread-5' (e.txt) finished.
Thread 'pool-1-thread-4' (d.txt) finished.
Executor terminated.
```

# "test_1" folder (input):
### test_1/a.txt
```
abcdefgh
ABCDEFGH
abcd
ABCD
ABCE
ABCC
ABCF
ABCA
```

### test_1/b.txt
```
15
20
30
01
04
06
40
42
```

### test_1/c.txt
```
abc
bac
cab
acb
bca
cba
```

### test_1/d.txt
```
ABCDEF
ABCDFE
ACDFDF
ASDSAD
DASDAS
DASDAA
ASDAAS
DASDAS
EQWEWQ
FERWER
ERIEOQ
```

### test_1/e.txt
```
fsdaf
asd
fsa
df
sad
fsa
dgdfghjkdfg
sadf
```

# "test_2" folder (output):
### test_2/a.txt
```
ABCA
ABCC
ABCD
ABCDEFGH
ABCE
ABCF
abcd
abcdefgh
```

### test_2/b.txt
```
01
04
06
15
20
30
40
42
```

### test_2/c.txt
```
abc
acb
bac
bca
cab
cba
```

### test_2/d.txt
```
ABCDEF
ABCDFE
ACDFDF
ASDAAS
ASDSAD
DASDAA
DASDAS
DASDAS
EQWEWQ
ERIEOQ
FERWER
```

### test_1/e.txt
```
asd
df
dgdfghjkdfg
fsa
fsa
fsdaf
sad
sadf
```