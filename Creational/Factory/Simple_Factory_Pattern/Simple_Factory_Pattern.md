# Simple Factory Pattern
简单工厂模式 “小弟”	 
工厂方法模式 通常所说的工厂模式	 
抽象工厂模式 “大哥” 
## 创建对象与使用对象--工厂的作用
与对象相关的职责：对象本身所具有的职责、创建对象的职责和使用对象的职责  
java中创建对象的方式：  
1）使用new关键字直接创建对象  
2）通过反射机制创建对象  
3）通过clone()方法创建对象  
4）通过工厂类创建对象  
通过引入工厂类，将对象的创建与对象的使用分开，客户类不涉及对象的创建，对象的创建者也不会涉及对象的使用。  

<image src="images/factory.jpg">  

两个类A和B之间的关系应该仅仅是A创建B或是A使用B，而不能两种关系都有。  
防止用来实例化一个类的数据和代码在多各类中到处都是，可以将有关创建的知识搬移到一个工厂类中。  
可以提供一系列名字完全不同的工厂方法，每一个工厂方法对应一个构造函数。  

<image src="images/factory1.jpg">

## 简单工厂模式概述
***简单工厂模式(Simple Factory Pattern)***：定义一个工厂类，它可以根据参数的不同返回不同类的实例，被创建的实例通常都具有共同的父类。因为在简单工厂模式中用于创建实例的方法是静态方法，因此简单工厂模式又被称为静态工厂方法模式，它属于创建型模式。  
当你需要什么，只需要传入一个正确的参数，就可以获取你所需要的对象，而无需知道其创建细节。
  
<image src="images/simpleFactory.jpeg">

**Factory(工厂角色)**：工厂类，它是简单工厂模式的核心，负责创建所有产品实例的内部逻辑；工厂类可以被外界直接调用，创建所需的产品对象；在工厂类中提供了静态的工厂方法factoryMethod()，它的返回类型为抽象产品类型Product。  
**Product（抽象产品角色**：它是工厂类所创建的所有对象的父类，封装了各种产品对象的共有方法，它的引入将提高系统的灵活性，使得在工厂类中只需要定义一个通用的工厂方法，因为所有参加的具体产品对象都是其子类对象。  
**ConcreteProduct(具体产品角色)**：它是简单工厂模式的创建目标，所有被创建的对象都充当这个角色的某个具体类的实例。每一个具体产品角色都继承了抽象产品角色，需要实现在抽象产品中声明的查询方法。  
在简单工厂模式中，客户端通过工厂类来创建一个产品类的实例，而无需直接使用new关键字来创建对象，它是工厂模式家族中最简单的一员。  
### 方案的改进
若需要修改客户端代码中静态工厂方法的参数，需要修改代码并重新编译，因此可以将静态工厂方法的参数存储在XML或properties格式的配置文件中。  
有时候，为了简化简单工厂模式，可以将抽象产品类和工厂类合并，将静态工厂方法移至抽象产品类中

<image src="images/simplefactory2.jpeg">  
客户端可以通过产品分类的静态工厂方法，根据参数不同创建不同类型的产品子类对象。  
## 简单工厂模式总结
主要优点：
1. 工厂类包含必要的判断逻辑，可以决定在什么时候创建哪一种产品类的实例，客户端可以免除直接创建产品对象的职责，而仅仅“消费”产品，简单工厂模式实现了对象创建和使用的分离  
2. 客户端无须知道所创建的具体产品类的类名，只需要知道具体产品类所对应的参数即可，对于一些复杂的类名，可以减少记忆量  
3. 通过引入配置文件，可以在不修改客户端代码的的情况下更换和增加新的具体产品类，在一定程度上提高了系统的灵活性

主要缺点：
1. 由于工厂类集中了所有产品的创建逻辑，职责过重，一旦不能正常工作，整个系统都受影响  
2. 使用简单工厂模式势必会增加系统中类的个数  
3. 系统扩展困难，一旦增加新产品就不得不修改工厂逻辑，在产品类型过多时，有可能造成工厂逻辑过于复杂，不利于系统的扩展和维护  
4. 简单工厂模式由于使用了静态工厂方法，造成工厂角色无法形成基于继承的登记结构  

适用场景：
1. 工厂类负责创建的对象较少
2. 客户端只知道传入工厂类的参数，对于如何创建对象并不关心