import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    private final Cars c1 = new Volvo240();
    private final Cars c2 = new Saab95();
    @org.junit.jupiter.api.Test
    void startEngine() {
        c1.startEngine();
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        c1.startEngine();
        c1.gas(1);
        c1.stopEngine();
        assertTrue(c1.getCurrentSpeed() == 0);
    }

    @org.junit.jupiter.api.Test
    void move() {
        assertTrue(c1.getDirection() == Movable.Direction.NORTH);
        assertTrue(c1.getCurrentpoint().equals(new Point(0,0)));
        c1.startEngine();
        c1.move();
        assertTrue(c1.getCurrentpoint().y == 1); //Point is not updating properly for object


    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        assertTrue(c1.getDirection() == Movable.Direction.NORTH);
        c1.turnLeft();
        assertTrue(c1.getDirection() == Movable.Direction.WEST);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        assertTrue(c1.getDirection() == Movable.Direction.NORTH);
        c1.turnRight();
        c1.turnRight();
        c1.turnRight();
        c1.turnRight();
        assertTrue(c1.getDirection() == Movable.Direction.NORTH);
    }

    @org.junit.jupiter.api.Test
    void gas() {
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
        c1.gas(1);
        assertTrue(c1.getCurrentSpeed() == 1.35);
        c1.gas(2);
        assertTrue(c1.getCurrentSpeed() == 1.35);
        while (c1.getCurrentSpeed() < c1.getEnginePower()){
            c1.gas(1);
        }
        assertTrue(c1.getCurrentSpeed() == c1.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void brake() {
        c1.startEngine();
        assertTrue(c1.getCurrentSpeed() == 0.1);
        c1.brake(2);
        assertTrue(c1.getCurrentSpeed() == 0.1);
        c1.brake(1);
        assertTrue(c1.getCurrentSpeed() == 0);
    }
    @org.junit.jupiter.api.Test
    void setTurboOn() {
        c2.startEngine();
        assertTrue(c2.getCurrentSpeed() == 0.1);
        c2.setTurboOn();
        c2.gas(1);
        assertTrue(c2.getCurrentSpeed() == 1.725 );
    }

    @org.junit.jupiter.api.Test
    void setTurboOff() {
        c2.startEngine();
        assertTrue(c2.getCurrentSpeed() == 0.1);
        c2.setTurboOn();
        c2.setTurboOff();
        assertTrue(c2.speedFactor() == 1.25);

    }
}