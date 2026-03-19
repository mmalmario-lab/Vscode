#include <iostream>
#include <queue>
using namespace std;

int main()
{
    // Step 1: Normal queue (FIFO)
    queue<pair<string, int>> q;

    // Input
    for (int i = 0; i < 5; i++)
    {
        string name;
        int priority;

        cout << "Enter patient name: ";
        cin >> name;

        cout << "Enter patient priority (1-9): ";
        cin >> priority;

        q.push({name, priority}); // store together
    }

    // Step 2: Priority queue (highest priority first)
    priority_queue<pair<int, string>> pq;

    // Transfer from queue → priority queue
    while (!q.empty())
    {
        pair<string, int> temp = q.front();
        q.pop();

        pq.push({temp.second, temp.first}); // (priority, name)
    }

    // Step 3: Display treating order
    cout << "\nTreating order (highest to lowest):\n";
    priority_queue<pair<int, string>> copy = pq;

    while (!copy.empty())
    {
        cout << copy.top().second << " - " << copy.top().first << endl;
        copy.pop();
    }

    // Step 4: Patients who left (priority < 3)
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