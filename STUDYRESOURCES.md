# Collection of study resources about data structure and algorithms

## General guides

General guides:

- [Algorithm Preparation](https://hackmd.io/s/SJIV-n7B)
- [Every Programmer Should Know]([https://github.com/mr-mig/every-programmer-should-know/])

Visualizing:

- [Data Structure and Algorithms Visualizations 1](http://www.cs.usfca.edu/~galles/visualization/Algorithms.html)
- [Data Structure and Algorithms Visualizations 2](https://visualgo.net)

## Big-O

- [Cheat sheet](http://www.souravsengupta.com/cds2016/lectures/Complexity_Cheatsheet.pdf)
- [Big-O quiz](https://bigoquiz.com)

### Data structures

#### General purpose

|Type                                       |Access |Search |Insert |Delete |Space  |
|-|-|-|-|-|-|
|Array                                      |O(1)   |O(n)   |O(n)   |O(n)   |O(n)   |
|Queue/Stack/Singly-Linked List/Doubly-Linked List |O(n)   |O(n)   |O(1)   |O(1)   |O(n)   |
|SkipList                                   |O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(n log(n))|
|HashTable                                  |N/A    |O(1)   |O(1)   |O(1)   |O(N)   |
|Trees (BST, RBT, B-Tree, AVL Tree, KD Tree) |O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(n)   |
|Trees (Cartesian Tree, Splay Tree)|N/A|O(log(n))|O(log(n))|O(log(n))|O(n)|

#### Special Purpose

Heap:

|Type |Find |Delete |Insert |Decrease key |Merge|
|-|-|-|-|-|-|
|Binary|O(1)|O(log(n))|O(log(n))|O(log(n))|O(log(n))|O(n)|

Trie:

|Type|Search|Insertion|
|-|-|-|
|String|O(k)|O(k)|

Graph:

| Node/edge management | Storage size | Add vertex | Add edge | Remove vertex | Remove edge | Query |
|-|-|-|-|-|-|-|
|Adjacency list | O (\|V\| + \|E\|) | O(1) | O(1) | O (\|V\| + \|E\|) | O(\|E\|) |  O(\|V\|) |
|Adjacency matrix | O(\|V\|^2) | O(\|V\|^2) | O(1) | O(\|V\|^2) | O(1) | O(1) |

### Algorithms

#### Sorting

|Name|Type|Avergage|Space|
|-|-|-|-|
|Quicksort|C|O(n log(n))|O(log(n))|
|Merge Sort|C|O(n log(n))|O(n)|
|Timsort|C|O(n log(n))|O(n)|
|Heapsort|C|O(n log(n))|O(1)|
|Binary Tree Sort|C|O(n log(n))|O(n)|
|Cubesort|C|O(n log(n))|O(n)|
|Shell Sort|C|O((n log(n))^2|O(1)|
|Bubble Sort|C|O(n^2)|O(1)|
|Insertion Sort|C|O(n^2)|O(1)|
|Selection Sort|C|O(n^2)|O(1)|
|Bucket Sort|NC|O(n+k)|O(n)|
|Counting Sort|NC|O(n+k)|O(k)|
|Radix Sort|NC|O(nk)|O(n+k)|

#### Searching

|Name|Data structure|Worst Case|
|-|-|-|
|Sequential Search|Array and linked list|O(n)|
|Binary Search|Sorted Array and binary search tree|O(log(n))|
|Depth-fisrt Search|Graph of \|V\| vertices and \|E\| edges|O(\|V\| + \|E\|)|
|Breath-first Search|Graph of \|V\| vertices and \|E\| edges|O(\|V\| + \|E\|)|

## Data structures

Choosing a data structure:

- [Flowchart to choose data structures](https://kaanmutlu.files.wordpress.com/2011/12/collections.png)
- [Java 8 Collection Overview](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)
- [Java Collections Cheat Sheet](http://files.zeroturnaround.com/pdf/zt_java_collections_cheat_sheet.pdf)

### General purpose

|Interface  | Hash Table    | Resizable Array   | Balanced Tree | Linked List   | Hash Table + Linked List  |
|-|-|-|-|-|-|
|Set        | HashSet       |                   | TreeSet       |               | LinkedHashSet             |
|List       |               | ArrayList	        |               | LinkedList	|                           |
|Deque      |               | ArrayDeque        |               | LinkedList	|                           |
|Map        | HashMap       |                   | TreeMap	 	|               | LinkedHashMap             |

Types:

- **Set**: No Duplicates, One Null, No Order
- **List**: Allow Duplicates, Allow Null, Ordered, Random Access
- **Deque**: Allow Duplicates, No Null, Ordered
- **Map**: No Duplicates

Implementations:

- **Hash**: Fast
- **Array**: Insertion Order
- **Balanced Tree**: Key/Value Sorter
- **Linked List**: Insertion Order
- **Hash Table + Linked List**: Insertion Order

Usefulness:

- **HashTable**: Used for fast data lookup - symbol table for compilers, database indexing, caches, unique data representation.
- **Deque**:
    - **Stack**: Undo\redo operation in word processors, Expression evaluation and syntax parsing, many virtual machines like JVM are stack oriented.
    - **Queues**: Transport and operations research where various entities are stored and held to be processed later ie the queue performs the function of a buffer.    

Common modifiers:

- **CopyOnWrite**: Instead of writing directly to the data storage, copy it first, then write, so readers do not suffer from concurrent modification. Specially useful when there are lots of read and a few writes.
- **WeekReference**: Weak references allow you to leverage the garbage collector's ability to determine reachability for you, so you don't have to do it yourself.

### Special Purpose

Types:

- **Tree**: A tree data structure can be defined recursively (locally) as a collection of nodes (starting at a root node), where each node is a data structure consisting of a value, together with a list of references to nodes (the "children"), with the constraints that no reference is duplicated, and none points to the root.
- **Heap**: Also known as Priority Queue, a heap can be classified further as either a "max heap" or a "min heap". In a max heap, the keys of parent nodes are always greater than or equal to those of the children and the highest key is in the root node. In a min heap, the keys of parent nodes are less than or equal to those of the children and the lowest key is in the root node. [Data Structures: Heap](https://www.youtube.com/watch?v=t0Cq6tVNRBA)
- **Trie**: In computer science, a trie, also called digital tree and sometimes radix tree or prefix tree (as they can be searched by prefixes), is a kind of search tree—an ordered tree data structure that is used to store a dynamic set or associative array where the keys are usually strings.
- **Graph**: A graph data structure consists of a finite (and possibly mutable) set of vertices or nodes or points, together with a set of unordered pairs of these vertices for an undirected graph or a set of ordered pairs for a directed graph. 

Implementations:

- **Tree**
    - Unbalanced
        - BST: Binary search tree where every node as at most 2 child, ordered in insertion and with logaritimic time complexity in average.
    - Auto-balanced
        - AVL Tree: Binary search tree with rotations on insertion and deletion to balance the tree
        - RBT: Close to AVL Tree, but uses a coloring technic to balance the tree
        - B-Tree: Store nodes in packs of X keeping the tree relatively balanced, useful for storing blocks of data (nodes)
        - KD Tree: Balances the three every K dimentions
    - Specific
        - Splay Tree: Organizes a tree by moving the last acessed item to the top through rotations
- **Heap**
    - Min Heap: Heap where larger values are closer to the root
    - Max Heap: Heap where smaller values are closer to the root
    - PriorityQueue: The same as Min/Max Heap but with a custom comparator

Usefulness:

- **Tree**:
    1.	Manipulate hierarchical data.
    2.	Make information easy to search (see tree traversal).
    3.	Manipulate sorted lists of data.
    4.	As a workflow for compositing digital images for visual effects.
    5.	Router algorithms
- **Heap**:
    1. Heap Sort: Heap Sort uses Binary Heap to sort an array in O(nLogn) time.
    2. Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently.
    3. Graph Algorithms: The priority queues are especially used in Graph Algorithms like Dijkstra’s Shortest Path and Prim’s Minimum Spanning Tree.
    4. Many problems can be efficiently solved using Heaps. See following for example.
        a. K’th Largest Element in an array.
        b. Sort an almost sorted array.
        c. Merge K Sorted Arrays.
- **Trie**:
    1. As a replacement for other data structures
    2. Dictionary representation
    3. Term indexing
- **Graph**:
    1. Computing the minimum spanning tree.
    2. Determine the shortest path between two nodes.
    3. Matching and detection of cut vertexes.

## Algorithms

### Sorting

- **Quicksort**: Comparison Sort, Partitioning
    - Recursive
    - Pivot
        1. Correct position in final, sorted array
        2. Items to the left are smaller
        3. Items to the right are larger
        ```
        Quicksort(A as array, low as int, high as int)
            if (low < high)
                pivot_location = Partition(A, low, high)
                Quicksort(A, low, pivot_location)
                Quicksort(A, pivot_location + 1, high)

        Partition(A as array, low as int, high as int)
            pivot = A[low]
            leftwall = low

            for i = low + 1 to high
                if (A[i] < pivot) then
                    swap(A[i], A[leftwall])
                    leftwall += 1

            swap(pivot, A[leftwall])

            return (leftwall)
        ```
- **Merge Sort**: Comparison Sort, Merging
    - Recursive
    - Divide and Conquer
        ```
        MergeSort(A as array)
            if (n == 1)
                return A;

            arrayOne = a[0] ... a[n/2]
            arrayTwo = a[(n/2)+1] .. a[n]

            arrayOne = MergeSort(arrayOne)
            arrayTwo = MergeSort(arrayTwo)

            return Merge(arrayOne, arrayTwo)

        Merge(A as array, B as array)
            C as array

            while (A and B have elements)
                if (A[0] > B[0])
                    add B[0] to the end of C
                    remove B[0] from B
                else
                    add A[0] to the end of C
                    remove A[0] from A

            while (A has elements)
                add A[0] to the end of C
                remove A[0] from A

            while (B has elements)
                add B[0] to the end of C
                remove B[0] from B

            return C
        ```
- **Timsort**: Comparison Sort, Insertion & Merging
    - A mix between Insertion Sort and Merging depending of the size of what is been sorted.
- **Heapsort**: Comparison Sort, Selection
    - Uses a max heap and order the array by getting the max value and putting it to the end of the array and heapify again.
    ```
    Heapsort(A as array)
        BuildMaxHeap(A)
        for i = n to 1
            swap(A[1], A[i])
            n -= 1
            Heapify(A, 1)
        
    BuildMaxHeap(A as array)
        n = elements_in(A)
        for i = floor(n/2) to 1
            Heapify(A, i)
    
    Heapify(A as array, i as int)
        left = 2i
        right = 2i + 1
        if (left <= n) and (A[left] > A[i])
            max = left
        else
            max = i

        if (right <= n) and (A[right] > A[max])
            max = right

        if (max != i)
            swap(A[i], A[max])
            Heapfy(A, max)
    ```
- **Binary Tree Sort**: Comparison Sort, Insertion
    ```
    TreeSort(A as array)
        T as tree

        for (each V as value in A)
            Insert(T, V)
        
        return InOrder(T)

    Insert(R as node, V as value)
        if R == null then
            R = valur
        else
            if (value < R) then
                Insert(R.left, value)
            else
                Insert(R.right, value)

    InOrder(N as node)
        if N == null then return
        InOrder(N.left)
        Visit(N)
        InOrder(N.right)
    ```
- **Cube Sort**: Comparison Sort, Insertion
    - Cubesort is a parallel sorting algorithm that builds a self-balancing multi-dimensional array from the keys to be sorted. As the axes are of similar length the structure resembles a cube. After each key is inserted the cube can be rapidly converted to an array.
- **Shell Sort**: Comparison Sort, Insertion
    - It can be seen as either a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort). The method starts by sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be compared.
- **Bubble Sort**: Comparison Sort, Exchanging
    ```
    BubbleSort(A as array)
        for I from 1 to N
            for J from 0 to N-1
                if A[J] > A[J+1]
                    swap(A[J], A[J+1]) 
    ```
- **Insertion Sort**: Comparison Sort, Insertion
    1. Work left to right
    2. Examine each item and compare it to items on its left
    3. Insert the item in the correct position in the array
    ```
    InsertionSort(A as array)
        for I from 1 to length(A) - 1
            J = 1
            while J > 0 and A[J-1] > A[J]
                swap(A[j], A[J+1])
                J -= 1
    ```
- **Selection Sort**: Comparison Sort, Selection
    ```
    SelectionSort(A as array)
        for (j = 0; j < n-1; j++)
            int iMin = j;
            for (i = j + 1; i < n; i++) 
                if (a[i] < a[iMin])
                    iMin = 1;
            
            if (iMin != j)
                swap(a[j], a[iMin])
    ```
- **Bucket Sort**: Non-comparison Sort
    - Bucket sort, or bin sort, is a sorting algorithm that works by distributing the elements of an array into a number of buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively applying the bucket sorting algorithm.
    ```
    BucketSort(array, n)
        buckets ← new array of n empty lists
        for i = 0 to (length(array)-1) do
            insert array[i] into buckets[msbits(array[i], k)]
        for i = 0 to n - 1 do
            nextSort(buckets[i]);
        return the concatenation of buckets[0], ...., buckets[n-1]
    ```
- **Counting Sort**: Non-comparison Sort
    - Counting sort is an algorithm for sorting a collection of objects according to keys that are small integers; that is, it is an integer sorting algorithm. It operates by counting the number of objects that have each distinct key value, and using arithmetic on those counts to determine the positions of each key value in the output sequence.
- **Radix Sort**: Non-comparison Sort
    - Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by grouping keys by the individual digits which share the same significant position and value. 

### Searching (Trees and Graphs)

- **Binary Search**
    1. If the value is larger than the node value go to the right
    2. If the value is smaller than the node value go to the left
- **Depth-first Search** (Stack)
    - Pre Order
        1. Visit node
        2. Traverse left
        3. Traverse right
        ```
        PreOrder(N as node)
            if N == null then return
            Visit(N)
            PreOrder(N.left)
            PreOrder(N.right)
        ```
    - In Order (Natural Order)
        1. Traverse left
        2. Visist node
        3. Traverse right
        ```
        InOrder(N as node)
            if N == null then return
            InOrder(N.left)
            Visit(N)
            InOrder(N.right)
        ```
    - Post Order
        1. Traverse left
        2. Traverse right
        3. Visit
        ```
        PostOrder(N as node)
            if N == null then return
            PostOrder(N.left)            
            PostOrder(N.right)
            Visit(N)
        ```
- **Breath-first Search** (Queue)
    - Level Order
        ```
        LevelOrder(N as node)
            Q as empty queue 
            Q.enqueue(N)
            while (Q is not empty)
                currentNode = Q.dequeue()
                Visit(currentNode)
                if (currentNode.left != null)
                    Q.enqueue(currentNode.left)
                if (currentNode.right != null)
                    Q.enqueue(currentNode.right)
        ```
- **Dijkstra** (Priority Queue)
    ```
    Dijkstra(Graph, source):
        dist[source] ← 0                                    // Initialization
        create vertex set Q
        for each vertex v in Graph:           
            if v ≠ source
                dist[v] ← INFINITY                          // Unknown distance from source to v
                prev[v] ← UNDEFINED                         // Predecessor of v

            Q.add_with_priority(v, dist[v])

        while Q is not empty:                              // The main loop
            u ← Q.extract_min()                            // Remove and return best vertex
            for each neighbor v of u:                      // only v that is still in Q
                alt ← dist[u] + length(u, v) 
                if alt < dist[v]
                    dist[v] ← alt
                    prev[v] ← u
                    Q.decrease_priority(v, alt)

        return dist[], prev[]
    ```
- **A\***
    - Dijkstra + Heuristics
    ```
    A*(start, goal)
        // The set of nodes already evaluated
        closedSet := {}

        // The set of currently discovered nodes that are not evaluated yet.
        // Initially, only the start node is known.
        openSet := {start}

        // For each node, which node it can most efficiently be reached from.
        // If a node can be reached from many nodes, cameFrom will eventually contain the
        // most efficient previous step.
        cameFrom := the empty map

        // For each node, the cost of getting from the start node to that node.
        gScore := map with default value of Infinity

        // The cost of going from start to start is zero.
        gScore[start] := 0

        // For each node, the total cost of getting from the start node to the goal
        // by passing by that node. That value is partly known, partly heuristic.
        fScore := map with default value of Infinity

        // For the first node, that value is completely heuristic.
        fScore[start] := heuristic_cost_estimate(start, goal)

        while openSet is not empty
            current := the node in openSet having the lowest fScore[] value
            if current = goal
                return reconstruct_path(cameFrom, current)

            openSet.Remove(current)
            closedSet.Add(current)

            for each neighbor of current
                if neighbor in closedSet
                    continue		// Ignore the neighbor which is already evaluated.

                if neighbor not in openSet	// Discover a new node
                    openSet.Add(neighbor)
                
                // The distance from start to a neighbor
                tentative_gScore := gScore[current] + dist_between(current, neighbor)
                if tentative_gScore >= gScore[neighbor]
                    continue		// This is not a better path.

                // This path is the best until now. Record it!
                cameFrom[neighbor] := current
                gScore[neighbor] := tentative_gScore
                fScore[neighbor] := gScore[neighbor] + heuristic_cost_estimate(neighbor, goal) 

        return failure

    reconstruct_path(cameFrom, current)
        total_path := [current]
        while current in cameFrom.Keys:
            current := cameFrom[current]
            total_path.append(current)
        return total_path
    ```

Usefulness:

- **Binary search**: Fast search O(log(n))
- **Depth-first Search**:
    1. Finding Connected Components of the graph.
    2. Linear ordering of the graph using Topological Sorting ( useful in solving dependency problems ).
    3. Finding Strongly Connected Components.
    4. Solving maze problems ( finding exit of the maze ).
    5. Finding Cycle in graphs and also finding the largest Cycle.
    - Pre Order: Pre Order traversal is used to create a copy of the tree. Pre Order traversal is also used to get the prefix expression of an expression tree. 
    - In Order: In case of binary search trees (BST), In Order traversal gives nodes in non-decreasing order. To get nodes of BST in non-increasing order, a variation of In Order traversal where In Order traversal is reversed, can be used.
    - Post Order: Post Order traversal is used to delete the tree. Post Order traversal is also useful to get the postfix expression of an expression tree.
- **Breath-first Search**:
    1. Finding Shortest path from Source to other vertices in an unweighted graph.
    2. Finding quickest and efficient solution of a puzzle ( eg. Rubik’s cube) by applying BFS on the state space.
    3. Creating Bipartite Graphs.
- **Dijkstra**: Shortest path algorithm
- **A\***: Shortest path algorithm

## Tricks

- The sum of all numbers between 1-100 = (100+1) * ((100) / 2).
- Binary Heap on a List
    - i Left = 2i + 1
    - i Right = 2i + 2
    - i Parent = (i - 1)/2