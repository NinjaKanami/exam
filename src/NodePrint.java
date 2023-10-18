import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodePrint {
    public static void main(String[] args) {
        List<Node> nodeList = Arrays.asList(
                new Node(1, 0, "aa"),
                new Node(2, 1, "bb"),
                new Node(3, 1, "cc"),
                new Node(4, 3, "dd"),
                new Node(5, 3, "ee"),
                new Node(6, 2, "ff"),
                new Node(7, 2, "gg"),
                new Node(8, 4, "hh"),
                new Node(9, 5, "ii"),
                new Node(10, 0, "jj"),
                new Node(11, 10, "kk"),
                new Node(12, 10, "ll"));
        print(nodeList);
    }

    public static void print(List<Node> nodeList) {
        //todo
        List<Node> rootList = findRoot(nodeList);
        for (Node node : rootList) {
            System.out.println(node.name);
            getSon(nodeList, node.id, 1);
        }
    }

    /**
     * 查找根节点
     *
     * @param nodeList
     * @return
     */
    public static List<Node> findRoot(List<Node> nodeList) {
        List<Node> rootList = new ArrayList<>();
        for (Node node : nodeList) {
            boolean isNotRoot = false;
            for (Node n : nodeList) {
                if (node.parentId == n.id) {
                    isNotRoot = true;
                    break;
                }
            }
            if (!isNotRoot) {
                rootList.add(node);
            }
        }
        return rootList;
    }

    /**
     * 查找并打印孩子节点
     *
     * @param nodeList
     * @param id
     * @param level
     * @return
     */
    public static Node getSon(List<Node> nodeList, Integer id, int level) {
        for (Node node : nodeList) {
            if (node.parentId == id) {
                for (int i = 0; i < level; i++) {
                    System.out.print("\t");
                }
                System.out.println(node.name);
                getSon(nodeList, node.id, level + 1);
            }
        }
        return null;
    }
}


class Node {
    int id;
    int parentId;
    String name;

    public Node(int id, int parentId, String name) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
