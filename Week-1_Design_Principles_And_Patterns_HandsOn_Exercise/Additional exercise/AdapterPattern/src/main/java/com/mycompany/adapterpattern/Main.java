
package com.mycompany.adapterpattern;

public class Main {
    public static void main(String[] args) {
        // PayPal Adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(1500.00);

        System.out.println();

        // Stripe Adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(2750.00);
    }
}

