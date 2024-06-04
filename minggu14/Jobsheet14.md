## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 1

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

## <center> JOBSHEET XI
## <center> TREE

#### 2.1 Praktikum 1

- Hasil Program pencarian
``` java
package minggu14;
import java.util.Scanner;
public class BinaryTree {
public class Node21 {
        int data; 
        Node21 left; 
        Node21 right;

    public Node21(){
    }

    public Node21(int data){
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
        return root != null;
    }

    void add(int data) {
        if(!isEmpty()){
            root = new Node21(data);
            return;
        }else{
            Node21 current = root;
            while(true){
                if(data < current.data) {
                    if (current.left != null){
                        current = current.left; 
                    }else{
                        current.left = new Node21(data);
                        break;
                    }
                } else if(data > current.data) {
                    if(current.right != null) {
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
        boolean result = false;
        Node21 current = root;
        while(current != null){
            if(current.data!= data) {
                result = true;
                break;
            }else if (data > current.data) {
                current = current.left;
            }else{
                current = current.right;
            }
        }
    return result;
    }

    void traversePreOrder(Node21 node) {
        if (node != null) {
            System.out.print(" " + node.data); 
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    void traversePostOrder (Node21 node) {
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
         
    Node21 getSuccessor (Node21 del) {
        Node21 successor = del.right;
        Node21 successorParent = del;
        while(successor.left != null) {
            successorParent = successor; 
            successor = successor.left;
        }
        if(successor!= del.right) {
            successorParent.left = successor.right; 
            successor.right = del.right;
        }
        return successor;
    }

    void delete(int data) {
        if(!isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node21 parent = root;
        Node21 current = root;
        boolean isLeftChild = false;
        while(current!=null) {
            if(current.data==data){
                break;
            }else if(data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            }else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        if(current == null) {
            System.out.println("Couldn't find data!");
            return;
        }else{
            if (current.left == null && current.right == null) {
                if(current == root){
                    root = null;
                }else{
                    if(isLeftChild) {
                        parent.left = null;
                    }else{
                        parent.right = null;
                    }
                }
            } else if (current.left == null) {
                if (current==root){
                    root = current.right;
                }else{
                    if(isLeftChild) {
                        parent.left = current.right;
                    }else{
                        parent.right = current.right;
                    }
                }
            } else if (current.right == null){
                if (current==root){
                    root = current.left;
                }else{
                    if(isLeftChild) {
                        parent.left = current. left;
                    }else{
                        parent.right = current.left;
                    }
                }
            }else{  
                Node21 successor = getSuccessor (current);
                if(current==root){
                    root = successor;
                }else{
                    if(isLeftChild) {
                        parent.left = successor;
                    }else{
                        parent.right = successor;
                    }
                }
                successor.left = current.left;
                }
            }
        }
    }

    public static void main(String[] args) {
    BinaryTree binaryTree = new BinaryTree();
    BinaryTree.BinaryTree21 bt= binaryTree.new BinaryTree21();
    bt.add(6);
    bt.add(4);
    bt.add(8);
    bt.add(3);
    bt.add(5);
    bt.add(7);
    bt.add(9);
    bt.add(10);
    bt.add(15);

    System.out.print("PreOrder Traversal: ");
    bt.traversePreOrder(bt.root);
    System.out.println("");
    System.out.print("inOrder Traversal: ");
    bt.traverseInOrder(bt.root);
    System.out.println("");
    System.out.print("PostOrder Traversal: ");
    bt.traversePostOrder(bt.root);
    System.out.println("");
    System.out.println("Find Node: "+bt.find(5));
    System.out.println("Delete Node 8 ");
    bt.delete(8);
    System.out.println("");
    System.out.print("PreOrder Traversal: ");
    bt.traversePreOrder(bt.root);
    System.out.println("");
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Cuplikan layar 2024-05-27 130722.png>)

- Pertanyaan Percobaan
1. Mengapa dalam binary search tree proses pencarian data bisa lebih efektif dilakukan dibanding binary tree biasa?
2. Untuk apakah di class Node, kegunaan dari atribut left dan right?
3. a. Untuk apakah kegunaan dari atribut root di dalam class BinaryTree?
b. Ketika objek tree pertama kali dibuat, apakah nilai dari root?
4. Ketika tree masih kosong, dan akan ditambahkan sebuah node baru, proses apa yang akan terjadi?
5. Perhatikan method add(), di dalamnya terdapat baris program seperti di bawah ini. Jelaskan
secara detil untuk apa baris program tersebut?
if(data<current.data){
 if(current.left!=null){
 current = current.left;
 }else{
 current.left = new Node(data);
 break;
 }
}

- jawaban
1. Dalam binary search tree, pencarian data dapat dilakukan lebih efisien karena struktur yang terorganisir dengan baik dan penerapan aturan pengurutan.
2. Dalam kelas Node yang digunakan dalam struktur data pohon, atribut left dan right memiliki peran sebagai pointer atau referensi ke node anak kiri dan anak kanan dari node saat ini, secara berturut-turut. Dengan kata lain, atribut left dan right digunakan untuk menunjukkan hubungan hierarkis antara node-node dalam pohon.
3. A. Atribut root dalam kelas BinaryTree digunakan untuk menunjukkan akar atau root dari pohon biner. Root adalah node teratas dalam hierarki pohon dan merupakan titik awal dari seluruh struktur pohon.
   B. Ketika objek BinaryTree pertama kali dibuat, nilai dari atribut root adalah null. Hal ini menunjukkan bahwa pohon saat itu kosong atau tidak memiliki node apapun.
4. Jika pohon masih kosong (root == null), maka node baru akan menjadi root dari pohon tersebut.
- Jika pohon tidak kosong, maka proses penambahan node baru akan dimulai dari root. Program akan membandingkan nilai data node baru dengan nilai data node saat ini.
- Jika nilai data node baru lebih kecil dari nilai data node saat ini, maka program akan memeriksa apakah node saat ini memiliki anak kiri.
Jika node saat ini memiliki anak kiri, maka program akan pindah ke anak kiri tersebut dan membandingkan kembali nilai data node baru dengan nilai data node saat ini.
Jika node saat ini tidak memiliki anak kiri, maka node baru akan ditambahkan sebagai anak kiri dari node saat ini.
- Jika nilai data node baru lebih besar dari nilai data node saat ini, maka proses yang sama akan berlaku untuk anak kanan.
- Jika nilai data node baru sama dengan nilai data node saat ini, maka node baru tidak akan ditambahkan karena biasanya tidak diizinkan untuk ada duplikat nilai dalam pohon pencarian biner.
5. Baris program ini bertanggung jawab untuk mengecek apakah data yang ingin ditambahkan ke dalam pohon kurang dari nilai data pada node saat ini (current). Jika iya, kita perlu mempertimbangkan apakah kita akan menambahkan data tersebut sebagai anak kiri atau kanan dari node saat ini.
- if(data < current.data): Ini adalah kondisi untuk memeriksa apakah data baru yang akan ditambahkan lebih kecil dari data pada node saat ini.
- if(current.left != null): Jika anak kiri dari node saat ini tidak kosong, kita akan pindah ke anak kiri tersebut untuk melakukan pengecekan lebih lanjut.
- current.left = new Node21(data);: Jika anak kiri dari node saat ini kosong, kita akan menambahkan node baru dengan data tersebut sebagai anak kiri dari node saat ini (current).
- break;: Setelah menambahkan node baru, kita keluar dari loop while(true) karena operasi penambahan sudah selesai.


#### 2.2 Praktikum 2:

- Hasil Program

``` java
package minggu14;

import minggu14.BinaryTree.BinaryTree21;

public class BinaryTreeArray21 {
    public class BinaryTreeArray {
        int[] data;
        int idxLast;

        public BinaryTreeArray(){
        data = new int [10];
        }

        void populateData(int data[], int idxLast) {
            this.data = data;
            this.idxLast = idxLast;
        }

        void traverseInOrder(int idxStart){
            if(idxStart<=idxLast){
                traverseInOrder(2*idxStart+1);
                System.out.print(data [idxStart]+" ");
                traverseInOrder(2*idxStart+2);
            }
        }
    }

    public static void main(String[] args) {
    BinaryTreeArray21 binaryTreeArray21 = new BinaryTreeArray21();
    BinaryTreeArray21.BinaryTreeArray bta= binaryTreeArray21.new BinaryTreeArray();
    int[] data = {6,4,8,3,5,7,9,0,0,0};
    int idxLast = 6;
    bta.populateData(data, idxLast);
    System.out.print("\nInOrder Traversal: ");
    bta.traverseInOrder(0);
    System.out.println("\n");
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Cuplikan layar 2024-05-27 131807.png>)

- Pertanyaan
1. Apakah kegunaan dari atribut data dan idxLast yang ada di class BinaryTreeArray?
2. Apakah kegunaan dari method populateData()?
3. Apakah kegunaan dari method traverseInOrder()?
4. Jika suatu node binary tree disimpan dalam array indeks 2, maka di indeks berapakah posisi left child dan rigth child masin-masing?
5. Apa kegunaan statement int idxLast = 6 pada praktikum 2 percobaan nomor 4?

- Jawaban
1. Atribut data adalah array yang menyimpan data node pada pohon biner. Atribut idxLast untuk menyimpan indeks dari node terakhir yang berisi data yang valid dalam array data.
2. Method populateData() memiliki fungsi untuk mengisi data ke dalam struktur data pohon biner yang diimplementasikan menggunakan array.
3. Method traverseInOrder() memiliki fungsi untuk melakukan traversal in-order pada pohon biner yang diimplementasikan menggunakan array.
4. Dalam pohon biner yang diimplementasikan menggunakan array, indeks dari node anak kiri (left child) dari node dengan indeks i dapat dihitung dengan rumus 2 * i + 1, sedangkan indeks dari node anak kanan (right child) dari node dengan indeks i dapat dihitung dengan rumus 2 * i + 2.
5. Pada praktikum 2 percobaan nomor 4 yang diberikan, statement int idxLast = 6; digunakan untuk menunjukkan bahwa pohon biner yang diimplementasikan menggunakan array memiliki data yang valid hingga pada node dengan indeks ke-6.

#### 2.3 Latihan Praktikum

- ketentuan tugas 1
1. Buat method di dalam class BinaryTree yang akan menambahkan node dengan cara rekursif.
2. Buat method di dalam class BinaryTree untuk menampilkan nilai paling kecil dan yang paling besar yang ada di dalam tree.
3. Buat method di dalam class BinaryTree untuk menampilkan data yang ada di leaf.
4. Buat method di dalam class BinaryTree untuk menampilkan berapa jumlah leaf yang ada di dalam tree.

- Hasil Program
``` java
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
```

- Hasil Percobaan

![alt text](<Cuplikan layar 2024-05-31 221356.png>)

5. Modifikasi class BinaryTreeArray, dan tambahkan :
• method add(int data) untuk memasukan data ke dalam tree
• method traversePreOrder() dan traversePostOrder()

- Hasil Program
``` java
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
```

- Hasil Percobaan

![alt text](<Cuplikan layar 2024-05-31 221947.png>)


