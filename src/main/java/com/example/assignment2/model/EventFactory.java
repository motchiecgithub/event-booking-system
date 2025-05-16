package com.example.assignment2.model;

public class EventFactory {
    public static Event createFromLine(String line){
        String[] parts = line.split(";");
        String title = parts[0].trim();
        String venue = parts[1].trim();
        String day = parts[2].trim();
        double price = Double.parseDouble(parts[3].trim());
        int sold = Integer.parseInt(parts[4].trim());
        int total = Integer.parseInt(parts[5].trim());
        return new Event(title, venue, day, price, sold, total);
    }
}
