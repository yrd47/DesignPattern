# Abstract Factory Pattern
工厂方法模式通过引入工厂等级结构，解决了简单工厂模式中工厂类职责太重的问题，但由于工厂方法模式中的每个工厂只生产一类产品，可能会导致系统中存在大量的工厂类，可以考虑**将一些相关的产品组成一个“产品族“，由同一个工厂来统一生产**。  

## 产品等级结构与产品族
**产品等级结构**：产品等级结构即产品的继承结构  
**产品族**：在抽象工厂模式中，**产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品**，如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中，海尔电视机、海尔电冰箱构成了一个产品族。  

<image src="images/abstractfactory1.jpeg">  
图中一共有五个产品族，分属于三个不同的产品等级结构。  
当系统所提供的工厂生产的具体产品并不是一个简单的对象，而是位于不同产品等级结构、属于不同类型的具体产品时就可以使用抽象工厂模式。**抽象工厂模式是所有形式的工厂模式中最为抽象和最具一般性的一种形式。**抽象工厂模式与工厂方法模式最大的区别在于，工厂方法模式针对的是一个产品等级结构，而抽象工厂模式需要面对多个产品等级结构，一个工厂等级结构可以负责多个不同产品等级结构中的产品对象的创建。  

<image src="images/abstractfactory2.jpeg">   
图中每一个具体工厂可以生产属于一个产品族的所有产品。  

## 抽象工厂模式概述
**抽象工厂模式(Abstract Factory Pattern)**：提供一个创建一系列相关或相互依赖对象的接口，而无须指定它们具体的类。抽象工厂模式又称为Kit模式，它是一种对象创建型模式。  
在抽象工厂模式中，每一个具体工厂都提供了多个工厂方法用于生产多种不同类型的产品，这些产品构成一个产品族。  

<image src="images/abstractfactory3.jpeg">   
**AbstractFactory(抽象工厂)**：它声明了一组用于创建一组产品的方法，每一个方法对应一种产品。  
**ConcreteFactory(具体工厂)**:它实现了在抽象工厂中声明的创建产品的方法，生成一组具体产品，这些产品构成了一个产品族，每一个产品都位于某个产品等级结构中。  
**AbstractProduct(抽象产品)**:它为每种产品声明接口，在抽象产品中声明了产品所具有的业务方法。  
**ConcreteProduct(具体产品)**:它定义具体工厂生产的具体产品对象，实现抽象产品接口中声明的业务方法。  
在抽象工厂中声明了多个工厂方法，用于创建不同类型的产品，抽象工厂可以是接口，也可以是抽象类或者具体类。

```
abstract class AbstractFactory {
	public abstract AbstractProductA createProductA(); //工厂方法一
	public abstarct AbstractProductB crateProduactB(); //工厂方法二
}
```  
具体工厂实现了抽象工厂，每一个具体的工厂方法可以返回一个特定的产品对象，而同一个具体工厂所创建的产品对象构成一个产品族。  

```
class ConcreteFactory1 extends AbstractFactory {
	//工厂方法一
	public AbstractProductA createProductA(){
		return new ConcreteProductA1();
	}  
	
	//工厂方法二
	public AbstractProductB createProductB(){
		return new ConcreteProductB1();
	}
}
```  
与工厂方法模式一样，抽象工厂模式也可为每一种产品提供一组重载的工厂方法，以不同的方式对产品对象进行创建。  
