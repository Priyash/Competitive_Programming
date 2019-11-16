/**
 * Heap_Sort
 */
public class Heap_Sort {

    private int arr[];

    public Heap_Sort(int arraySize){
        arr = new int[arraySize];
    }

    private void swap(int arr[],int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void heapify(int arr[], int n, int index){
        int largest = index;
        int left_child = 2*index + 1;
        int right_child = 2*index + 2;

        if(left_child < n && arr[largest] < arr[left_child]){
            largest = left_child;
        }
        
        if(right_child < n && arr[largest] < arr[right_child]){
            largest = right_child;
        }


        if(largest != index){
            this.swap(arr, largest, index);
            this.heapify(arr, n, largest);
        }

    }

    public void build_max_heap(int arr[], int n){
        for (int i = n / 2 - 1; i >= 0; i--) {
            this.heapify(arr, n, i);
        }
    }

    public int extract_max(int arr[], int n, int k){
        int max = arr[0];
        for (int i = n - 1; i >= k; i--) {
            this.swap(arr, 0, i);
            this.heapify(arr, i, 0);
            max = arr[0];
        }
        return max;
    }

    public int extract_k_largest_elements(int arr[], int n, int k){
        this.build_max_heap(arr, n);
        int max = 0;
        for (int i = n - 1; i >= n - k; i--) {
            //System.out.println("Max " + arr[0]);
            max = arr[0];
            this.swap(arr, 0, i);
            this.heapify(arr, i, 0);
        }
        return max;
    }

    public void sort(int arr[], int n){

        this.build_max_heap(arr, n);
        for(int i = n - 1; i >= 0; i--){
            this.swap(arr, 0, i);
            this.heapify(arr, i, 0);
        }
    }

    public void print_array(int arr[], int n){
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + ", " + '\t');
        }
    }

    public static void main(String[] args) {
        int arr[] = {121, 10, 130, 57, 36, 17};
        int n = arr.length;
        Heap_Sort heap_Sort = new Heap_Sort(n);
        // heap_Sort.sort(arr, n);
        // heap_Sort.print_array(arr, n);
        int k_largest_element = heap_Sort.extract_k_largest_elements(arr, n, 4);
        System.out.println(k_largest_element);
        
    }

}
