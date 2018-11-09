import static org.junit.jupiter.api.Assertions.*;

class CarsTest {
    Cars c1 = new Volvo240();
    Cars c2 = new Saab95();
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

    }

    @org.junit.jupiter.api.Test
    void setTurboOff() {

    }
}