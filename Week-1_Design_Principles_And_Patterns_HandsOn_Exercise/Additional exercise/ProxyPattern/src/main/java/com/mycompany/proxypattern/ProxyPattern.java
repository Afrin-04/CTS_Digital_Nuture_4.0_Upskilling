/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proxypattern;

/**
 *
 * @author KING FAZIL
 */
public class ProxyPattern { 
    public static void main(String[] args) {
        Image img1 = new ProxyImage("nature.jpg");
        Image img2 = new ProxyImage("cityscape.png");

        // First load: will load from remote
        img1.display();
        System.out.println();

        // Second load: will use cache
        img1.display();
        System.out.println();

        // Load another image
        img2.display();
        System.out.println();

        // Reuse cached second image
        img2.display();
    }
}
