#include <iostream>
using namespace std;

int main() {
    int numArr[8];
    int sum = 0;
    int temp;

    cout << "Enter 8 numbers: " << endl;
    for(int i = 0; i < 8; i++) {
        cin >> numArr[i];
        sum += numArr[i];
    }

    // Bubble sort (your original logic works, just cleaned up a bit)
    for(int i = 0; i < 7; i++) {           // only need 7 passes for 8 elements
        for(int j = 0; j < 7 - i; j++) {   // inner loop shrinks each pass (more efficient)
            if(numArr[j] > numArr[j + 1]) {
                temp = numArr[j];
                numArr[j] = numArr[j + 1];
                numArr[j + 1] = temp;
            }
        }
    }

    // After sorting, min and max are easy!
    int lowestNum  = numArr[0];
    int highestNum = numArr[7];

    cout << "\nSorted array:\n";
    for(int i = 0; i < 8; i++) {
        cout << numArr[i] << endl;
    }

    int average = sum / 8;                    // integer division (truncates)
    // If you want floating-point average:
    // double average = static_cast<double>(sum) / 8;

    cout << "\nAverage: " << average << endl;
    cout << "Highest number: " << highestNum << endl;
    cout << "Lowest number: " << lowestNum << endl;

    return 0;
}