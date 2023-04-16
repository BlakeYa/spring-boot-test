package com.example;

interface Target {
  void request();
}

class Adaptee {
  void specificRequest() {
    System.out.println("Adaptee: specific request");
  }
}

class Adapter implements Target {
  private Adaptee adaptee = new Adaptee();

  public void request() {
    adaptee.specificRequest();
  }
}

public class AdapterClient {
  public static void main(String[] args) {
    Target target = new Adapter();
    target.request();
  }
}
