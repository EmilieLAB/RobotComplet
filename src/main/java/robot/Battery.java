package robot;

public class Battery {

    public final long CHARGE_TOP = 1000;
    public final long CHARGE_STEP = 10;
    private float chargeLevel;

    public Battery() {
        chargeLevel = 20;
    }

    public void charge() {
        chargeLevel = chargeLevel+CHARGE_STEP;
    }

    public float getChargeLevel(){
        return chargeLevel;
    }

    public void recharger(long secondsOfCharge) throws InterruptedException {
        Thread.sleep(secondsOfCharge*1000);
        chargeLevel+=CHARGE_STEP*secondsOfCharge*1000/CHARGE_TOP;
    }

    public void use(double energy) throws InsufficientChargeException {
        if (chargeLevel < energy) throw new InsufficientChargeException();
        chargeLevel -= energy;
    }

    public boolean canDeliver(double neededEnergy) {
        return (chargeLevel >= neededEnergy);
    }
}
