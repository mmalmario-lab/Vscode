#include <iostream>
#include <stack>
using namespace std;

int main() {
    stack<int> s;
    s.push(1);
    s.push(2);
    s.push(3);
    cout << "Top element: " << s.top() << endl; // Output: 3
    s.pop();
    cout << "Top element after pop: " << s.top() << endl; // Output: 2
    cout << "Stack size: " << s.size() << endl; // Output: 2
    return 0;
}