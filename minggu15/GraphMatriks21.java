package minggu15;
import java.util.Scanner;
public class GraphMatriks21 {
    int vertex;
    int[][] matriks;

    public GraphMatriks21(int v) {
        vertex = v;
        matriks = new int[v][v];
    }

    public void makeEdge(int asal, int tujuan, int jarak) {
        matriks[asal][tujuan] = jarak;
    }

    public void removeEdge(int asal, int tujuan) {
        matriks[asal][tujuan] = -1;
    }

    public void printGraph() {
        for (int i = 0; i < vertex; i++) {
            System.out.print("Gedung " + (char) ('A' + i) + ": ");
            for (int j = 0; j < vertex; j++) {
                if (matriks[i][j] != -1) {
                    System.out.print("Gedung " + (char) ('A'+j) + " ("+ matriks[i] [j]+" m), ");
                }
            }
        System.out.println();
        }
    }

    public void degree() {
        System.out.println("-----------------------------------");
        System.out.println("| Gedung |  OutDegree |  InDegree |");
        System.out.println("-----------------------------------");
        for (int i = 0; i < vertex; i++) {
            int outDegree = 0;
            int inDegree = 0;

            for (int j = 0; j < vertex; j++) {
                if (matriks[i][j] != 0) {
                    outDegree++;
                }
            }

            for (int j = 0; j < vertex; j++) {
                if (matriks[j][i] != 0) {
                    inDegree++;
                }
            }
            System.out.printf("|   %c    |    %3d     |    %3d    |\n", (char) ('A' + i), outDegree, inDegree);
        }
        System.out.println("-----------------------------------\n");
    }

    public static void main(String[] args) {
        GraphMatriks21 gdg = new GraphMatriks21(4);
        gdg.makeEdge(0, 1, 50);
        gdg.makeEdge(1, 0, 60);
        gdg.makeEdge(1, 2, 70);
        gdg.makeEdge(2, 1, 80);
        gdg.makeEdge(2, 3, 40);
        gdg.makeEdge(3, 0, 90);

        gdg.degree();
    }
}
