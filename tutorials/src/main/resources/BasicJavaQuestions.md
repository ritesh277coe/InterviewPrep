### Important Core JAVA Concepts:

### Why JAVA not complete oops?
    Because of 8 primitive data types like boolean, char, byte, short, int, float, long, double.

### Why no pointers in JAVA?
    To avoid unsafe/unexpected operations on the memory.
    Garbage collectors controls the lifecycle of memory of object.

### What is JIT compiler?
    Just in time compiler as the JRE decides at runtime that which code needs to be compiled and which code flow can be interpreted.
   
### What is marker interface?
    Cloneable and Serializeable are empty interface
    For ex:
    public interface Cloneble {
    }
    From Stack overflow:
    In earlier versions of Java, Marker Interfaces were the only way to declare metadata about a class. 
    For example, the Serializable Marker Interface lets the author of a class say that their class will behave correctly when serialized 
    and deserialized.
    In modern Java, marker interfaces have no place. They can be completely replaced by Annotations, which allow for a very flexible metadata 
    capability. If you have information about a class, and that information never changes, then annotations are a very useful way to represent it.

### Does finally always execute?
    Yes except System.exit is called or crash happened in the code

### What functions are in Object class?
    clone(), hashCode(), toString(), equals(), getClass(), finalize(), notify(), notifyAll(), wait(),.....

### Can you override private or static method in the java?
    No, but we can define functions in child class, but all those function will be resolved at compile time, and not run time. 
    Overriding happens at runtime.

### How can you make class immutable
    implement Clone interface
    Final class
    members need to final private
    no setters
    getter returing the clone
    Initialize the class using constructor deep copy

### How to make Singleton class
    public class Singleton {
        private static Singleton obj = null;
        private Singleton() {
        }
        public static Singleton getInstance() {
            if (obj == null) {
                obj = new Singleton();

            return obj;
        }

### Is java pass by value or ref
    Java is pass by value

### Need of Comparable and Comparator interface in Java
    For ex: CustomClass[] customClasses = new CustomClass[10];
            Arrays.sort(customClasses) will fail with an error that implement comparable interface.

            public class CustomClass implements Comparable<CustomClass> {
                int someNumber;
                String someString;

                @override
                int compareTo( CustomClass o) {
                    return o.someNumber - this.someNumber
                }
            }
            
            So comparable interface will enable Arrays.sort(customClasses)
            But if we want to have comparator without making changes to existing class, then use anonymous class.
            
            Comparator<CustomClass> customClassComparator = new Comparator<> {
                public int compare(CustomClass a, CustomClass b) {
                    return a.getSomeString().compare(b.getSomeString());
                }
            }
            Arrays.sort(customClasses, customClassComparator) and it will sort using the param someString, and it will get precedence 
            upon the comparable interface that is implemented by default in the class.

            The functional way will eliminate the use of above interfaces, as .sort can use lamba function:
            Arrays.sort(consumers, (Consumer a, Consumer b) -> {return a.compare(b);})

### == vs .equals
    == just compares value stored by variable
    equals object specific implementation. But default Object class has implementation as: a == b
    int a = 10; int b = 10; a==b as they both hold 10 value
    Object a = new Object(); Object b = new Object(); a !=b , as a and b variables are holding address of object a and object b, which are different.

    IMPORTANT:
    == should ONLY be used with primitives types, and for everything else, use equals

### equals and hashCode contract
    If obj1.equals(obj2) == true, then obj1.hashCode() == obj2.hashCode()
    But reverse is not true, i.e if obj1.hashCode() == obj2.hashCode(), but that DOES NOT imply that obj1.equals(obj2) == true. This is because of hash collisions

    Important to remember that that map.put(key, value) uses key.hashCode() internally when putting a value in bucket, so make sure that equal 
    object get same bucket, so if user implements equals, then it is mandatory to implement hashcode() also.

### String are immutable:
    String a = "1"; String b = "2"; a == b, because both strings point to same memory location. a.equals(b) as both has same value
    They are created in cache pool.
    IMPORTANT:
    String a = "1"; String b = new String("2"); a==b return false, as b is holding memory of new String object and
    String object has been created in the pool. But a.equals(b) is true
    ADV:
    Saves space because they are created in cache pool.
    Threadsafe as the values are readonly
    Kind of adds security as the function cant modify the original string,

### Static method shadowing in child class
    If overidden method in child class is made to be static, then run time polymorphism does not work. Then child function is never called and only the base class implementation will be class. 
    If function in child is not static, then function in child class will be called and will follow polymorphism

### Access modifier for child's overridden function.
    Child overridden function's access modifier is allowed to make it more accessible, and not vice versa.
    For ex: protected in parent can be protected/public in child, but can be made private
            public in parent can ONLY be public in child, and cant be made protected/private

### Association HASA relation
    Weak association is Aggregation. Car HASA driver, But both object can coexit independently.
    Strong association is Composition, Car HASA Engine, and car cannot exist without engine.

### Return type of overridden function in child can be different from parent function.
    The return type of child function can be parent class of the return type of the parent function
    Suppose parent has String parentFunction(), then child class either have String childFunction() or Object childFunction() because object is parent of String

### Exception hierarchy
    Throwable:
        Exception:
            Checked: (Exception that compiler forces you to handle at compile time)
                ClasNotFoundException
                IOException
                SqlException
                FileNotFoundException
            UnChecked: (Exception only known at runtime)
                NullPointerException
                IndexOutOfBoundException
                NumberFormatException
        Error:
            StackOverflowError
            OutOfMemoryError
            VirtualMachineError

### From PODs to String
    String.valueOf(int i), String.valueOf(long)
    Integer.valueOf(String s)

### Deque interface
    Concrete class is ArrayDeque()
    .add && .addlast :: Add at tail
    .addFirst :: Add at head
    .peek && peekFirst:: Returns the head without deleting
    .peekLast:: Returns the head without deleting
    .poll :: Return head and delete the element
    .removeFirst :: Remove head
    .removeLast :: Remove tail

### Sort Array
    Arrays.sort(arr) or 
    Arrays.sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
    
    Sort collections:
        list.sort(Comparator<? super T> c)

### Constructors
    No default constructor when user defines class constructors. If user need default (no arg) constructor, it has to be defined like other constructors.
    Make constructor "Private" if user NEVER wants instance of class.

### Enums
    way to create: public enum DayaofWeek {SUNDAY,MONDAY,TUESDAY....SATURDAY;} watch comma separated and ends with semi colon
    Another when enum intialized with values public enum DayaofWeek {SUNDAY(1),MONDAY(2),TUESDAY(3)....SATURDAY(7); public final int dayOftheWeek;  DayaofWeek(int dayOftheWeek) {this.dayOftheWeek = dayOfTheWeek;}
    All enums are extended from java.lang.enums so you get some extra functions

### Final
    variable:   Once intialized, value of the variable cannot be altered. Ex: public final MyClass class1 = new MyClass(); class1 = new MyClass(); second time will throw an error
    method:     derived class CANNOT override implementation of method of parent class
    class:      class CANNOT be extended

### equals() vs ==
    == literally compares the value stored for the variable: String a = new String("test"); String b = new String("test"); a == b is false as a and b stores address of objects which are differnet
    But String a = "test"; String b = "test" and a == b is true. As a and b has same memory address from string pool
    To compare objects, user ALWAYS need to implement boolean equals(Object obj)

### Garbage Collection
    void func() {
        Person p = new Person(); //p will be out of scope after func stack so it will unreachable memory in heap
    }
    void func2(Person p1) {
        Person p = new Person();
        p = p1; // heap memory earlier referrenced by p will be unreachable
    }
    Garbage collector run sweep and mark the reachable memory. All the unreachable memory objects are returned to heap.
    heap sections are divided in young and old generation heap sections. A new memory always belongs to young generation 
    and mark/sweep happens frequently on this section. After various runs, Garbage colector identifies 
    memories that in young generation for longer duration, and those are then moved to old generation.
    Mark/sweep runs very less on old generation memory.
