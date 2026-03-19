#include <iostream>
#include <queue>
#include <stack>
using namespace std;

int main()
{
    queue<string> nameQueue;
    queue<int> classQueue;

    for (int i = 0; i < 5; i++)
    {
        string name;
        int ticketClass;

        cout << "Enter passenger name: ";
        cin >> name;

        cout << "Enter ticket class (1-3): ";
        cin >> ticketClass;

        nameQueue.push(name);
        classQueue.push(ticketClass);
    }

    priority_queue<pair<int,string>> boardingQueue;
    stack<string> waitingStack;

    while (!nameQueue.empty())
    {
        string name = nameQueue.front();
        int cls = classQueue.front();

        nameQueue.pop();
        classQueue.pop();

        if (cls == 1) 
        {
            waitingStack.push(name);
        }
        else
        {
            boardingQueue.push({cls, name});
        }
    }

    cout << "\nBoarding order:\n";
    while (!boardingQueue.empty())
    {
        cout << boardingQueue.top().second 
             << " - Class " 
             << boardingQueue.top().first << endl;
        boardingQueue.pop();
    }
    cout << "\nWaiting passengers:\n";
    while (!waitingStack.empty())
    {
        cout << waitingStack.top() << endl;
        waitingStack.pop();
    }

    return 0;
}