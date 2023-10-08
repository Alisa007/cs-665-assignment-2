/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: Shop.java
 * Description: This class represents a Shop in the delivery system. The Shop is responsible for 
 * managing delivery requests and notifying observers (i.e., drivers) of new requests. 
 * The Shop class implements the Subject interface from the Observer design pattern, making sure
 * that any observers are notified when the internal state of a Shop object changes in a way 
 * that those observers might care about.
 */

package edu.bu.met.cs665.delivery;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Subject {
  // Maintains a list of observers that are interested in updates from this Shop.
  private final List<Observer> observers;
  
  /**
   * Constructor initializing the observers list.
   */
  public Shop() {
    this.observers = new ArrayList<>();
  }

  /**
   * Registers an observer, adding it to the list of observers that should be 
   * notified of changes to this shop's state.
   *
   * @param observer The observer to be added.
   */
  @Override
  public void registerObserver(Observer observer) {
    observers.add(observer);
  }

  /**
   * Removes an observer, ensuring it will no longer be notified of changes 
   * to this shop's state.
   *
   * @param observer The observer to be removed.
   */
  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  /**
   * Notifies all registered observers of a new delivery request.
   *
   * @param deliveryRequest The delivery request observers should be notified about.
   */
  @Override
  public void notifyObservers(DeliveryRequest deliveryRequest) {
    for (Observer observer : observers) {
      observer.update(deliveryRequest);        
    }
  }

  /**
   * Creates a new delivery request and notifies all observers of the new request.
   *
   * @param deliveryRequest The new delivery request to be processed.
   */
  public void newDeliveryRequest(DeliveryRequest deliveryRequest) {
    notifyObservers(deliveryRequest);
  }
}