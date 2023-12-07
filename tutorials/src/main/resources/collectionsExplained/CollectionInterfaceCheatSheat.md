###Concrete Collection classes

###Collection<E> extends Iterable<E> {

    int size();
    boolean isEmpty();
    boolean equals(Object o);
    int hashCode();

    Object[] toArray();  <T> T[] toArray(T[] a);
    boolean add(E e);  boolean addAll(Collection<? extends E> c);
    boolean remove(Object o);  boolean removeAll(Collection<?> c);  
    default boolean removeIf(Predicate<? super E> filter); void clear();
    boolean contains(Object o);  boolean containsAll(Collection<?> c); boolean retainAll(Collection<?> c);

    Iterator<E> iterator();

    @Override
    default Spliterator<E> spliterator();
    default Stream<E> stream();
    default Stream<E> parallelStream();
}

###List<E> extends Collection<E> {

    E get(int index)
    boolean add(int index, E object);  boolean set(int index, E object);
    E remove(int index);
}

###Concrete classes for List: ArrayList, LinkedList

###Queue<E> extends Collection<E> {

    E poll(); //Retrieves and removes the head of this queue, or returns null if this queue is empty.
    E peek(); //Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
}

###Concrete classes for Queue: 
    
    PriorityQueue, LinkedList, ArrayQueue, ArrayBlockingQueue, DelayQueue, LinkedBlockingQueue, PriorityBlockingQueue

###Deque<E> extends Collection<E> {

    void addFirst(E obj); void addLast(E obj);
    E removeFirst(E obj); E removeLast(E obj);
    E pollFirst(); E pollLast();
    E peekFirst(); E peekLast();
}

###Concrete classes for Deque: ArrayDeque, LinkedList

###public interface Set<E> extends Collection<E> {

    //ALL collection function and no new function
}

###public interface SortedSet<E> extends Set<E> {

    Return the comparator used to sort
    Comparator<? super E> comparator(); 
}

###Concrete classes for Set: HashSet, TreeSet(Comparator<E> c)

public interface Map<K,V> {

    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    V get(Object key);
    V put(K key, V value);
    void putAll(Map<? extends K, ? extends V> m);
    V remove(Object key);
    void clear();
    Set<K> keySet();
    Set<Map.Entry<K, V>> entrySet();
    Collection<V> values();

    interface Entry<K,V> {
        K getKey();
        V getValue();
        V setValue(V value);
        boolean equals(Object o);
        int hashCode();
        public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey() {
            return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> c1.getKey().compareTo(c2.getKey());
        }

        public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
            return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> c1.getValue().compareTo(c2.getValue());
        }

        public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
            Objects.requireNonNull(cmp);
            return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
        }

        public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
            Objects.requireNonNull(cmp);
            return (Comparator<Map.Entry<K, V>> & Serializable)
                (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
        }
    }

    boolean equals(Object o);
    int hashCode();
    default V getOrDefault(Object key, V defaultValue) {
        V v;
        return (((v = get(key)) != null) || containsKey(key))
            ? v
            : defaultValue;
    }

    default void forEach(BiConsumer<? super K, ? super V> action) {
        Objects.requireNonNull(action);
        for (Map.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
            action.accept(k, v);
        }
    }

    default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        Objects.requireNonNull(function);
        for (Map.Entry<K, V> entry : entrySet()) {
            K k;
            V v;
            try {
                k = entry.getKey();
                v = entry.getValue();
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }

            // ise thrown from function is not a cme.
            v = function.apply(k, v);

            try {
                entry.setValue(v);
            } catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                throw new ConcurrentModificationException(ise);
            }
        }
    }

    default V putIfAbsent(K key, V value) {
        V v = get(key);
        if (v == null) {
            v = put(key, value);
        }

        return v;
    }

    default boolean remove(Object key, Object value) {
        Object curValue = get(key);
        if (!Objects.equals(curValue, value) ||
            (curValue == null && !containsKey(key))) {
            return false;
        }
        remove(key);
        return true;
    }

    default boolean replace(K key, V oldValue, V newValue) {
        Object curValue = get(key);
        if (!Objects.equals(curValue, oldValue) ||
            (curValue == null && !containsKey(key))) {
            return false;
        }
        put(key, newValue);
        return true;
    }

    default V replace(K key, V value) {
        V curValue;
        if (((curValue = get(key)) != null) || containsKey(key)) {
            curValue = put(key, value);
        }
        return curValue;
    }

    default V computeIfAbsent(K key,
            Function<? super K, ? extends V> mappingFunction) {
        Objects.requireNonNull(mappingFunction);
        V v;
        if ((v = get(key)) == null) {
            V newValue;
            if ((newValue = mappingFunction.apply(key)) != null) {
                put(key, newValue);
                return newValue;
            }
        }

        return v;
    }

    default V computeIfPresent(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue;
        if ((oldValue = get(key)) != null) {
            V newValue = remappingFunction.apply(key, oldValue);
            if (newValue != null) {
                put(key, newValue);
                return newValue;
            } else {
                remove(key);
                return null;
            }
        } else {
            return null;
        }
    }

    default V compute(K key,
            BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        V oldValue = get(key);

        V newValue = remappingFunction.apply(key, oldValue);
        if (newValue == null) {
            // delete mapping
            if (oldValue != null || containsKey(key)) {
                // something to remove
                remove(key);
                return null;
            } else {
                // nothing to do. Leave things as they were.
                return null;
            }
        } else {
            // add or replace old mapping
            put(key, newValue);
            return newValue;
        }
    }

    default V merge(K key, V value,
            BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        Objects.requireNonNull(remappingFunction);
        Objects.requireNonNull(value);
        V oldValue = get(key);
        V newValue = (oldValue == null) ? value :
                   remappingFunction.apply(oldValue, value);
        if(newValue == null) {
            remove(key);
        } else {
            put(key, newValue);
        }
        return newValue;
    }
}

###Concrete classes for Map: HashMap, TreeMap


##Bit details about Concrete classes
`ArrayList`

    An indexed sequence that grows and shrinks dynamically

`LinkedList`

    An ordered sequence that allows efficient insertions and removal at any location

`HashSet`

    An unordered collection that rejects duplicates

`TreeSet`

    A sorted set

`EnumSet`

    A set of enumerated type values

`LinkedHashSet`

    A set that remembers the order in which elements were inserted

`PriorityQueue`

    A collection that allows efficient removal of the smallest element

`HashMap`

    A data structure that stores key/value associations

`TreeMap`

    A map in which the keys are sorted

`EnumMap`

    A map in which the keys belong to an enumerated type

`LinkedHashMap`

    A map that remembers the order in which entries were added

`WeakHashMap`

    A map with values that can be reclaimed by the garbage collector if they are not used elsewhere

`IdentityHashMap`

    A map with keys that are compared by ==, not equals
