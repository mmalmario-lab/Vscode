#include <iostream>
using namespace std;

int main(){

    int array[] = {7, 12, 9, 4, 11};
    int minVal = array[0];    //Step 1

    for(int i : array) {    // Step 2
        if(i < minVal) {      // Step 3
            minVal = i;
        }
    }       
    cout << "Lowest value: " << minVal << endl; // Step 4
}