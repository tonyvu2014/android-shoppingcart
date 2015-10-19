# android-shoppingcart

An implementation of android shopping cart library project for Android.

To use this library, follow these steps:

Download and include `library` in your dependencies

    dependencies {
        // ...
        compile project(path: ':library')
    }

For any product that you want to add in your shopping cart, create a class that extends the
`Saleable` interface and implements these 2 methods:

    getName() // must return the product name
    getPrice() // must return the product price

Also override `equals()` and `hashCode()` methods.

Now from anywhere in your application, you can retrieve the shopping cart with

    Cart cart = CartHelper.getCart();

After retrieving the shopping cart, the library provides various methods to manipulate the shopping
cart like adding, removing, updating products or clear the entire shopping cart.

For an example on how to use this library, please see the `demo` app module.
