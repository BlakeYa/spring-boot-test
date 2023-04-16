package org.涉及模式;

// 抽象迭代器接口
interface Iterator {
    boolean hasNext(); // 是否还有下一个元素
    Object next(); // 返回下一个元素
}

// 具体迭代器类
class ConcreteIterator implements Iterator {
    private Object[] items; // 迭代的数组
    private int position; // 迭代器的当前位置

    public ConcreteIterator(Object[] items) {
        this.items = items;
        position = 0;
    }

    public boolean hasNext() {
        return position < items.length;
    }

    public Object next() {
        Object item = items[position];
        position++;
        return item;
    }
}

// 抽象聚合对象接口
interface Aggregate {
    Iterator createIterator(); // 创建迭代器
}

// 具体聚合对象类
class ConcreteAggregate implements Aggregate {
    private Object[] items; // 聚合对象的内部数组

    public ConcreteAggregate(Object[] items) {
        this.items = items;
    }

    public Iterator createIterator() {
        return new ConcreteIterator(items); // 创建具体迭代器对象
    }
}

// 测试类
public class IteratorPatternDemo {
    public static void main(String[] args) {
        Object[] items = {"A", "B", "C", "D"}; // 聚合对象的内部数组
        Aggregate aggregate = new ConcreteAggregate(items); // 创建具体聚合对象
        Iterator iterator = aggregate.createIterator(); // 创建具体迭代器对象
        while (iterator.hasNext()) { // 遍历聚合对象中的元素
            Object item = iterator.next();
            System.out.println(item);
        }
    }
}
