package com.example.assignment2.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class EventDAO {
    public static List<Event> loadEvents(String filename) {
        List<Event> events = new ArrayList<>();

        // ✅ Load from classpath (resources folder)
        try (InputStream is = EventDAO.class.getResourceAsStream("/" + filename)) {
            if (is == null) {
                System.out.println("events.dat not found in resources folder.");
                return events;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = reader.readLine()) != null) {
                events.add(EventFactory.createFromLine(line));
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }

        return events;
    }
}
