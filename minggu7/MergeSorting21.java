package minggu7;

public class MergeSorting21 {
    public void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }
        public void merge(int data[], int left, int middle, int right) {
            int[] temp = new int[data.length];
            for (int i = left; i <= right; i++) {
                temp[i] = data[i];
            }
            int a = left;
            int b = middle + 1;
            int c = left;

            while (a <= middle && b <= right) {
                if (temp[a] <= temp[b]) {
                    data[c] = temp[a];
                    a++;
                } else {
                    data[c] = temp[b];
                    b++;
                }
                c++;
            }
            int s = middle - a;
            for (int i = 0; i <= s; i++) {
                data[c + i] = temp[a +i];
            }
        }

            public void sort(int data[], int left, int right) {
                if (left < right) {
                    int middle = (left + right) / 2;
                    sort(data, left, middle);
                    sort(data, middle + 1, right);
                    merge(data, left, middle, right);
                }
            }

            public void printArray(int arr[]) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

        public static void main(String[] args) {
            int data[] = {10, 40, 30, 50, 70, 20, 100, 90};
            System.out.println("sorting dengan merge sort");
            MergeSorting21 mSort = new MergeSorting21();
            System.out.println("data awal");
            mSort.printArray(data);
            mSort.mergeSort(data);
            System.out.println("setelah diurutkan : ");
            mSort.printArray(data);
    }
}
