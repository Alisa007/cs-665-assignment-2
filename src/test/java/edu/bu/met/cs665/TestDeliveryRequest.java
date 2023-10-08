package edu.bu.met.cs665;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import edu.bu.met.cs665.delivery.DeliveryRequest;
import edu.bu.met.cs665.delivery.Driver;
import edu.bu.met.cs665.delivery.Shop;

public class TestDeliveryRequest {
    @Test
    public void testDeliveryNotification() {
        Shop shop = new Shop();

        Driver driver1 = new Driver("Driver 1");
        Driver driver2 = new Driver("Driver 2");

        shop.registerObserver(driver1);
        shop.registerObserver(driver2);

        DeliveryRequest deliveryRequest = new DeliveryRequest("Book", "123 Street");

        shop.newDeliveryRequest(deliveryRequest);
    }

    @Test
    public void testAllDriversNotified() {
        Shop shop = new Shop();

        Driver driver1 = new Driver("Driver 1");
        Driver driver2 = new Driver("Driver 2");
        Driver driver3 = new Driver("Driver 3");

        shop.registerObserver(driver1);
        shop.registerObserver(driver2);
        shop.registerObserver(driver3);

        DeliveryRequest deliveryRequest = new DeliveryRequest("Laptop", "456 Avenue");

        shop.newDeliveryRequest(deliveryRequest);

        assertEquals(deliveryRequest, driver1.getLastNotification());
        assertEquals(deliveryRequest, driver2.getLastNotification());
        assertEquals(deliveryRequest, driver3.getLastNotification());
    }

    @Test
    public void testRemovingDriver() {
        Shop shop = new Shop();

        Driver driver1 = new Driver("Driver 1");
        Driver driver2 = new Driver("Driver 2");

        shop.registerObserver(driver1);
        shop.registerObserver(driver2);

        shop.removeObserver(driver2);

        DeliveryRequest deliveryRequest = new DeliveryRequest("Phone", "789 Boulevard");

        shop.newDeliveryRequest(deliveryRequest);

        assertEquals(deliveryRequest, driver1.getLastNotification());
        assertNull(driver2.getLastNotification());
    }

    @Test
    public void testNoDrivers() {
        Shop shop = new Shop();

        DeliveryRequest deliveryRequest = new DeliveryRequest("Tablet", "101 Street");

        shop.newDeliveryRequest(deliveryRequest);

        try {
            shop.newDeliveryRequest(new DeliveryRequest("product", "destination"));
        } catch (Exception e) {
            fail("Delivery request creation should not throw an exception: " + e.getMessage());
        }
    }

    @Test
    public void testMultipleNotifications() {
        Shop shop = new Shop();

        Driver driver1 = new Driver("Driver 1");
        shop.registerObserver(driver1);

        DeliveryRequest deliveryRequest1 = new DeliveryRequest("Watch", "202 Avenue");
        DeliveryRequest deliveryRequest2 = new DeliveryRequest("Headphones", "303 Boulevard");

        shop.newDeliveryRequest(deliveryRequest1);
        shop.newDeliveryRequest(deliveryRequest2);

        assertEquals(deliveryRequest2, driver1.getLastNotification());
    }
}