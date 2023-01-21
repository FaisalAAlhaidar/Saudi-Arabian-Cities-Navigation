public class Node {
    private Node parent;
    private String name;
    private int index;
    private double pathCost;
    private int level;


    public Node(Node parent, String name, int index, double pathCost, int level) {
        this.parent = parent;
        this.name = name;
        this.index = index;
        this.pathCost = pathCost;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Double getPathCost() {
        return pathCost;
    }

    public void setPathCost(Double pathCost) {
        this.pathCost = pathCost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public static boolean checkParents(Node node, String index) {
        while (node != null) {
            if (node.getName().equals(index))
                return true;
            node = node.getParent();
        }
        return false;

    }

    @Override
    public String toString() {
        return name + "";
    }
}
