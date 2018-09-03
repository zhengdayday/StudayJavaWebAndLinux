## Java容器
* Collection存储对象的集合
* Map存储着键值对的映射表
* Collection
    * Set
        * SortSet
            * TreeSet: 基于红黑树实现，支持有序操作
        * HashSet: 基于哈希表实现，支持快速查找
        * LinkedHashSet   具有HashSet查找的效率，且内部使用双向链表维护元素的插入顺序
    * List
        * ArrayList 
        * Vector 线程安全
        * LinkedList 基于双向链表实现，只能顺序访问
    * Queue
        * LinkedList 双向队列
        * PriorityQueue 基于堆结构实现，可以实现优先队列
* Map
    * SortMap
        * TreeMap 红黑树
    * HashTable 线程安全
    * LinkedHashMap 双向链表维护元素顺序
    * HashMap            
## 容器中的设计模式
* Collection 实现了Iterable接口，其中的iterator()方法可以产生一个Iterator对象，遍历Collection中的元素
* 适配器模式
    * asList()可以把数组类型转换为List类型
    * 不能使用基本类型作为参数
* Vector扩容是2倍，ArrayList扩容是1.5倍
* 可以使用Collections.synchronizedList()得到一个线程安全的ArrayList
* CopyOnwriterArrayList<>()    在写操作的同时允许读操作，大大提高了读操作的性能，因此很适合读多写少的应用场景。  
* ConcurrentHashMap
    * 采用分段锁，每个分段维护几个桶(HashEntry)，多个线程可以同时 访问不同分段锁上的桶