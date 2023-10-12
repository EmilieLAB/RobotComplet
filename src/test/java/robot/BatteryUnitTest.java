package robot;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class BatteryUnitTest {


    @Test
    public void testNiveauChargeInitial() {
        //---DEFINE---
        Battery battery = new Battery();
        //---WHEN-THEN--
        Assert.assertEquals(20, battery.getChargeLevel(), 0);
    }

    @Ignore
    @Test
    public void testCharge() {
        //---DEFINE---
        Battery cell = new Battery();
        Assert.assertEquals(100, cell.getChargeLevel(),0);
        //---WHEN---
        cell.charge();
        //---THEN---
        Assert.assertEquals(110, cell.getChargeLevel(), 0);
    }

    // tester l'apparition d'une exception, l'annotation @Test intègre expected
    // suivi de la classe de l'exception attendue
    // Attention : il est parfois nécessaire de s'assurer que l'exception
    // n'apparaît pas avant la dernière instruction du test
    @Test (expected = InsufficientChargeException.class)
    public void testUseWithInsufficientCharge() throws Exception {
        //---DEFINE---
        Battery cell = new Battery();
        //---WHEN---
        cell.use(125f);
    }

    @Test
    public void testUse() throws InsufficientChargeException {
        //---DEFINE---
        Battery cell = new Battery();
        //---WHEN---
        cell.use(10f);
        //---THEN---
        Assert.assertEquals(10f, cell.getChargeLevel(),0);
    }

    @Test
    public void testUseMax() throws InsufficientChargeException {
        //---DEFINE---
        Battery cell = new Battery();
        //---WHEN---
        cell.use(cell.getChargeLevel());
        //---THEN---
        Assert.assertEquals(0f, cell.getChargeLevel(),0);
    }

    @Test
    public void testCanDeliverPositive() {
        //---DEFINE---
        Battery battery = new Battery();
        //---WHEN-THEN--
        Assert.assertTrue(battery.canDeliver(15));
    }

    @Test
    public void testCanDeliverNegative() {
        //---DEFINE---
        Battery battery = new Battery();
        float currentChargeLevel = battery.getChargeLevel();
        //---WHEN-THEN--
        Assert.assertFalse(battery.canDeliver(currentChargeLevel+1));
    }

    @Test
    public void testRecharger() throws InterruptedException {
        //---DEFINE---
        Battery battery = new Battery();
        float initialChargeLevel = battery.getChargeLevel();
        //---WHEN---
        battery.recharger(20);
        //---THEN---
        Assert.assertEquals(initialChargeLevel+200, battery.getChargeLevel(),0);

    }
}
