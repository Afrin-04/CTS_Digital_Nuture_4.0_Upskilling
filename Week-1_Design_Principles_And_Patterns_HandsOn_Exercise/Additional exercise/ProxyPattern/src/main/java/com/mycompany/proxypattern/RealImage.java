
package com.mycompany.proxypattern;

public class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer(); // Simulate time-consuming loading
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image from remote server: " + filename);
        try {
            Thread.sleep(2000); // simulate network delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}
