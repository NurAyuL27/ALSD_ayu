package minggu14;
import java.util.Scanner;
public class BinaryTree {
    public class Node21 {
        int data; 
        Node21 left; 
        Node21 right;

        public Node21() {
        }

        public Node21(int data) {
            this.left = null;
            this.data = data;
            this.right = null;
        }
    }

    public class BinaryTree21 {
        Node21 root;

        public BinaryTree21() {
            root = null;
        }

        boolean isEmpty() {
            return root == null;
        }

        void add(int data) {
            if (isEmpty()) {
                root = new Node21(data);
            } else {
                Node21 current = root;
                while (true) {
                    if (data < current.data) {
                        if (current.left != null) {
                            current = current.left;
                        } else {
                            current.left = new Node21(data);
                            break;
                        }
                    } else if (data > current.data) {
                        if (current.right != null) {
                            current = current.right;
                        } else {
                            current.right = new Node21(data);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }

        boolean find(int data) {
            Node21 current = root;
            while (current != null) {
                if (data == current.data) {
                    return true;
                } else if (data < current.data) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            return false;
        }

        void traversePreOrder(Node21 node) {
            if (node != null) {
                System.out.print(" " + node.data); 
                traversePreOrder(node.left);
                traversePreOrder(node.right);
            }
        }

        void traversePostOrder(Node21 node) {
            if (node != null) {
                traversePostOrder(node.left);
                traversePostOrder(node.right); 
                System.out.print(" " + node.data);
            }
        }

        void traverseInOrder(Node21 node) {
            if (node != null) {
                traverseInOrder(node.left); 
                System.out.print(" " + node.data);
                traverseInOrder(node.right);
            }
        }

        Node21 getSuccessor(Node21 del) {
            Node21 successor = del.right;
            Node21 successorParent = del;
            while (successor.left != null) {
                successorParent = successor; 
                successor = successor.left;
            }
            if (successor != del.right) {
                successorParent.left = successor.right; 
                successor.right = del.right;
            }
            return successor;
        }

        void delete(int data) {
            if (isEmpty()) {
                System.out.println("Tree is empty!");
                return;
            }
            Node21 parent = root;
            Node21 current = root;
            boolean isLeftChild = false;
            while (current != null) {
                if (data == current.data) {
                    break;
                } else if (data < current.data) {
                    parent = current;
                    current = current.left;
                    isLeftChild = true;
                } else {
                    parent = current;
                    current = current.right;
                    isLeftChild = false;
                }
            }
            if (current == null) {
                System.out.println("Couldn't find data!");
                return;
            } else {
                if (current.left == null && current.right == null) {
                    if (current == root) {
                        root = null;
                    } else {
                        if (isLeftChild) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                    }
                } else if (current.left == null) {
                    if (current == root) {
                        root = current.right;
                    } else {
                        if (isLeftChild) {
                            parent.left = current.right;
                        } else {
                            parent.right = current.right;
                        }
                    }
                } else if (current.right == null) {
                    if (current == root) {
                        root = current.left;
                    } else {
                        if (isLeftChild) {
                            parent.left = current.left;
                        } else {
                            parent.right = current.left;
                        }
                    }
                } else {
                    Node21 successor = getSuccessor(current);
                    if (current == root) {
                        root = successor;
                    } else {
                        if (isLeftChild) {
                            parent.left = successor;
                        } else {
                            parent.right = successor;
                        }
                    }
                    successor.left = current.left;
                }
            }
        }

        void addRecursive(Node21 node, int data) {
            if (data < node.data) {
                if (node.left != null) {
                    addRecursive(node.left, data);
                } else {
                    node.left = new Node21(data);
                }
            } else if (data > node.data) {
                if (node.right != null) {
                    addRecursive(node.right, data);
                } else {
                    node.right = new Node21(data);
                }
            }
        }

        void findMinMax(Node21 node) {
            Node21 current = node;
            while (current.left != null) {
                current = current.left;
            }
            System.out.println();
            System.out.println("Smallest Value       : " + current.data);

            current = node;
            while (current.right != null) {
                current = current.right;
            }
            System.out.println("Largest Value        : " + current.data);
        }

        void displayLeafNodes(Node21 node) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                System.out.print(node.data + " ");
            }
            displayLeafNodes(node.left);
            displayLeafNodes(node.right);
        }

        int countLeafNodes(Node21 node) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null) {
                return 1;
            }
            return countLeafNodes(node.left) + countLeafNodes(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.BinaryTree21 bt = binaryTree.new BinaryTree21();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(10);
        bt.add(15);

        System.out.print("Pre Order Traversal  :");
        bt.traversePreOrder(bt.root);
        System.out.println("");
        System.out.print("In Order Traversal   :");
        bt.traverseInOrder(bt.root);
        System.out.println("");
        System.out.print("Post Order Traversal :");
        bt.traversePostOrder(bt.root);
        System.out.println("");
        bt.findMinMax(bt.root);
        System.out.print("Number of Leaf Nodes : ");
        System.out.println(bt.countLeafNodes(bt.root));
        System.out.println();
        System.out.println("Find Node            : " + bt.find(5));
        System.out.println("Delete Node 8");
        bt.delete(8);
        System.out.println();
        System.out.print("Pre Order Traversal  :");
        bt.traversePreOrder(bt.root);
        System.out.println("");
    }
}