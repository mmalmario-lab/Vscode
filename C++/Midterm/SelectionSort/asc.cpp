#include <iostream>
using namespace std;

int main() {
    int numArr[8];
    int temp;

    cout << "Enter 8 numbers: " << endl;
    for(int i = 0; i < 8; i++) {
        cin >> numArr[i];
    }

    cout << "\n--- Selection Sort Visualization (Ascending Order) ---\n";
    cout << "Original array: ";
    for(int i = 0; i < 8; i++) cout << numArr[i] << " ";
    cout << endl << endl;

    // Selection Sort - ASCENDING ORDER
    for(int i = 0; i < 7; i++) {           
        int minIndex = i;   // Assume current position i has the smallest
        
        // Find the smallest element in the unsorted part
        for(int j = i + 1; j < 8; j++) {
            if(numArr[j] < numArr[minIndex]) {
                minIndex = j;
            }
        }
        
        // Swap only if we found a smaller one
        if(minIndex != i) {
            temp = numArr[i];
            numArr[i] = numArr[minIndex];
            numArr[minIndex] = temp;
        }

        // Show the array after each pass
        cout << "After pass " << (i + 1) << " (position " << i << " is now fixed): ";
        for(int k = 0; k < 8; k++) {
            cout << numArr[k] << " ";
        }
        cout << endl;
    }

    cout << "\nFinal Sorted array (ascending):\n";
    for(int i = 0; i < 8; i++) {
        cout << numArr[i] << endl;
    }

    return 0;
}