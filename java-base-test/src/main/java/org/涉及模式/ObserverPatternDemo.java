package org.涉及模式;

import java.util.ArrayList;
import java.util.List;

// 主题接口，定义了注册、移除和通知观察者的方法
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// 具体主题类，实现了主题接口
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    public int getState() {
        return state;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// 观察者接口，定义了更新方法
interface Observer {
    void update();
}

// 具体观察者类，实现了观察者接口
class ConcreteObserver implements Observer {
    private int state;
    private ConcreteSubject subject;

    public ConcreteObserver(ConcreteSubject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    public void update() {
        state = subject.getState();
        System.out.println("Observer update, state = " + state);
    }
}

// 测试类
public class ObserverPatternDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer1 = new ConcreteObserver(subject);
        ConcreteObserver observer2 = new ConcreteObserver(subject);

        subject.setState(1);// Observer update, state = 1 Observer update, state = 1
        subject.setState(2); //Observer update, state = 2 Observer update, state = 2

        subject.removeObserver(observer1);

        subject.setState(3);  // Observer update, state = 3
    }
}
