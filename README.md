# android-shoppingcart
An implementation of android shopping cart library project for Android.

To use this library, follow these steps:

1) Download and include this as library project

2) For any products that you want to add in your shopping cart, create a class for the product that extends Saleable interface and implements these 2 methods:
- getName(): must returm the product name
- getPrice(): must return the product price

and also override equals() and hashCode() methods.

3) Now from anywhere in your application, you can retrieve the shopping cart with 

  Cart cart = CartHelper.getCart();

  After retrieving the shopping cart, the library provides various methods to manipulate the shopping cart like adding, removing, updating products or clear the entire shopping cart. 

For an example on how to use this library, please see
https://github.com/tonyvu2014/android-shoppingcart-demo

