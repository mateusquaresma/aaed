package base;

import static java.lang.Integer.max;

public class AVLBinaryTree {

    static class Node {
        // propriedades básicas
        int value;
        Node left;
        Node right;
        Node parent;

        Node(int v) {
            value = v;
        }

        void add(Node n) {
            if (n.value < value) {
                if (left == null) {
                    left = n;
                    n.parent = this;
                } else {
                    left.add(n);
                    int balancing = balancing();
                    if (balancing < -1) {
                        // a árvore ficou desbalanceada à esquerda, é preciso rotacionar a direita

                        /*
                            Antes de rotacionar, vou verificar o filho da esquerda para ver se não é um "joelho".
                            Caso seja, rotaciono este filho para a esquerda, para "esticar o joelho"
                         */
                        if (balancing(left) > 0) rotateLeft(left);

                        rotateRight(this);
                    } else if (balancing > 1) {
                        /*
                            A árvore ficou desbalanceada à direita, é preciso rotacionar a esquerda, mas
                            antes de rotacionar, vou verificar o filho da direita para ver se não é um "joelho".
                            Caso seja, rotaciono este filho para a direita, para "esticar o joelho"
                         */
                        if (balancing(right) < 0) rotateRight(right);

                        rotateLeft(this);
                    } else {
                        // o balanceamento está entre [-1, 1] então não rotaciona
                    }
                }
            } else {
                if (right == null) {
                    right = n;
                    n.parent = this;
                } else {
                    right.add(n);
                    int balancing = balancing();
                    if (balancing < -1) {
                        // a árvore ficou desbalanceada à esquerda, é preciso rotacionar a direita

                        /*
                            Antes de rotacionar, vou verificar o filho da esquerda para ver se não é um "joelho".
                            Caso seja, rotaciono este filho para a esquerda, para "esticar o joelho"
                         */
                        if (balancing(left) > 0) rotateLeft(left);

                        rotateRight(this);
                    } else if (balancing > 1) {
                        /*
                            A árvore ficou desbalanceada à direita, é preciso rotacionar a esquerda, mas
                            antes de rotacionar, vou verificar o filho da direita para ver se não é um "joelho".
                            Caso seja, rotaciono este filho para a direita, para "esticar o joelho"
                         */
                        if (balancing(right) < 0) rotateRight(right);

                        rotateLeft(this);
                    } else {
                        // o balanceamento está entre [-1, 1] então não rotaciona
                    }
                }
            }
        }

        int height() {
            return height(this);
        }

        int height(Node n) {
            if (n == null)
                return -1;
            else {
                int lh = height(n.left);
                int rh = height(n.right);
                return max(lh, rh) + 1;
            }
        }

        int balancing() {
            return height(right) - height(left);
        }

        int balancing(Node n) {
            return height(n.right) - height(n.left);
        }

        @Override
        public String toString() {
            String lv = left == null ? "x" : String.valueOf(left.value);
            String rv = right == null ? "x" : String.valueOf(right.value);
            String p = parent == null ? "x" : String.valueOf(parent.value);
            return String.format("[%s %s %s, p=%s]", lv, value, rv, p);
        }
    }

    /**
     * p = nó desbalanceado
     *
     * @param p
     */
    static void rotateLeft(Node p) {
        Node q = p.right;

        p.right = q.left;
        if (q.left != null) q.left.parent = p;

        q.left = p;
        q.parent = p.parent;
        p.parent = q;

        if (q.parent != null) q.parent.right = q;
    }

    /**
     * p = nó desbalanceado
     *
     * @param p
     */
    static void rotateRight(Node p) {
        Node q = p.left;

        p.left = q.right;
        if (q.right != null) q.right.parent = p;

        q.right = p;
        q.parent = p.parent;
        p.parent = q;

        if (q.parent != null) q.parent.left = q;
    }

    /*
        As rotações duplas precisam ser tratadas exclusivamente
     */
    static void rotateRightLeft(Node p){

    }

    static void rotateLeftRight(Node p){

    }

    static void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node + " ");
            printInOrder(node.right);
        }
    }

    static Node rootOf(Node n) {
        if (n.parent == null) return n;
        else return rootOf(n.parent);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(2));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(3));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(4));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(5));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(6));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(18));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(17));
        printInOrder(rootOf(root));
        System.out.println();

        rootOf(root).add(new Node(16));
        printInOrder(rootOf(root));
        System.out.println();

//        rootOf(root).add(new Node(15));
//        printInOrder(rootOf(root));
//        System.out.println();
//
//        rootOf(root).add(new Node(14));
//        printInOrder(rootOf(root));
//        System.out.println();
//
//        rootOf(root).add(new Node(20));
//        printInOrder(rootOf(root));
//        System.out.println();
    }
}
