## Round 1 (N = 1,000,000)

| Algorithm | Time (ms) | Notes |
|-----------|-----------|-------|
| Linear | 0.7345 | |
| Binary | 0.0049 | |

## Round 2 (N = 1,000,000), worst case for linear

| Algorithm | Time (ms) | Notes |
|-----------|-----------|-------|
| Linear | 1.1685| |
| Binary | 0.0033| |

## Big-O discussion
Linear search  takes O(n) time since in the worst case scenario it would have to go through
every number in the list. Binary search takes O(log n) time because each iteration it is reducing the 
number of possibilities by half.

## Caveats (JVM, cache, warmup)
After running my experiments and testing with the best case scenario for linear search (when the target 
is the first value in the list), I notice linear still took much longer which did not make sense so I decided
to run the same experiment twice in main so that the second results would make more sense. This is due to the JVM, cache, and warmup which can affect how long it takes for variables to be accessed and the program to run. When I made this change, the second experiments in main make more sense because in the best case scenario for linear, it beats binary search.