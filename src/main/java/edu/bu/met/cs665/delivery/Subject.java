/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: Subject.java
 * Description: This interface defines the Subject in the Observer design pattern 
 * utilized for a delivery system. The interface defines the core methods to manage (add, 
 * remove) observers and to notify them about state changes. Implementing classes will 
 * provide concrete implementations of these methods to manage their observers, typically 
 * involving adding them to, or removing them from, a data structure that tracks them. 
 * The notifying method will generally loop through all registered observers and 
 * call their update() method, providing the new state change (a DeliveryRequest in 
 * this scenario) as an argument.
 */

package edu.bu.met.cs665.delivery;

public interface Subject {
  /**
   * Registers an observer to be notified of state changes in the subject.
   *
   * @param observer The observer to be added to the subject’s collection of registered observers.
   */
  void registerObserver(Observer observer);

  /**
   * Removes an observer so that it no longer receives updates on state changes in the subject.
   *
   * @param observer The observer to be removed from the subject’s collection of observers.
   */
  void removeObserver(Observer observer);
  
  /**
   * Notifies all registered observers of a state change. In the context of the delivery system, 
   * this will typically involve creating a new delivery request and then looping through all 
   * registered observers and calling their update() method, providing the new delivery request 
   * as an argument.
   *
   * @param deliveryRequest The new delivery request that observers should be informed about.
   */
  void notifyObservers(DeliveryRequest deliveryRequest);
}
