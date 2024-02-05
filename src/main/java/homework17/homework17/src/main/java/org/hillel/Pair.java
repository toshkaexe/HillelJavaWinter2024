package org.hillel;
public class Pair {
    private final String lowercase;
    private final String uppercase;

    public Pair(String lowercase, String uppercase) {
        this.lowercase = lowercase;
        this.uppercase = uppercase;
    }

    public String getLowercase() {
        return lowercase;
    }

    public String getUppercase() {
        return uppercase;
    }
}

