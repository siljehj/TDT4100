package oving7.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CoffeeCupTest {

    private CoffeeCup cup1, cup2, cup3;

    @BeforeEach
    public void setUp() {
        cup1 = new CoffeeCup();
        cup2 = new CoffeeCup(10.0, 2.5);
        cup3 = new CoffeeCup(13.0, 13.0);
    }

    @Test
    @DisplayName("Test constructor")
    public void testConstructor() {
        assertEquals(0, cup1.getCapacity(), "Capacity was wrong.");
        assertEquals(10, cup2.getCapacity(), "Capacity was wrong.");
        assertEquals(0, cup1.getCurrentVolume(), "Volume was wrong.");
        assertEquals(2.5, cup2.getCurrentVolume(), "Volume was wrong.");
        assertThrows(IllegalArgumentException.class, () -> {
            new CoffeeCup(-10.0, 3.0);
        }, "Negative capacity should have thrown IllegalArugment-exception!");
        assertThrows(IllegalArgumentException.class, () -> {
            new CoffeeCup(10.0, -4.0);
        }, "Negative volume should have thrown IllegalArugment-exception!");
        assertThrows(IllegalArgumentException.class, () -> {
            new CoffeeCup(0.0, 4.0);
        }, "Volume larger than capacity should have thrown IllegalArugment-exception!");
    }

    @Test
    @DisplayName("Test capacity")
    public void testCapacity() {
        cup1.increaseCupSize(2.5);
        cup2.increaseCupSize(2.7);
        assertEquals(2.5, cup1.getCapacity(), "Capacity was wrong.");
        assertEquals(12.7, cup2.getCapacity(), "Capacity was wrong.");
    }

    @Test
    @DisplayName("Test volume")
    public void testVolume() {
        cup1.increaseCupSize(2.5);
        cup2.increaseCupSize(2.7);
        assertEquals(0, cup1.getCurrentVolume(), "Volume was wrong.");
        assertEquals(2.5, cup2.getCurrentVolume(), "Volume was wrong.");
    }

    @Test
    @DisplayName("Test increaseCupSize()")
    public void testIncreaseCupSize() {
        cup1.increaseCupSize(5.5);
        cup2.increaseCupSize(3.4);
        assertEquals(5.5, cup1.getCapacity(), "Capacity was wrong.");
        assertEquals(13.4, cup2.getCapacity(), "Capacity was wrong.");
        assertThrows(IllegalArgumentException.class, () -> {
            cup1.increaseCupSize(-2);
        }, "Negative capacity should have thrown IllegalArugment-exception!");
    }

    @Test
    @DisplayName("Test drinkCoffee")
    public void testDrinkCoffee() {
        cup2.drinkCoffee(2.5);
        cup3.drinkCoffee(5.0);
        assertEquals(0.0, cup2.getCurrentVolume(), "Volume was wrong.");
        assertEquals(8.0, cup3.getCurrentVolume(), "Volume was wrong.");
        assertThrows(IllegalArgumentException.class, () -> {
            cup1.drinkCoffee(2);
        }, "Trying to drink more coffee than available should have thrown IllegalArugment-exception!");
        assertThrows(IllegalArgumentException.class, () -> {
            cup2.drinkCoffee(-3);
        }, "Negative volume should have thrown IllegalArugment-exception!");
    }

    @Test
    @DisplayName("Test fillCoffee")
    public void testFillCoffee() {
        cup2.fillCoffee(5.0);
        assertEquals(7.5, cup2.getCurrentVolume(), "Volume was wrong.");
        cup3.increaseCupSize(7.0);
        assertEquals(20.0, cup3.getCapacity(), "Capacity was wrong.");
        cup3.fillCoffee(5.0);
        assertEquals(18.0, cup3.getCurrentVolume(), "Volume was wrong.");
        assertThrows(IllegalArgumentException.class, () -> {
            cup1.fillCoffee(2);
        }, "Trying to fill more coffee than capacity should have thrown IllegalArugment-exception!");
        assertThrows(IllegalArgumentException.class, () -> {
            cup2.fillCoffee(-3);
        }, "Negative volume should have thrown IllegalArugment-exception!");
        cup1.increaseCupSize(4.0);
        cup1.fillCoffee(4.0);
        assertEquals(4.0, cup1.getCurrentVolume(), "Volume was wrong.");

    }

}