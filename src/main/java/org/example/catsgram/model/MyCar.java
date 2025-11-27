package org.example.catsgram.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyCar {
    private final Engine engine;
    private final SeatHeater seatHeater;
    private final Glass glass;

    // указываем, что одна из зависимостей необязательна
    @Autowired // добавляем зависимости через конструктор
    public MyCar(Engine engine,
                 @Autowired(required = false) SeatHeater seatHeater,
                 @Autowired(required = false) Glass glass) {
        this.engine = engine;
        this.seatHeater = seatHeater;
        this.glass = glass;
    }

    public void start() {
        engine.start();
        if (seatHeater != null) {
            seatHeater.start();
        }
        if(glass!=null){

        }
    }
}
@Component
class SeatHeater {
    private int temp=0;
    public void start(){
        System.out.println("seatheat started");
    }
}
@Component
class Engine {
    public void start(){
        System.out.println("engine started");
    }
}
@Component
class Glass {
    private int heightOfGlass;

}