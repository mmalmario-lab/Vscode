#include <iostream>
using namespace std;

void merge(int arr[], int l, int m, int r) {
    int i = l, j = m + 1;
    int temp[10], k = l;

    while (i <= m && j <= r) {
        if (arr[i] < arr[j])
            temp[k++] = arr[i++];
        else
            temp[k++] = arr[j++];
    }

    while (i <= m)
        temp[k++] = arr[i++];

    while (j <= r)
        temp[k++] = arr[j++];

    for (int x = l; x <= r; x++)
        arr[x] = temp[x];
}

void mergeSort(int arr[], int l, int r) {
    if (l < r) {
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }
}

int main() {
    int arr[] = {25,10,40,5,30};
    int n = 4;

    mergeSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++)
        cout << arr[i] << " ";
}