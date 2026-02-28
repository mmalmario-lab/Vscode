#include <iostream>
using namespace std;

int main() {
    int numArr[8];
    int temp;

    cout << "Enter 8 numbers: " << endl;
    for(int i = 0; i < 8; i++) {
        cin >> numArr[i];
    }

    // Bubble sort - ASCENDING ORDER (clean & efficient)
    for(int i = 0; i < 7; i++) {           
        for(int j = 0; j < 7 - i; j++) {   
            if(numArr[j] > numArr[j + 1]) {   // <-- back to > for ascending
                temp = numArr[j];
                numArr[j] = numArr[j + 1];
                numArr[j + 1] = temp;
            }
        }
    }

    cout << "\nSorted array (ascending):\n";
    for(int i = 0; i < 8; i++) {
        cout << numArr[i] << endl;
    }

    return 0;
}