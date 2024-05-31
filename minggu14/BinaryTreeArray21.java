package minggu14;
import java.util.Scanner;
public class BinaryTreeArray21 {
    public class BinaryTreeArray {
        int[] data;
        int idxLast;

        public BinaryTreeArray() {
            data = new int[10];
        }

        void populateData(int data[], int idxLast) {
            this.data = data;
            this.idxLast = idxLast;
        }

        void traverseInOrder(int idxStart) {
            if (idxStart <= idxLast) {
                traverseInOrder(2 * idxStart + 1);
                System.out.print(data[idxStart] + " ");
                traverseInOrder(2 * idxStart + 2);
            }
        }

        void traversePreOrder(int idxStart) {
            if (idxStart <= idxLast) {
                System.out.print(data[idxStart] + " ");
                traversePreOrder(2 * idxStart + 1);
                traversePreOrder(2 * idxStart + 2);
            }
        }

        void traversePostOrder(int idxStart) {
            if (idxStart <= idxLast) {
                traversePostOrder(2 * idxStart + 1);
                traversePostOrder(2 * idxStart + 2);
                System.out.print(data[idxStart] + " ");
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeArray21 binaryTreeArray21 = new BinaryTreeArray21();
        BinaryTreeArray21.BinaryTreeArray bta = binaryTreeArray21.new BinaryTreeArray();
        int[] data = {6, 4, 8, 3, 5, 7, 9, 0, 0, 0};
        int idxLast = 6;
        bta.populateData(data, idxLast);

        System.out.print("InOrder Traversal   : ");
        bta.traverseInOrder(0);
        System.out.println();

        System.out.print("PreOrder Traversal  : ");
        bta.traversePreOrder(0);
        System.out.println();

        System.out.print("PostOrder Traversal : ");
        bta.traversePostOrder(0);
        System.out.println();
    }
}
