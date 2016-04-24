#Java - My cheatsheet

#### Table of Contents  
[OOP concepts](#oop-concepts)  

[Data Structures](#data-structures)

[Access Modifiers](#access-modifiers)

[Comparable v/s Comparator](#comp)


<a name="oop-concepts"/>
#####OOP concepts
|               |              |
| ------------- |:-------------|
| Encapsulation      | Encapsulation is a technique used for hiding the properties and behaviors of an object and allowing outside access only as appropriate. It prevents other objects from directly altering or accessing the properties or methods of the encapsulated object. |
| Abstraction      | Abstraction refers to the act of representing essential features without including the background details or explanations. Showing the functionality but hiding the implementation.      |
| Polymorphism | "one interface, many implementations."      |
|Inheritance|extending the properties of a parent class.|

<a name="data-structures"/>
#####Data Structures
|               |              |
| ------------- |:-------------|
|HashMap|There can only be one null key in HashMap. Buckets stored as linked list. What if  when two different keys have the same hashcode ? If there are more than one object mapped to the same hash value, we traverse through linked list, comparing keys in each entries using keys.equals() until it return true. Then the corresponding entry object Value is returned. In case we have to do a deep comparison of the fields, we override equals method.|
|HashSet|Uses hashmap internally to maintain the uniqueness. Override equals method to do a deep comparison of each of the attributes.|
|Vector|Used when you don’t know what type of objects will be inserted. Initial capacity and increment factor when resized upward.|
|String/StringBuffer/StringBuilder| ![Image of String](http://s31.postimg.org/cywme34wr/string.png)|
|ArrayList v/s LinkedList|![List Implementations](http://s31.postimg.org/xjksltokb/list.png)|
|**Stack**|**Heap**|
|stores temporary variables by each function. On function exit, values are popped out and memory is freed|stores objects created during runtime. When the function exits, reference is lost but the memory is not freed yet. Garbage collector does the work|
|Fast access as stored sequentially.|Slow access because have to follow links.|
|Has size limits. Might cause stackoverflow error when the function goes into infinite recursion.|No size limits, but sometimes might run out of Heapspace if no memory is free to be allocated.|
|Memory automatically managed|Not managed automatically. |


<a name="access-modifiers">
#####Access Modifiers
![Access Modifiers](http://s31.postimg.org/h9hrgg7mj/accessmodi.png)
<a name="comp">
#####Comparable and Comparator
![CompAndComp](http://s31.postimg.org/4ijo41eor/comparableandcomparator.png)

