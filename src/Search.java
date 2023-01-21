import java.util.*;

public class Search {
    static int sleep = 500;

    public static void BFS(int initial, int dest) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Integer> explored = new HashSet<>();
        Node n = new Node(null, Main.DICTIONARY.rev.get(initial), initial, 0, 0);
        boolean found = false;
        queue.add(n);
        explored.add(n.getIndex());
        while (!queue.isEmpty() && (n = queue.remove()).getIndex() != dest) {
            HashMap<String, Double> list = Main.SA.getChildren(n.getName());
            for (Map.Entry<String, Double> entry : list.entrySet()) {
                if (Node.checkParents(n, entry.getKey()) || explored.contains(Main.DICTIONARY.map.get(entry.getKey())))
                    continue;
                Node tmp = new Node(n, entry.getKey(), Main.DICTIONARY.map.get(entry.getKey()), n.getPathCost() + entry.getValue(), n.getLevel() + 1);
                if (tmp.getIndex() == dest) {
                    n = tmp;
                    found = true;
                    break;
                }
                queue.add(tmp);
                explored.add(tmp.getIndex());
            }
            if (found) {
                break;
            }
            int[] path = pathUpTo(n);
            System.out.println(Main.format(path));
            MainPage.deployPath(path);
            MainPage.citiesPainter.setSolution(path);
            MainPage.jXMapViewer.repaint();
            MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int[] path = pathUpTo(n);
        System.out.println(Main.format(path));
        MainPage.deployPath(path);
        MainPage.citiesPainter.setSolution(path);
        MainPage.jXMapViewer.repaint();
        MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (n.getIndex() == dest) {
            Node.checkParents(n, n.getName());
        } else {
            System.out.println("No Solution");
        }

    }

    public static void UCS(int initial, int dest) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.getPathCost().compareTo(b.getPathCost()));
        Node n = new Node(null, Main.DICTIONARY.rev.get(initial), initial, 0, 0);
        queue.add(n);
        while (!queue.isEmpty() && (n = queue.remove()).getIndex() != dest) {
            HashMap<String, Double> list = Main.SA.getChildren(n.getName());
            for (Map.Entry<String, Double> entry : list.entrySet()) {
                Node tmp = new Node(n, entry.getKey(), Main.DICTIONARY.map.get(entry.getKey()), n.getPathCost() + entry.getValue(), n.getLevel() + 1);
                if (Node.checkParents(n, tmp.getName()) || !shorter(queue, tmp))
                    continue;
                queue.add(tmp);
            }
            int[] path = pathUpTo(n);
            System.out.println(Main.format(path));
            MainPage.deployPath(path);
            MainPage.citiesPainter.setSolution(path);
            MainPage.jXMapViewer.repaint();
            MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int[] path = pathUpTo(n);
        System.out.println(Main.format(path));
        MainPage.deployPath(path);
        MainPage.citiesPainter.setSolution(path);
        MainPage.jXMapViewer.repaint();
        MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (n.getIndex() == dest) {
            Node.checkParents(n, n.getName());
        } else {
            System.out.println("No Solution");
        }
    }

    public static void IDS(int initial, int dest) {
        int l = 1;
        while (!DLS(initial, dest, l++) && l <= 15) ;
    }

    private static boolean DLS(int initial, int dest, int l) {

        Stack<Node> stack = new Stack<>();
        Node n = new Node(null, Main.DICTIONARY.rev.get(initial), initial, 0, 0);
        stack.add(n);
        while (!stack.isEmpty() && (n = stack.pop()).getIndex() != dest) {
            if (n.getLevel() >= l) {
                continue;
            }
            HashMap<String, Double> list = Main.SA.getChildren(n.getName());
            for (Map.Entry<String, Double> entry : list.entrySet()) {
                Node tmp = new Node(n, entry.getKey(), Main.DICTIONARY.map.get(entry.getKey()), n.getPathCost() + entry.getValue(), n.getLevel() + 1);
                if (Node.checkParents(n, tmp.getName()))
                    continue;
                stack.push(tmp);
            }
            int[] path = pathUpTo(n);
            System.out.println(Main.format(path));
            MainPage.deployPath(path);
            MainPage.citiesPainter.setSolution(path);
            MainPage.jXMapViewer.repaint();
            MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int[] path = pathUpTo(n);
        System.out.println(Main.format(path));
        MainPage.deployPath(path);
        MainPage.jXMapViewer.repaint();
        MainPage.citiesPainter.setSolution(path);
        MainPage.jXMapViewer.repaint();
        MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (n.getIndex() == dest && l != 0) {
            Node.checkParents(n, n.getName());
            return true;
        } else {
            System.out.println("No Solution");
            return false;

        }
    }

    public static void GreedySearch(int initial, int dest) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(a -> Main.DICTIONARY.calculateDistance(a.getName(), Main.DICTIONARY.rev.get(dest))));
        Node n = new Node(null, Main.DICTIONARY.rev.get(initial), initial, 0, 0);
        HashSet<Integer> explored = new HashSet<>();
        queue.add(n);
        explored.add(n.getIndex());
        while (!queue.isEmpty() && (n = queue.remove()).getIndex() != dest) {
            HashMap<String, Double> list = Main.SA.getChildren(n.getName());
            for (Map.Entry<String, Double> entry : list.entrySet()) {
                if (explored.contains(Main.DICTIONARY.map.get(entry.getKey())))
                    continue;
                Node tmp = new Node(n, entry.getKey(), Main.DICTIONARY.map.get(entry.getKey()), n.getPathCost() + entry.getValue(), n.getLevel() + 1);
                queue.add(tmp);
                explored.add(tmp.getIndex());
            }
            int[] path = pathUpTo(n);
            System.out.println(Main.format(path));
            MainPage.deployPath(path);
            MainPage.jXMapViewer.repaint();
            MainPage.citiesPainter.setSolution(path);
            MainPage.jXMapViewer.repaint();
            MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int[] path = pathUpTo(n);
        System.out.println(Main.format(path));
        MainPage.deployPath(path);
        MainPage.citiesPainter.setSolution(path);
        MainPage.jXMapViewer.repaint();
        MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (n.getIndex() == dest) {
            Node.checkParents(n, n.getName());
        } else {
            System.out.println("No Solution");
        }
    }

    public static void AStar(int initial, int dest) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(a -> Main.DICTIONARY.calculateDistance(a.getName(), Main.DICTIONARY.rev.get(dest)) + a.getPathCost()));
        Node n = new Node(null, Main.DICTIONARY.rev.get(initial), initial, 0, 0);
        queue.add(n);
        while (!queue.isEmpty() && (n = queue.remove()).getIndex() != dest) {
            HashMap<String, Double> list = Main.SA.getChildren(n.getName());
            for (Map.Entry<String, Double> entry : list.entrySet()) {
                Node tmp = new Node(n, entry.getKey(), Main.DICTIONARY.map.get(entry.getKey()), n.getPathCost() + entry.getValue(), n.getLevel() + 1);
                if (Node.checkParents(n, tmp.getName()) || !shorter(queue, tmp))
                    continue;
                queue.add(tmp);
            }
            int[] path = pathUpTo(n);
            System.out.println(Main.format(path));
            MainPage.deployPath(path);
            MainPage.jXMapViewer.repaint();
            MainPage.citiesPainter.setSolution(path);
            MainPage.jXMapViewer.repaint();
            MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int[] path = pathUpTo(n);
        System.out.println(Main.format(path));
        MainPage.deployPath(path);
        MainPage.jXMapViewer.repaint();
        MainPage.citiesPainter.setSolution(path);
        MainPage.jXMapViewer.repaint();
        MainPage.setCurrent(Main.format(path), Main.round(calculatePathDistance(n)) + "");
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (n.getIndex() == dest) {
            Node.checkParents(n, n.getName());
        } else {
            System.out.println("No Solution");
        }
    }

    private static boolean shorter(PriorityQueue<Node> nodes, Node node) {
        for (Node n : nodes) {
            if (n.getIndex() == node.getIndex()) {
                if (node.getPathCost() <= n.getPathCost()) {
                    nodes.remove(n);
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public static double calculatePathDistance(Node node) {
        double distance = 0;
        while (node.getParent() != null) {
            distance += Main.distances[node.getIndex()][node.getParent().getIndex()];
            node = node.getParent();
        }
        return distance;
    }

    public static int[] pathUpTo(Node node) {
        ArrayList<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.getIndex());
            node = node.getParent();
        }
        int[] path = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            path[i] = list.get(i);
        }
        return path;
    }
}
