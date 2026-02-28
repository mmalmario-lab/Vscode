#include <iostream>
using namespace std;

int main() {

    int temp;
    int Size;
     // Assuming max size is 10
    int evenSize = 0;
    cout << "Enter an integer(Max: 10): " ;
    cin >> Size;
    
    int numArr[Size];
    for(int i = 0; i < Size; i++) {
        cin >> numArr[i];
        if(numArr[i] % 2 == 0) {
            evenSize++;
    }
    }

    // Bubble sort - ASCENDING ORDER (clean & efficient)
    int even[evenSize];
for(int i = 0; i < Size; i++) {   
     // Check if the number is even or odd  
        for(int j = 0; j < Size - 1; j++) { 
            
            if(numArr[i] % 2 == 0) {
                even[evenSize] = numArr[i];
            }
             if(numArr[j] > numArr[j + 1]) {   // <-- back to > for ascending
                    temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
                }
                else {
                    numArr[j] = numArr[j];
                }
            
        
    }
}

for(int i = 0; i < Size; i++) {   
     // Check if the number is even or odd  
        for(int j = 0; j < Size - 1; j++) { 
            if(even[j] > even[j + 1]) {   // <-- back to > for ascending
                temp = even[j];
                even[j] = even[j + 1];
                even[j + 1] = temp;

                
            } 
            if(numArr[j] % 2 == 0) {   // <-- back to > for ascending
                    temp = numArr[j];
                    numArr[j] = even[j];
                    even[j] = temp;
                }     
    }
}


    cout << "\nSorted array (ascending):\n";
    for(int i = 0; i < Size; i++) {
        cout << numArr[i] << endl;
    }
    return 0;
}