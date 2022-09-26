# Task #17
##### Get all .txt files from one folder and save them to other folder after sorting lines in each. Must be done with using Runnable and Executors.

# Program execution #1
```
Input folder: test_1
Output folder: test_2
nThreads: 5
Added task test_1\a.txt -> test_2\a.txt
 Thread 'pool-1-thread-1' (a.txt) started.
Added task test_1\folder_1\b.txt -> test_2\folder_1\b.txt
  Thread 'pool-1-thread-1' (a.txt) read file.
 Thread 'pool-1-thread-2' (b.txt) started.
Added task test_1\folder_2\c.txt -> test_2\folder_2\c.txt
  Thread 'pool-1-thread-2' (b.txt) read file.
Added task test_1\folder_2\d.txt -> test_2\folder_2\d.txt
 Thread 'pool-1-thread-3' (c.txt) started.
 Thread 'pool-1-thread-4' (d.txt) started.
  Thread 'pool-1-thread-3' (c.txt) read file.
  Thread 'pool-1-thread-4' (d.txt) read file.
Added task test_1\folder_2\folder_3\e.txt -> test_2\folder_2\folder_3\e.txt
 Thread 'pool-1-thread-5' (e.txt) started.
  Thread 'pool-1-thread-5' (e.txt) read file.
   Thread 'pool-1-thread-1' (a.txt) sorted lines.
    Thread 'pool-1-thread-1' (a.txt) finished.
   Thread 'pool-1-thread-2' (b.txt) sorted lines.
    Thread 'pool-1-thread-2' (b.txt) finished.
   Thread 'pool-1-thread-4' (d.txt) sorted lines.
   Thread 'pool-1-thread-3' (c.txt) sorted lines.
    Thread 'pool-1-thread-4' (d.txt) finished.
    Thread 'pool-1-thread-3' (c.txt) finished.
   Thread 'pool-1-thread-5' (e.txt) sorted lines.
    Thread 'pool-1-thread-5' (e.txt) finished.

Executor terminated.
```

# Program execution #2
```
Input folder: test_1
Output folder: test_2
nThreads: 2
Added task test_1\a.txt -> test_2\a.txt
Added task test_1\folder_1\b.txt -> test_2\folder_1\b.txt
 Thread 'pool-1-thread-1' (a.txt) started.
Added task test_1\folder_2\c.txt -> test_2\folder_2\c.txt
  Thread 'pool-1-thread-1' (a.txt) read file.
 Thread 'pool-1-thread-2' (b.txt) started.
Added task test_1\folder_2\d.txt -> test_2\folder_2\d.txt
  Thread 'pool-1-thread-2' (b.txt) read file.
Added task test_1\folder_2\folder_3\e.txt -> test_2\folder_2\folder_3\e.txt
   Thread 'pool-1-thread-1' (a.txt) sorted lines.
   Thread 'pool-1-thread-2' (b.txt) sorted lines.
    Thread 'pool-1-thread-1' (a.txt) finished.
    Thread 'pool-1-thread-2' (b.txt) finished.
 Thread 'pool-1-thread-1' (c.txt) started.
 Thread 'pool-1-thread-2' (d.txt) started.
  Thread 'pool-1-thread-1' (c.txt) read file.
  Thread 'pool-1-thread-2' (d.txt) read file.
   Thread 'pool-1-thread-1' (c.txt) sorted lines.
   Thread 'pool-1-thread-2' (d.txt) sorted lines.
    Thread 'pool-1-thread-1' (c.txt) finished.
    Thread 'pool-1-thread-2' (d.txt) finished.
 Thread 'pool-1-thread-1' (e.txt) started.
  Thread 'pool-1-thread-1' (e.txt) read file.
   Thread 'pool-1-thread-1' (e.txt) sorted lines.
    Thread 'pool-1-thread-1' (e.txt) finished.

Executor terminated.
```

# Program execution #3
```
Input folder: test_1
Output folder: test_2
nThreads: 1
Added task test_1\a.txt -> test_2\a.txt
Added task test_1\folder_1\b.txt -> test_2\folder_1\b.txt
 Thread 'pool-1-thread-1' (a.txt) started.
Added task test_1\folder_2\c.txt -> test_2\folder_2\c.txt
Added task test_1\folder_2\d.txt -> test_2\folder_2\d.txt
  Thread 'pool-1-thread-1' (a.txt) read file.
Added task test_1\folder_2\folder_3\e.txt -> test_2\folder_2\folder_3\e.txt
   Thread 'pool-1-thread-1' (a.txt) sorted lines.
    Thread 'pool-1-thread-1' (a.txt) finished.
 Thread 'pool-1-thread-1' (b.txt) started.
  Thread 'pool-1-thread-1' (b.txt) read file.
   Thread 'pool-1-thread-1' (b.txt) sorted lines.
    Thread 'pool-1-thread-1' (b.txt) finished.
 Thread 'pool-1-thread-1' (c.txt) started.
  Thread 'pool-1-thread-1' (c.txt) read file.
   Thread 'pool-1-thread-1' (c.txt) sorted lines.
    Thread 'pool-1-thread-1' (c.txt) finished.
 Thread 'pool-1-thread-1' (d.txt) started.
  Thread 'pool-1-thread-1' (d.txt) read file.
   Thread 'pool-1-thread-1' (d.txt) sorted lines.
    Thread 'pool-1-thread-1' (d.txt) finished.
 Thread 'pool-1-thread-1' (e.txt) started.
  Thread 'pool-1-thread-1' (e.txt) read file.
   Thread 'pool-1-thread-1' (e.txt) sorted lines.
    Thread 'pool-1-thread-1' (e.txt) finished.

Executor terminated.
```

# "test_1" folder hierarchy:
```
* a.txt
* folder_1:
    * b.txt
* folder_2:
    * c.txt
    * d.txt
    * folder_3:
        * e.txt
```

# Input and output .txt files you can see in test_1 & test_2 folders