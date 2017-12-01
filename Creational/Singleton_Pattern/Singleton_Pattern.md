# Singleton Pattern
需要确保系统中某个类只有一个唯一实例，当这个唯一实例创建成功之后，我们无法再创建一个同类型的其他对象，所有操作都只能基于这个唯一的实例。为了确保对象的唯一性，我们可以通过单例模式来实现。  
## 单例模式概述
模拟实现Windows任务管理器，假设任务管理器的类名为TaskManager，在TaskManager类中包含了大量的成员方法，例如构造函数TaskManager()，displayProcesses()等  
  
```
class TaskManage {
	public TaskManager() {...} //初始化窗口
	public void displayProcesses() {...} //显示进程
}
```  
为了实现Windows任务管理器的唯一性，通过以下三步对该类进行重构：  
1. 由于每次使用new关键字来实例化TaskManager类时都将产生一个新对象，为了确保TaskManager实例的唯一性，需要禁止类的外部直接使用new来创建对象，将TaskManager的构造函数的可见性改为private：  
```private TaskManager() {...}```  
2. 类的外部无法再使用new来创建对象，但是在类内部还是可以创建的。我们在TaskManager中创建对象并保存这个实例。为了让外界可以访问这个唯一实例，需要在TaskManager中定义一个静态的TaskManager类型的私有成员变量。  
```private static TaskManager tm = null;```  
3. 增加一个公有的静态方法 
 
```
public static TaskManager getInstance() {
	if (tm == null) {
		tm = new TaskManager();
	}
	return tm;
}
```  
***单例模式(Singleton Pattern)***: 确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法。单例模式是一种对象创建型模式。  
在单例类的内部实现只生成一个实例，同时提供一个静态的getInstance()工厂方法，让客户可以访问它的唯一实例；为了防止在外部对其实例化，将其构造函数私有化；在单例类内部定义一个Singleton类型的静态对象，作为外部共享的唯一实例。  
## 饿汉式单例与懒汉式单例
当第一次调用getInstance()方法创建对象时，instance对象为null值，因此调用new方法，在此过程中需要进行大量初始化操作，需要一段时间来创建对象。而在此时，若再一次调用getInstance()方法（通常在多线程环境中），由于instance尚未创建成功，仍为null值，将再次调用new方法，导致最终创建了多个instance对象。  
1. 饿汉式单例类

```
class EagerSingleton {
	private static final EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() {}
	public static EagerSingleton getInstance() {
		return instance;
	}
}
```  
当类被加载时，静态变量instance会被初始化，此时类的私有构造函数会被调用，单例类的唯一实例将被创建。若使用饿汉式单例，不会出现创建多个单例对象的情况，可确保单例对象的唯一性。  
2. 懒汉式单例类与线程锁定

```
class LazySingleton {
	private static LazySinglrton instance = null;
	private LazySingleton() {}
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
```  
懒汉式在第一次调用getInstance()方法时实例化，在类加载时并不自行实例化(延迟加载 Lazy Load)，即需要的时候再加载实例。为了避免多个线程同时调用getInstance()方法，使用synchronized  
以上的设计每次调用getInstance()时都需要进行线程锁定判断，在多线程高并发环境中，将会导致系统性能大大降低。事实上，无须对整个getInstance()方法进行锁定，只需要对其中的"instance = new LazySingleton()"进行锁定即可

```
	public static LazySingleton getInstance() {
		if (instance == null ) {
			synchronized (LazySingleton.class) {
				instance = new LazySingleton();
			}
		}
		return instance;
	}
```
此时问题并没有解决，加入某一瞬间线程A和线程B都在调用getInstance()方法，此时instance值为null，均可以通过判断进入new方法。由于实现了synchronized加锁机制，线程A进入锁定的代码中执行实例创建代码，线程B处于排队等待状态，必须等线程A执行完毕后才可以进入synchronized锁定代码。但当A执行完毕时，线程B并不知道实例已经创建，将继续创建新的实例，导致产生多个单例对象。因此需要进一步改进：在synchronized中再进行一次(instance == null)判断，这种方式称为***双重检查锁定(Double-Check-Locking)***

```
class LazySingleton {
	private volatile static LazySingleton instance = null;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		//第一重判断
		if (instance == null) {
			synchronized (LazySingleton.class) {
				//第二重判断
				if (instance == null) {
					instance = new LazySingleton(); 
				}
			}
		}
		return instance;
	}
}
```  
若使用双重检查锁定来实现懒汉式单例类，需要再静态成员变量instance前增加修饰符***volatile***,被volatile修饰的成员变量可以确保多个线程都能够正确处理。  
3. 饿汉式单例类与懒汉式单例类比较  
饿汉式单例类在类被加载时就实例化，优点在于无须考虑多线程访问问题，可以确保实例的唯一性；从调用速度和反应时间角度，优于懒汉式单例。但是无论系统在运行时是否需要使用该单例对象，优于在类加载时该对象就需要创建，从资源利用效率角度不及懒汉式，而且系统加载时间可能会比较长。  
懒汉式单例类在第一次使用时创建，无须一致占用系统资源，实现了延迟加载，但是必须处理好多个线程同时访问的问题，需要通过双重检查锁定等机制进行控制，这将导致系统性能受到一定影响。  
## IoDH
Initialization Demand Holder  
在单例类中增加一个静态内部类，在该内部类中创建单例对象，再将该单例对象通过getInstance()方法返回给外部使用。  

```
class Singleton {
	private Singleton() {}
	
	private static class HolderClass() {
		private final static Singleton instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return HolderClass.instance;
	}
}
```
由于静态单例对象没有作为Singleton的成员变量直接实例化，因此类加载时不会实例化Singleton,第一次调用getInstance()时将加载内部类HolderClass，在该内部类中定义了一个static类型的变量instance，此时会先初始化这个成员变量，由java虚拟机来保证其线程安全性，确保该成员变量只能初始化一次。由于getInstance()方法没有任何线程锁定，因此其性能不会有影响。  
通过使用IoDH，既可以实现延迟加载，又可保证线程安全，不影响性能。（缺点是与编程语言本身特性相关，很多面向对象语言不支持）  
**练习**：使用三种方法实现单例类
## 单例模式总结
1. 主要优点  
1）单例模式提供了对唯一实例的受控访问。因为单例类封装了它的唯一实例，它可以严格控制客户怎样及何时访问它。  
2）由于系统内存中只存在一个对象，因此可以节省系统资源。  
3）允许可变数目的实例。基于单例模式我们可以进行拓展，使用与单例控制相似的方法来获得指定数目的对象实例，既节省系统资源，又解决了单例单例对象共享过多有损性能的问题。  
2. 主要缺点  
1）由于单例类没有抽象层，扩展有很大的困难  
2）单例类的职责过重，一定程度违反了“单一职责原则”  
3）现在很多面向对象语言的运行环境提供自动垃圾回收机制，如果实例化的共享对象长时间不使用，会自动销毁并回收资源，下次利用时又将重新实例化，这将导致共享的单例对象状态的丢失。  
3. 适用场景  
1）系统只需要一个实例对象，如系统要求提供一个唯一的序列号生成器或资源管理器，或者需要考虑资源消耗太大而只允许创建一个对象。  
2）客户调用类的单个实例只允许使用一个公共访问点。
**扩展**：如何实现多例类
