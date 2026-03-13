#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* next;
};

int main(){

    Node* first = new Node();
    Node* second = new Node();
    Node* third = new Node();
    Node* fourth = new Node();
    Node* fifth = new Node();

    first->data = 1;
    first->next = second;

    second->data = 2;
    second->next = third;

    third->data = 3;
    third->next = fourth;

    fourth->data = 4;
    fourth->next = fifth;

    fifth->data = 5;
    fifth->next = first;

    int k = 2;

    Node* ptr = first;
    Node* prev = NULL;

    while(ptr->next != ptr){

        for(int i = 1; i < k; i++){
            prev = ptr;
            ptr = ptr->next;
        }

        prev->next = ptr->next;
        delete ptr;

        ptr = prev->next;
    }

    cout << "Remaining node: " << ptr->data;

    return 0;
}