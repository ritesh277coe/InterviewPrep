
### Stream
    Map<Integer, Integer> map = new HashMap<>();
    List<Map.Entry<Integer, Integer>> l = map
            .entrySet()
            .stream()
            .sorted((a, b) -> {return b.getValue() - a.getValue();})
            .collect(Collectors.toList());

### Priority Queue
    Queue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
    Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    Queue<Integer> maxHeap1 = new PriorityQueue<>(Collections.reverseOrder());

### Arrays
    int[] arr = new int[10];
    Arrays.sort(arr);
    Arrays.sort(arr, (Integer a, Integer b) -> {return a.compareTo(b);});

    //Allocate 2D array:
    int[][] arr2D = new int[10][20];
    for (int row = 0; i < arr2D.length; i++) {
        Deque<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[] {1, 2});
        Integer[] arr1 = q.poll();
    }
}

##### Sort a string
    String original = "edcba";
    char[] chars = original.toCharArray();
    Arrays.sort(chars);
    String sorted = new String(chars);
    System.out.println(sorted);


#### Substring
    s = "012345678"
    prefix of str s.subString(0, 3); //012
    suffix of str s.subString(3); //345678

#### Get stream out of string
    String s = " test string";
    String arr[] = s.trim.split("\\s+");
    Arrays.stream(arr).
    or
    Stream.of(arr)..

#### Split string using regex
    String str = "test"
    Stream.of(str.split(""))

### Update/add new key in hashmap
    map.put(key, map.getOrDefault(key, 0) + 1);

#### TriNode
    TrieNode {
        Map<Character, TrieNode> m;
        boolean isWord;
    }