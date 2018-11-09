import java.awt.*;

/**
 * Car model, subclass to Cars
 */

public class Saab95 extends Cars{
    private boolean turboOn;

    public Saab95() {
        super(2, 125, 0, Color.red, "Saab95");
        this.turboOn = false;
    }
    public void setTurboOn(){
        turboOn = true;
    }
    public void setTurboOff(){
        turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

}