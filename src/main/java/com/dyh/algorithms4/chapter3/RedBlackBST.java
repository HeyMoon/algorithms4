package com.dyh.algorithms4.chapter3;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/13 15:44
 * @description:
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {


    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        int n;
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.n = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }

        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.n = h.n;
        h.n = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.n;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            //父节点和红链接相连
            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        // 如果右子节点是红色的，而左子节点是黑色的，进行左旋转
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        // 如果左子节点是红色的，且它的左子节点也是红色的，进行右旋转
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        // 如果左右子节点都是红色，进行颜色转换
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null;
    }


    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    private Node moveRedLeft(Node h) {
        flipColors(h);
        if (isRed(h.right.left)) {
            h.right = rotateRight(h.right);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    private Node moveRedRight(Node h) {
        flipColors(h);
        if (isRed(h.left.left)) {
            h = rotateRight(h);
            flipColors(h);
        }

        return h;
    }

    @Override
    public void deleteMin() {
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMin(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMin(Node h) {
        if (h.left == null) {
            return null;
        }

        if (!isRed(h.left) && !isRed(h.left.left)) {
            h = moveRedLeft(h);
        }

        h.left = deleteMin(h.left);
        return balance(h);
    }

    private Node balance(Node h) {
        // 如果右子节点是红色的，而左子节点是黑色的，进行左旋转
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        // 如果左子节点是红色的，且它的左子节点也是红色的，进行右旋转
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        // 如果左右子节点都是红色，进行颜色转换
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        h.n = size(h.left) + size(h.right) + 1;
        return h;
    }

    @Override
    public void deleteMax() {
        if (!isRed(root.left) && isRed(root.right)) {
            root.color = RED;
        }

        root = deleteMax(root);
        if (!isEmpty()) {
            root.color = BLACK;
        }
    }

    private Node deleteMax(Node h) {
        if (isRed(h.left)) {
            h = rotateRight(h);
        }

        if (h.right == null) {
            return null;
        }

        if (!isRed(h.right) && !isRed(h.right.left)) {
            h = moveRedRight(h);
        }

        h.right = deleteMax(h.right);

        return balance(h);
    }

    @Override
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (!contains(key)) {
            return;
        }

        // if both children of root are black, set root to red
        if (!isRed(root.left) && !isRed(root.right)) {
            root.color = RED;
        }

        root = delete(root, key);
        if (!isEmpty()) {
            root.color = BLACK;
        }

    }

    private Node delete(Node h, Key key) {
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.left) && !isRed(h.left.left))
                h = moveRedLeft(h);
            h.left = delete(h.left, key);
        } else {
            if (isRed(h.left))
                h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.right == null))
                return null;
            if (!isRed(h.right) && !isRed(h.right.left))
                h = moveRedRight(h);
            if (key.compareTo(h.key) == 0) {
                Node x = min(h.right);
                h.key = x.key;
                h.value = x.value;
                // h.val = get(h.right, min(h.right).key);
                // h.key = min(h.right).key;
                h.right = deleteMin(h.right);
            } else h.right = delete(h.right, key);
        }
        return balance(h);


    }

    private Node min(Node x) {
        // assert x != null;
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }


    @Override
    public int size(Key low, Key high) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    public static void main(String[] args) {
        RedBlackBST redBlackBST = new RedBlackBST();

        String[] keys = new String[]{"S", "E", "A", "R", "C", "H", "X", "M", "P", "L"};
        for (int i = 0; i < keys.length; i++) {
            redBlackBST.put(keys[i], i);
        }
    }
}
