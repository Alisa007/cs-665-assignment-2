/**
 * Name: ALISA BELOUSOVA
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: DeliveryRequest.java
 * Description: The DeliveryRequest class acts as a data carrier within the delivery system, 
 * encapsulating the details of a delivery request, such as the product name and delivery address. 
 * It is intended to be utilized within the Observer design pattern, being passed to Observer 
 * instances (like Driver) by a Subject (like Shop) to notify them of a new delivery request.
 */

package edu.bu.met.cs665.delivery;

public class DeliveryRequest {
  // The name or type of the product to be delivered.
  public final String product;
  
  // The address to which the product is to be delivered.
  public final String address;

  /**
   * Constructs a new DeliveryRequest instance with the specified product and address.
   * 
   * @param product A String indicating the name or type of the product for delivery.
   * @param address A String specifying the address to which the product should be delivered.
   */
  public DeliveryRequest(String product, String address) {
    this.product = product;
    this.address = address;
  }
}