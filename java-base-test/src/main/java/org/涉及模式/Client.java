package org.涉及模式;

// 定义一个原型接口
interface Prototype {
    public Prototype clone();  // 克隆方法
}

// 实现一个具体的原型类
class ConcretePrototype implements Prototype {
    private String name;  // 对象名称

    public ConcretePrototype(String name) {
        this.name = name;
    }

    // 实现克隆方法
    public Prototype clone() {
        return new ConcretePrototype(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 客户端代码
public class Client {
    public static void main(String[] args) {
        ConcretePrototype prototype = new ConcretePrototype("Prototype 1");  // 创建原型对象
        ConcretePrototype clone1 = (ConcretePrototype) prototype.clone();  // 克隆原型对象
        System.out.println("Clone 1 name: " + clone1.getName());  // 输出克隆对象的名称

        ConcretePrototype clone2 = (ConcretePrototype) prototype.clone();  // 再次克隆原型对象
        clone2.setName("Prototype 2");  // 修改克隆对象的名称
        System.out.println("Clone 2 name: " + clone2.getName());  // 输出克隆对象的名称

        System.out.println(prototype.equals(clone1));  //false
        System.out.println(clone1.equals(clone2));  //false
    }
}
