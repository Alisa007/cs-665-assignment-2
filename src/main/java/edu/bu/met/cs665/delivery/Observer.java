/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: Observer.java
 * Description: This interface defines the Observer in the Observer design pattern 
 * applied to a delivery system. Classes that implement this interface are required 
 * to define how they update themselves (react) when the state of the Subject 
 * (in this case, the Shop) changes. The updating is triggered via the update() method 
 * when the Subject notifies its observers of a state change. In the context of the 
 * delivery system, this typically involves being notified of a new delivery request.
 */

package edu.bu.met.cs665.delivery;

public interface Observer {
  /**
   * Updates the observer based on a change in the state of the subject it is observing. 
   * In the context of the delivery system, this involves reacting to a new delivery request.
   *
   * @param deliveryRequest The new delivery request that observers should be informed about.
   */
  void update(DeliveryRequest deliveryRequest);
}