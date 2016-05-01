#Java - My cheatsheet

#### Table of Contents  
1. [OOP concepts](#oop-concepts)
2. [Data Structures](#data-structures)
  - [StringBuffer, StringBuilder and String](#string)
  - [ArrayList v/s LinkedList](#listcomp)
  - [Stack v/s Heap](#stackheap)
  - [HashSet v/s TreeSet](#set)
3. [Access Modifiers](#access-modifiers)
4. [Comparable v/s Comparator](#comp)
5. [Abstract class v/s Interface](#absIn)
6. [final, finally, finalize](#final)
7. [Threads](#thread)

<a name="oop-concepts"/>
####OOP concepts
|               |              |
| ------------- |:-------------|
| Encapsulation      | Encapsulation is a technique used for hiding the properties and behaviors of an object and allowing outside access only as appropriate. It prevents other objects from directly altering or accessing the properties or methods of the encapsulated object. |
| Abstraction      | Abstraction refers to the act of representing essential features without including the background details or explanations. Showing the functionality but hiding the implementation.      |
| Polymorphism | "one interface, many implementations."      |
|Inheritance|extending the properties of a parent class.|

<a name="data-structures"/>
####Data Structures
|               |              |
| ------------- |:-------------|
|HashMap|There can only be one null key in HashMap. Buckets stored as linked list. What if  when two different keys have the same hashcode ? If there are more than one object mapped to the same hash value, we traverse through linked list, comparing keys in each entries using keys.equals() until it return true. Then the corresponding entry object Value is returned. In case we have to do a deep comparison of the fields, we override equals method.|
|HashSet|Uses hashmap internally to maintain the uniqueness. Override equals method to do a deep comparison of each of the attributes.|
|Vector|Used when you don’t know what type of objects will be inserted. Initial capacity and increment factor when resized upward.|
|<a name="string"/>String/StringBuffer/StringBuilder| ![Image of String](http://s31.postimg.org/cywme34wr/string.png)|
|<a name="listcomp"/>ArrayList v/s LinkedList|![List Implementations](http://s31.postimg.org/xjksltokb/list.png)|
|<a name="stackheap"/>**Stack**|**Heap**|
|stores temporary variables by each function. On function exit, values are popped out and memory is freed|stores objects created during runtime. When the function exits, reference is lost but the memory is not freed yet. Garbage collector does the work|
|Fast access as stored sequentially.|Slow access because have to follow links.|
|Has size limits. Might cause stackoverflow error when the function goes into infinite recursion.|No size limits, but sometimes might run out of Heapspace if no memory is free to be allocated.|
|Memory automatically managed|Not managed automatically. |
|<a name="set"/>**Hashset**|**Treeset**|
|Not ordered|Ordered|
|Null value allowed|Null value not allowed|
|Performance - O(1)|Performance- log(n)|
|Implements Hashmap|Implements Treemap|



<a name="access-modifiers"/>
####Access Modifiers
![Access Modifiers](http://s31.postimg.org/h9hrgg7mj/accessmodi.png)
<a name="comp"/>
####Comparable and Comparator
![CompAndComp](http://img.ctrlv.in/img/16/04/24/571c5a979542c.png)

<a name="absIn"/>
####Abstract Class v/s Interface
![Abstract Class v/s Interface](http://s31.postimg.org/5p6yojue3/abstract_Interface.png)

<a name="final"/>
#### final, finally and finalize
**final** - to make an object immutable, to prevent a method from being overridden, to prevent a class from being inherited.
**finally** - always called after try catch
**finalize** - called before freeing the object by garbage collector.


<a name="thread"/>
####Threads
![Thread](http://s31.postimg.org/bvn5qt2u3/thread.png)

References: 

1. http://javahungry.blogspot.com/2013/08/hashing-how-hash-map-works-in-java-or.html
2. http://stackoverflow.com/questions/215497/difference-among-public-default-protected-and-private
3. http://www.java2blog.com/2013/02/difference-between-comparator-and.html

Useful links:

1. http://bigocheatsheet.com/
2. http://www.buggybread.com/2015/01/java-interview-questions-and-answers.html
3. http://www.buggybread.com/2013/09/java-online-practice-tests.html
4. https://sites.google.com/site/steveyegge2/five-essential-phone-screen-questions
