/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: Driver.java
 * Description: This class, Driver, is an implementation of the Observer interface, 
 * which forms a part of the Observer design pattern used within a delivery system. 
 * Driver objects, when registered with a Subject, are notified of new DeliveryRequest 
 * instances, updating their state and producing a console output regarding the new delivery 
 * request. The Driver class maintains the state of the last notification received to 
 * potentially allow for additional functionality (such as querying or displaying 
 * the last delivery request).
 */

package edu.bu.met.cs665.delivery;

public class Driver implements Observer {
  // The driver’s name. Used for identification and console output.
  private final String name;

  // The last delivery request notification received by this driver.
  private DeliveryRequest lastNotification;

  /**
   * Constructs a new Driver object with the provided name.
   *
   * @param name A String representing the name of the driver.
   */
  public Driver(String name) {
    this.name = name;
  }

  /**
   * Updates the driver’s state in response to a new delivery request, logging the new 
   * request to the console. This method, derived from the Observer interface, 
   * is typically called by a Subject instance to notify the observer of a new state.
   *
   * @param deliveryRequest A DeliveryRequest instance containing the details of the new delivery request.
   */
  @Override
  public void update(DeliveryRequest deliveryRequest) {
    this.lastNotification = deliveryRequest;
    System.out.println(name + " received a delivery request for " 
        + deliveryRequest.product + " to be delivered to " 
        + deliveryRequest.address);
  }

  /**
   * Retrieves the last delivery request notification received by this driver.
   *
   * @return A DeliveryRequest instance, which was the last to be received by this driver.
   */
  public DeliveryRequest getLastNotification() {
    return lastNotification;
  }
}