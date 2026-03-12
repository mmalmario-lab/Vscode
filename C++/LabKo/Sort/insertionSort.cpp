#include <iostream>
using namespace std;

int main() {
    
    int arr[8];
    int sizeToRemove = 1;
    int remove[sizeToRemove];
    
    cout << "Enter 8 Integers: \n";
    for (int i = 0; i < 8; i++)
    {
        cin >> arr[i];
    }    
    
    for (int i = 1; i < 8; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;
    }
    cout << "\nSorted numbers (ascending order): \n";
    
    
    for (int i = 0; i < 8; i++) {
        cout << arr[i] << endl;
    }
    
   cout << "\nSorted numbers (ascending order): \n";
    cout << "Newlist: \n";
    for (int i = 0; i < 8; i++) {
           if(arr[i] == arr[i+1]){
               //remove[i] = arr[i+1];
               //sizeToRemove++;
               continue;
           }
            else{
             cout << arr[i] << endl;
            }
        
    }  
    return 0;
}
