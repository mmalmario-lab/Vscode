#include <iostream>
using namespace std;

int main()
{
    int arr[7];
    int temp;
    int swapCount = 0;

    cout << "Enter 7 Integers: \n";
    for (int i = 0; i < 7; i++)
    {
        cin >> arr[i];
    }

    for (int i = 0; i < 7; i++)
    {
        for (int j = 0; j < 7-1; j++)
        {
            if (arr[j] > arr[j + 1])
            {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapCount++;
            }
        }
    }
    cout << "\nSorted numbers (ascending order): \n";
    for (int i = 0; i < 7; i++)
    {
        cout << arr[i] << endl;
    }
    cout << "Swaps were performed: " << swapCount <<endl;
    if(swapCount == 0){
        cout << "The array is already sorted";
    }
}