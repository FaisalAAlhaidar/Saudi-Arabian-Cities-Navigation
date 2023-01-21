import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Graph SA = new Graph();
    public static Dictionaries DICTIONARY = new Dictionaries();
    public static double[][] distances;

    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        List<String> list1 = new ArrayList<>();
        try {
            JsonObject file = (JsonObject) parser.parse(new FileReader("CitiesDistances.json"));
            JsonArray list = (JsonArray) file.get("city");
            for (JsonElement element : list) {
                JsonObject city1 = element.getAsJsonObject();
                JsonArray tempList = (JsonArray) city1.get("children");
                list1.add(city1.get("name").getAsString());
                for (JsonElement jsonElement : tempList) {
                    JsonObject city2 = jsonElement.getAsJsonObject();
                    SA.insertEdge(city1.get("name").getAsString(), city2.get("name").getAsString(), city2.get("w").getAsDouble());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int k = 0; k < DICTIONARY.rev.size(); k++) {
            if (!list1.contains(DICTIONARY.rev.get(k)))
                list1.add(DICTIONARY.rev.get(k));
            else
                list1.remove(DICTIONARY.rev.get(k));
        }
        distances = SA.toMatrix();
        new MainPage().setVisible(true);
    }

    public static String format(int[] a) {
        StringBuilder s = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            s.append(Main.DICTIONARY.rev.get(a[i]));
            if (i != 0)
                s.append(" -> ");
            if ((i + 2) % 8 == 0)
                s.append("\n");
        }
        return s.toString();
    }

    public static double round(double n) {
        return (double) Math.round(n * 100) / 100;
    }
}
