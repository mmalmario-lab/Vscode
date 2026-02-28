#include <iostream>
using namespace std;

int main() {
    int Size;
    cout << "Enter an integer(Max: 10): ";
    cin >> Size;
    
    int numArr[10];
    for(int i = 0; i < Size; i++) {
        cin >> numArr[i];
    }

    // Step 1: Save positions (indices) of all even numbers
    int evenIndex[10];
    int count = 0;
    for(int i = 0; i < Size; i++) {
        if(numArr[i] % 2 == 0) {
            evenIndex[count++] = i;
        }
    }

    // Step 2: Bubble sort ONLY using these positions (evens only!)
    for(int i = 0; i < count - 1; i++) {   
        bool swapped = false;
        for(int j = 0; j < count - 1 - i; j++) {           
            if(numArr[evenIndex[j]] > numArr[evenIndex[j + 1]]) {
                int temp = numArr[evenIndex[j]];
                numArr[evenIndex[j]] = numArr[evenIndex[j + 1]];
                numArr[evenIndex[j + 1]] = temp;
                swapped = true;
            }
        }
        if(!swapped) break;   // Early exit like you wanted
    }

    cout << "\nSorted array (only evens ascending, odds stay in place):\n";
    for(int i = 0; i < Size; i++) {
        cout << numArr[i] << endl;
    }

    return 0;
}