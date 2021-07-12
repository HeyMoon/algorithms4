package com.dyh.algorithms4.chapter3;

/**
 * @author: dengyunhui
 * @datetime: 2021/7/12 22:22
 * @description:
 */
public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {


    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public Value get(Key key) {
        Node node = get(root, key);

        return node == null ? null : node.value;
    }

    private Node get(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return get(node.right, key);
        } else if (cmp < 0) {
            return get(node.left, key);
        } else {
            return node;
        }
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
        return size(root);
    }

    @Override
    public Key min() {
        if (isEmpty()) {
            return null;
        }

        Node node = min(root);
        return node.key;
    }

    private Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public Key max() {
        Node node = root;
        while (node.right != null) {
            node = node.right;
        }

        return node.key;
    }

    /**
     * 小于等于 Key 的最大键
     *
     * @param key
     * @return
     */
    @Override
    public Key floor(Key key) {
        Node node = floor(root, key);
        return node == null ? null : node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return floor(node.left, key);
        } else if (cmp > 0) {
            Node t = floor(node.right, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        } else {
            return node;
        }
    }

    /**
     * 大于等于 key 的最小键
     *
     * @param key
     * @return
     */
    @Override
    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        return node == null ? null : node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            return floor(node.right, key);
        } else if (cmp < 0) {
            Node t = floor(node.left, key);
            if (t != null) {
                return t;
            } else {
                return node;
            }
        } else {
            return node;
        }
    }

    /**
     * 小于 key 的键的数量
     *
     * @param key
     * @return
     */
    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null) {
            return 0;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            return size(node.left) + 1 + rank(node.right, key);
        } else {
            return size(node);
        }
    }

    /**
     * 排名为 k 的键
     *
     * @param k
     * @return
     */
    @Override
    public Key select(int k) {
        Node node = select(root, k);
        return node == null ? null : node.key;
    }

    private Node select(Node node, int k) {
        if (node == null) {
            return null;
        }

        int sizeLeft = size(node.left);
        if (sizeLeft > k) {
            return select(node.left, k);
        } else if (sizeLeft < k) {
            return select(node.right, k - sizeLeft - 1);
        } else {
            return node;
        }
    }


    @Override
    public void deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void deleteMax() {
        deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node.right == null) {
            return node.left;
        }

        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void delete(Key key) {

    }

    private Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp > 0) {
            node.right = delete(node.right, key);
        } else if (cmp < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.right == null) {
                return node.left;
            }
            if (node.left == null) {
                return node.right;
            }

            Node t = node;
            node = min(node.right);
            node.right = deleteMin(t.right);
            node.left = t.left;
        }

        node.size = size(node.left) + size(node.right) + 1;

        return node;
    }

    @Override
    public int size(Key low, Key high) {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }
        return node.size;
    }

    @Override
    public Iterable<Key> keys(Key low, Key high) {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private void print(Node node) {
        if (node == null) {
            return;
        }

        print(node.left);
        System.out.println(node.key);
        print(node.right);
    }


}
