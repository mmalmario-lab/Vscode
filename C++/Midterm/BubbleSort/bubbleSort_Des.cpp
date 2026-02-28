#include <iostream>
using namespace std;

int main() {
    int numArr[8];
    int temp;

    cout << "Enter 8 numbers: " << endl;
    for(int i = 0; i < 8; i++) {
        cin >> numArr[i];
    }

    // Bubble sort - DESCENDING ORDER (just flip the comparison!)
    for(int i = 0; i < 7; i++) {           
        for(int j = 0; j < 7 - i; j++) {   
            if(numArr[j] < numArr[j + 1]) {   // <-- CHANGED > to < for descending
                temp = numArr[j];
                numArr[j] = numArr[j + 1];
                numArr[j + 1] = temp;
            }
        }
    }

    cout << "\nSorted array (descending):\n";
    for(int i = 0; i < 8; i++) {
        cout << numArr[i] << endl;
    }

    return 0;
}