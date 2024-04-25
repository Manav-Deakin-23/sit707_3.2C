package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {
	
	@Test
    public void testValidDate() {
        // Test a valid date
        DateUtil date = new DateUtil(15, 6, 2021);
        System.out.println("Valid Date- "+date);
        Assert.assertEquals(15, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2021, date.getYear());
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDay() {
        // Test an invalid day (32)
        new DateUtil(32, 6, 2021);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidMonth() {
        // Test an invalid month (13)
        new DateUtil(15, 13, 2021);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidYear() {
        // Test an invalid year (1699)
        new DateUtil(15, 6, 1699);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidDayForMonth() {
        // Test an invalid day for the given month (31 for April)
        new DateUtil(31, 4, 2021);
    }

    @Test
    public void testBoundaryConditions() {
        // Test minimum day, month, and year
        DateUtil dateMin = new DateUtil(1, 1, 1700);
        System.out.println("Min Range- "+dateMin);
        Assert.assertEquals(1, dateMin.getDay());
        Assert.assertEquals(1, dateMin.getMonth());
        Assert.assertEquals(1700, dateMin.getYear());

        // Test maximum day, month, and year
        DateUtil dateMax = new DateUtil(31, 12, 2024);
        System.out.println("Max Range- "+dateMax);
        Assert.assertEquals(31, dateMax.getDay());
        Assert.assertEquals(12, dateMax.getMonth());
        Assert.assertEquals(2024, dateMax.getYear());
    }

    @Test
    public void testIncrement() {
        // Test incrementing one day
        DateUtil date = new DateUtil(31, 12, 2023);
        date.increment();
        System.out.println("Increment- "+date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testDecrement() {
        // Test decrementing one day
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        System.out.println("Decrement- "+date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

}