#include <iostream>
using namespace std;

struct Node {
    int data;
    Node* prev;
    Node* next;
};

int main() {

    Node* first = new Node();
    Node* second = new Node();
    Node* third = new Node();

    first->data = 10;
    first->prev = NULL;
    first->next = second;

    second->data = 20;
    second->prev = first;
    second->next = third;

    third->data = 30;
    third->prev = second;
    third->next = NULL;

    int value = 25;

    Node* newNode = new Node();
    newNode->data = value;

    Node* temp = first;

    while(temp->next != NULL && temp->next->data < value){
        temp = temp->next;
    }

    newNode->next = temp->next;
    newNode->prev = temp;

    if(temp->next != NULL)
        temp->next->prev = newNode;

    temp->next = newNode;

    Node* ptr = first;

    while(ptr != NULL){
        cout << ptr->data << " <-> ";
        ptr = ptr->next;
    }

    return 0;
}