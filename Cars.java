import java.awt.*;

/**
 * A Super class for all types of cars.
 */
public abstract class Cars implements Movable {
    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name
    private Direction direction = Direction.NORTH;

    public Cars(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }
    double speedFactor(){ //fel här om ej funkar
        return 0;
    }

    public void setTurboOn() {
    }
    public void setTurboOff() {
    }

    /**
     *  A method that increments the currentspeed variable of a Cars subclass-object by speedfactor times amount
     */

    private void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        if (currentSpeed > enginePower){
            this.currentSpeed = enginePower;
        }
    }
    /**
     *  A method that decrements the currentspeed variable of a Cars object by speedfactor times amount
     */

    private void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        if (currentSpeed < 0){
            this.currentSpeed = 0;
        }
    }

    public void setCurrentpoint(int x, int y) {
        this.currentpoint.x = x;
        this.currentpoint.y = y;
    }

    public Point getCurrentpoint() {
        return this.currentpoint;
    }

    /**
     * A method that makes our cars move
     */
    public void move() {
        if (direction.equals(Direction.NORTH)){
            currentpoint.move(currentpoint.x, currentpoint.y + ((int) currentSpeed));
        }
        else if (direction.equals(Direction.EAST)){
            currentpoint.move(currentpoint.x + (int) currentSpeed,  currentpoint.y );
        }
        else if (direction.equals(Direction.SOUTH)){
            currentpoint.move(currentpoint.x, currentpoint.y - (int) currentSpeed);
        }
        else if (direction.equals(Direction.WEST)) {
            currentpoint.move(currentpoint.x - (int) currentSpeed, currentpoint.y);
        }
    }

    /**
     * A method that changes the direction of our car to the left
     */
    public void turnLeft() {
        int n = direction.ordinal() -1;
        if (n == -1){
            direction = Direction.values()[Direction.values().length - 1];
        }
        else{
            direction = Direction.values()[n];
        }
    }

    /**
     * A method that changes the direction of our car to the right
     */
    public void turnRight() {
        int n = direction.ordinal() + 1;
        if (n == Direction.values().length){
            direction = Direction.values()[0];
        }
        else{
            direction = Direction.values()[n];
        }
    }

    /**
     * A method that calls incrementSpeed() if amount is between 0 and 1
     */
    public void gas(double amount){
        if (amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }

    }

    /**
     * A method that calls decrementSpeed() if amount is between 0 and 1 by that factor
     */
    public void brake(double amount){
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }


}
