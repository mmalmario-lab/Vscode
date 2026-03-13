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
    Node* fourth = new Node();

    first->data = 1;
    first->prev = NULL;
    first->next = second;

    second->data = 2;
    second->prev = first;
    second->next = third;

    third->data = 3;
    third->prev = second;
    third->next = fourth;

    fourth->data = 4;
    fourth->prev = third;
    fourth->next = NULL;

    Node* head = first;
    Node* temp = NULL;
    Node* current = head;

    while(current != NULL){
        temp = current->prev;
        current->prev = current->next;
        current->next = temp;

        current = current->prev;
    }

    if(temp != NULL)
        head = temp->prev;

    Node* ptr = head;

    while(ptr != NULL){
        cout << ptr->data << " <-> ";
        ptr = ptr->next;
    }

    return 0;
}