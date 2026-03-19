#include <iostream>
#include <queue>
using namespace std;

int main()
{
    priority_queue<pair<int, string>> pq;

    for (int i = 0; i < 5; i++)
    {
        cout << "Enter patient name: ";
        string name;
        cin >> name;

        cout << "Enter patient priority (1-9): ";
        int priority;
        cin >> priority;

        pq.push({priority, name}); // store together
    }

    cout << "\nTreating order highest to lowest:\n";
    
    // Copy for later use
    priority_queue<pair<int, string>> temp = pq;

    while (!temp.empty())
    {
        cout << temp.top().second << " - " << temp.top().first << endl;
        temp.pop();
    }

    cout << "\nPatient temporarily left:\n";
    
    while (!pq.empty())
    {
        if (pq.top().first < 3)
        {
            cout << pq.top().second << endl;
        }
        pq.pop();
    }

    return 0;
}