package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class T {
    Set<Pair> visited = new HashSet<>();
    Queue<Pair> q = new ArrayDeque<>();

    public class Pair {
        Integer i;
        Integer j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    boolean isVisited(int i, int j)  {
        return visited.contains(new Pair(i, j));
    }

    boolean inBounds(int[][] arr, int i, int j) {
        if ( i < 0 || i >= arr[0].length || j < 0 || j >= arr.length )
            return false;
        return true;
    }

    void addAllChilds(int arr[][], Pair p) {
        int i = p.i;
        int j = p.j;
        int [][] dirs = {{0, 1}, {1, 1}, {1, 0}, {1, -1},
                {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};

        for (int x = 0; x < dirs.length; x++)  {
            if(inBounds(arr, i+dirs[x][0], j+dirs[x][1])) {
                if (!isVisited(i + dirs[x][0], j + dirs[x][1])) {
                    q.add(new Pair(i + dirs[x][0], j + dirs[x][1]));
                }
            }
        }
    }
    int visit(int[][] arr) {
        q.add(new Pair(0, 0));
        int level = 0;
        int levelSize = 0;

        while (q.size() > 0) {
            levelSize = q.size();
            while (levelSize > 0) {
                Pair p = q.poll();

                if (p.i == arr.length-1 && p.j == arr[0].length)
                    return levelSize;

                visited.add(p);
                addAllChilds(arr, p);
                levelSize--;
            }
        }

        return -1;
    }

    public static class Node {
        int data;
        ArrayList<Node> childs;
        Node l;
        Node r;

        public Node() {}
    }
    public int kdist = 3;
    boolean found = false;
    int target = 10;
    int depthOfTarget = -1;
    Set<Node> visitedSet = new HashSet<>();
    Set<Node> nodesFound = new HashSet<>();
    void bfs(Node n, int dist) {
        if (visitedSet.add(n) == false) {
            return;
        }
        if (dist == 0) {
            nodesFound.add(n);
            return;
        }

        Deque<Node> dq = new ArrayDeque<>();
        dq.add(n);
        int level = 0;
        while (dq.size() > 0) {
            if (level == dist) {
                while(dq.size() > 0) {
                    nodesFound.add(dq.pollLast());
                }
                return;
            }
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                Node node = dq.pollLast();
                for (Node c: node.childs) {
                    dq.addLast(c);
                }
            }
            level++;
        }
    }

    void findKthDist(Node n, int depth) {
        if (n == null) {
            return;
        }

        if (n.data == target) {
            bfs(n, kdist);
            found = true;
            depthOfTarget = depth;
            return;
        }

        if (n.childs != null) {
            for (Node c : n.childs) {
                findKthDist(c, depth+1);
                if (found) {
                    if ((depthOfTarget - depth) < kdist && (depthOfTarget - depth) > 0) {
                        bfs(c, (depthOfTarget - depth));
                    }
                }
            }
        }
    }
    Set<String> dict = new HashSet<>();
    boolean wordBreak(String s) {
        for (int i = 1; i < s.length(); i++) {
            String pre = s.substring(0, i);
            String suf = s.substring(i);

            if (dict.contains(pre) && wordBreak(suf))
                return true;
        }
        return false;
    }

    int minParenMove(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i = 0 ; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
               dq.add(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                if (dq.size() > 0 && dq.peekLast().equals('(')) {
                    dq.pollLast();
                } else {
                    dq.addLast(s.charAt(i));
                }
            }
        }
        return dq.size();
    }

    int[] addOne(int[] a) {
        int[] sum = new int[a.length+1];

        int i = a.length -1;
        int j = sum.length -1;
        int c = (a[i]+1)/10;
        sum[j] = (a[i]+1)%10;
        i--;j--;

        for (; i >= 0; i--) {
            int last = c;
            c = (a[i]+last)/10;
            sum[j] = (a[i]+last)%10;
        }
        return sum;
    }


    Node lcs(Node n, int a, int b) {
        if (n == null)
            return null;

        if (n.data == a || n.data == b)
            return n;

        Node l = lcs(n.l, a, b);
        Node r = lcs(n.r, a, b);

        if (l == null && r != null)
            return r;
        if (r == null && l != null)
            return l;
        if (l != null && r != null)
            return n;

        return null;
    }

    public static void rotate(int[][] matrix) {
        int [][] a = matrix;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int l = 0; //x dir
        int r = cols-1; //x dir
        while (l < r) {
            int t = l; //y dir
            int b = r; //y dir
            for (int i = 0; i < r-l; i++) {

                int temp = a[t][l+i];
                a[t][l+i] = a[b-i][l];
                a[b-i][l] = a[b][r-i];
                a[b][r-i] = a[t+i][r];
                a[t+i][r] = temp;
            }
            l++;
            r--;
        }
    }

    public static void spiral(int[][] m) {
        int row = m.length;
        int col = m[0].length;
        int l = 0;
        int r = col-1;
        int b = row-1;
        int t = 0;
        while (l < r && t < b) {

            for (int i = 0; i < r-l; i++) {
                System.out.print(m[t][l+i] + " ");
            }

            for (int i = 0; i < b-t; i++) {
                System.out.print(m[t+i][r] + " ");
            }

            for (int i = 0; i < r-l; i++) {
                System.out.print(m[b][r-i] + " ");
            }

            for (int i = 0; i < b-t; i++) {
                System.out.print(m[b-i][l] + " ");
            }

            l++;
            r--;
            t++;
            b--;
        }
        if (col%2 == 1) {
            System.out.println(m[row/2][col/2]);
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        //abcabcbb
        int L = s.length();
        int l = 0;
        int r = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while (l <=r && r < L) { //l0r0M1 l0r1M2 l0r2M3 l0r3
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(r));
                l++;
            }
            set.add(s.charAt(r));
            r++;
            max = Math.max(max, r-l);
        }
        return max;
    }

    public static String rle(String s) {
        if (s == null)
            return null;
        if (s.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        char lastChar = s.charAt(0);
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (lastChar == s.charAt(i)) {
                //if new char is same as lastChar, increment the count
                count++;
            } else {
                //if new is not same as lastChar, push the char and count to builder
                sb.append(lastChar);
                sb.append(count);
                //Reset the count and lastChar to current char
                lastChar = s.charAt(i);
                count = 1;
            }
        }

        sb.append(lastChar);
        sb.append(count);

        return sb.toString();
    }

    public enum Days {
        SUNDAY("sunday", 1);
        public String day;
        public int num;
        Days(String day, int num) {
         this.day = day;
         this.num = num;
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("21");
        int num = Integer.valueOf(sb.reverse().toString());
        System.out.println(num);

        Days d = Days.SUNDAY;
        System.out.println(d.SUNDAY.day);


        System.gc();
        String cs = rle("aaabbbccdd");
        String k = cs.substring(0, 0);
        k = cs.substring(0);
        cs = rle("");
        cs = rle(null);
        cs = rle("abcd");
        cs = rle("aaaaaaaaaaaa");

        int len = lengthOfLongestSubstring("abcabcbb");
        //int matrix1[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int matrix1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        //int matrix1[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //rotate(matrix1);
        //int matrix[][] = {{1, 2, 3, 4 , 5, 6},{7, 8, 9 , 10, 11, 12},{13, 14, 15, 16, 17, 18},{19, 20, 21 , 22, 23, 24},{25, 26, 27, 28, 29, 30},{31, 32, 33, 34, 35, 36}};
        //rotate(matrix);

        spiral(matrix1);
        int[][] a1 = {{1,2}, {2,3}, {3,4}, {1, 3}};
        Arrays.sort(a1, (int[] a, int[] b) -> {
            if (a[0] != b[0]) {
                if (a[0] < b[0])
                    return -1;
                return 1;
            }
            else if (a[1] < b[1]){
                if(a[1] < b[1])
                    return -1;
                return 1;
            } else {
                return 0;
            }
    });

        String s = "test";

        //Arrays.stream(s.toCharArray())

        int arr[] = {1, 2};
        String reverse = Arrays.stream(arr)
                .mapToObj((i) -> {return String.valueOf(i);})
                .reduce("", (a, x) -> {return x+a;});
        System.out.println(reverse);
         ///////////////////////////////////////////////////////////

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("1", 1);
        map.put("2", 2);
       // Map.Entry<String, Integer> e = map.pollLastEntry();

        Node n = new Node();
        LinkedList<Node> l = new LinkedList<>();
        l.indexOf(null);

        l.addFirst(n);
        l.addFirst(null);
        l.remove(n);
    }
}
