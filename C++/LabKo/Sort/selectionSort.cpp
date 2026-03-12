#include <iostream>
using namespace std;

int main(){
    
    int arr[8];
    
    cout << "Enter 8 Integers: \n";
    for (int i = 0; i < 8; i++)
    {
        cin >> arr[i];
    }
    for (int i = 0; i < 8; i++) {
        int min = i;
        for (int j = i + 1; j < 8; j++) {
            if (arr[j] > arr[min]) {
                min = j;
            }
        }
        swap(arr[i], arr[min]);
    }
    
    cout << "\nSorted numbers (descending order): \n";
    for (int i = 0; i < 8; ++i) {
        cout << arr[i] << endl;
    }
    
    int secondLargest = arr[1];
    cout << "Second Largest Number:" << secondLargest;
    return 0;
}
