package com.fintech.lite.patterns;

import java.util.Map;
import java.util.function.Supplier;

/** 51. Singleton Holder Pattern */
class Singleton {
    private Singleton() {}
    private static class Holder {
        static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstance() { return Holder.INSTANCE; }
}

/** 57. Factory Pattern with Modern Switch */
interface Shape { void draw(); }
class Circle implements Shape { public void draw() { System.out.println("Circle"); } }
class Square implements Shape { public void draw() { System.out.println("Square"); } }

class ShapeFactory {
    private static final Map<String, Supplier<Shape>> SHAPES = Map.of(
        "CIRCLE", Circle::new,
        "SQUARE", Square::new
    );
    public static Shape create(String type) {
        return SHAPES.getOrDefault(type.toUpperCase(), () -> {
            throw new IllegalArgumentException("Unknown type");
        }).get();
    }
}

/** 58. Builder Pattern using Record and Inner Builder */
record Computer(String cpu, int ram, String gpu) {
    public static class Builder {
        private String cpu;
        private int ram;
        private String gpu;
        public Builder cpu(String cpu) { this.cpu = cpu; return this; }
        public Builder ram(int ram) { this.ram = ram; return this; }
        public Builder gpu(String gpu) { this.gpu = gpu; return this; }
        public Computer build() { return new Computer(cpu, ram, gpu); }
    }
}

public class PatternDemo {
    public static void run() {
        Singleton s = Singleton.getInstance();
        ShapeFactory.create("CIRCLE").draw();
        Computer pc = new Computer.Builder().cpu("i9").ram(64).build();
    }
}
