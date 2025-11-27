package org.example.catsgram.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component // аннотация указывает, что класс нужно добавить в контекст
public class A {
    private final B b;
    @Autowired // сообщаем Spring, что нужно передать в конструктор объект класса B
    public A(B b) {
        this.b = b;
    }
    public void printName() {
        System.out.println("Это A!");
        b.printName();
    }
}
@Component // указываем, что B также нужно добавить в контекст
class B {
    public void printName() {
        System.out.println("Это Б!");
    }
}