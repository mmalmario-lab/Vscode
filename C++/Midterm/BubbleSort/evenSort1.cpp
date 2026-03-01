#include <iostream>
using namespace std;

int main() {
    int Size;
    cout << "Enter an integer(Max: 10): ";
    cin >> Size;
    
    int numArr[Size];
    for(int i = 0; i < Size; i++) {
        cin >> numArr[i];
    }        

    // Selection sort only on even numbers
    for(int i = 0; i < Size; i++) {
        if(numArr[i] % 2 != 0) continue;   // skip odds

        // Find the smallest even number from here to the end
        int minIdx = i;
        for(int j = i + 1; j < Size; j++) {
            if(numArr[j] % 2 == 0 && numArr[j] < numArr[minIdx]) {
                minIdx = j;
            }
        }
        // Swap if needed
        if(minIdx != i) {
            int temp = numArr[i];
            numArr[i] = numArr[minIdx];
            numArr[minIdx] = temp;
        }
    }

    cout << "\nSorted array (only evens ascending, odds stay in place):\n";
    for(int i = 0; i < Size; i++) {
        cout << numArr[i] << endl;
    }

    return 0;
}