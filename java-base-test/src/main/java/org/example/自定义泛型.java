package org.example;

public class 自定义泛型<T> {
    private T data;

    public 自定义泛型(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        自定义泛型<String> helloBoy = new 自定义泛型<>("hello boy");
        System.out.println(helloBoy.getData());
    }
}
