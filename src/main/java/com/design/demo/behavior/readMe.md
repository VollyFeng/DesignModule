[TOC]
# 行为型设计模式

23种设计模式分为三类: 创建型, 结构型, 行为型. 创建型设计模式解决"对象的创建"问题；结构型设计模式解决"类或对象的组合和组装问题"；行为型设计模式解决"类或对象间的交互问题".

行为型设计,模式有11种 , 它们分别是: 观察者模式、策略模式、责任连模式、迭代器模式、模板模式、状态模式、访问者模式、备忘录模式、命令模式、解释器模式、中介模式。

## 观察者模式

观察者模式又称为**发布订阅模式**

* 定义

在对象之间定义一个一对多的依赖, 当一个对象发生改变的时候, 所有依赖的对象都会自动收到通知. 一般情况下, 被依赖的对象称为**被观察者(Observable)**, 依赖的对象被称为**观察者(Observer)**.

* 模板代码

````
public interface Subject {
  void registerObserver(Observer observer);
  void removeObserver(Observer observer);
  void notifyObservers(Message message);
}

public interface Observer {
  void update(Message message);
}

public class ConcreteSubject implements Subject {
  private List<Observer> observers = new ArrayList<Observer>();

  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(Message message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

}

public class ConcreteObserverOne implements Observer {
  @Override
  public void update(Message message) {
    //TODO: 获取消息通知，执行自己的逻辑...
    System.out.println("ConcreteObserverOne is notified.");
  }
}

public class ConcreteObserverTwo implements Observer {
  @Override
  public void update(Message message) {
    //TODO: 获取消息通知，执行自己的逻辑...
    System.out.println("ConcreteObserverTwo is notified.");
  }
}

public class Demo {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();
    subject.registerObserver(new ConcreteObserverOne());
    subject.registerObserver(new ConcreteObserverTwo());
    subject.notifyObservers(new Message());
  }
}
````

* 实现方式

同一进程

1. 同步阻塞 : 实现代码解耦
2. 异步非阻塞 (EventBus) : 在实现代码解耦的同时,使用线程池提高代码的运行效率

跨进程

1. 消息队列 : 实现进程间的被观察者和观察者的交互