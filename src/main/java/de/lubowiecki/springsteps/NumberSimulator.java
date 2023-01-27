package de.lubowiecki.springsteps;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberSimulator {

    private Random rand = new Random();

    /**
     * Generiert eine Ganzzahl zwischen 0 und 100. 100 nicht inklusive
     * @return
     */
    public int generate() {
        return rand.nextInt(100);
    }

    /**
     * Generiert eine Ganzzahl zwischen 0 und max. max nicht inklusive
     * @param max Obergränze
     * @return
     */
    public int generate(int max) {
        return rand.nextInt(max);
    }

    /**
     * Generiert eine Doublezahl zwischen 0 und 100.0. 100.0 nicht inklusive
     * @return
     */
    public double generateDouble() {
        return rand.nextDouble();
    }

    /**
     * Generiert eine Doublezahl zwischen 0 und max. max nicht inklusive
     * @param max Obergränze
     * @return
     */
    public double generateDouble(int max) {
        return rand.nextDouble();
    }
}
