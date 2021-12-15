package model.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xt
 * @Desc
 */
public class Main {

    public static void main(String[] args) {
        BranchNode root = new BranchNode("root");
        BranchNode chapter1 = new BranchNode("chapter1");
        BranchNode chapter2 = new BranchNode("chapter2");
        Node c11 = new LeafNode("c11");
        Node c12 = new LeafNode("c12");
        BranchNode b21 = new BranchNode("section21");
        Node c211 = new LeafNode("c211");
        Node c212 = new LeafNode("c212");

        root.add(chapter1);
        root.add(chapter2);
        chapter1.add(c11);
        chapter1.add(c12);
        chapter2.add(b21);
        b21.add(c211);
        b21.add(c212);

        tree(root);
    }

    private static void tree(Node node) {
        if (null == node) return;
        node.p();
        if (node instanceof BranchNode) {
            for (Node n : ((BranchNode) node).nodes) {
                tree(n);
            }
        }
    }
}

abstract class Node {
    // 打印
    abstract void p();
}
class LeafNode extends Node {
    private String content;

    public LeafNode(String content) {
        this.content = content;
    }

    @Override
    void p() {
        System.out.println(this.content);
    }
}

class BranchNode extends Node {
    List<Node> nodes = new ArrayList<>();
    private String name;

    public BranchNode(String name) {
        this.name = name;
    }

    @Override
    void p() {
        System.out.println(name);
    }

    public void add(Node node) {
        nodes.add(node);
    }
}
