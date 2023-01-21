import java.util.HashMap;
import java.util.Map;

public class Graph {
    private final HashMap<String, HashMap<String, Double>> cities = new HashMap<>();

    public void insertVertex(String x) {
        if (!cities.containsKey(x)) {
            HashMap<String, Double> hashMap = new HashMap<>();
            cities.put(x, hashMap);
        }
    }

    public boolean deleteVertex(String cityName) {
        if (!cities.containsKey(cityName))
            return false;
        cities.remove(cityName);
        for (Map.Entry<String, HashMap<String, Double>> entry : cities.entrySet())
            entry.getValue().remove(cityName);
        return true;
    }

    public boolean insertEdge(String x, String y, double w) {
        if (!cities.containsKey(x)) {
            insertVertex(x);
        }
        if (!cities.containsKey(y)) {
            insertVertex(y);
        }
        if (cities.containsKey(x) && cities.containsKey(y)) {
            if (!cities.get(x).containsKey(y) && !cities.get(y).containsKey(x)) {
                cities.get(x).put(y, w);
                cities.get(y).put(x, w);
                return true;
            } else {
                return false;
            }
        }
        return false;

    }

    public HashMap<String, Double> getChildren(String x) {
        return cities.get(x);
    }

    public double[][] toMatrix(){
        double[][] distances = new double[cities.size()][cities.size()];
        for (String city : cities.keySet()) {
            for (String neighbor : cities.get(city).keySet()) {
                distances[Main.DICTIONARY.map.get(city)][Main.DICTIONARY.map.get(neighbor)] = cities.get(city).get(neighbor);
            }
        }
        return distances;
    }
}
