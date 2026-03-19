#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int main()
{
    queue<string> nameQueue;
    queue<int> urgencyLevelQueue;

    for (int i = 0; i < 5; i++)
    {
        cout << "Enter student name: ";
        string name;
        cin >> name;
        nameQueue.push(name);

        cout << "Enter book urgency level (1-10): ";
        int urgencyLevel;
        cin >> urgencyLevel;
        urgencyLevelQueue.push(urgencyLevel);
    }

    priority_queue<string> namePq;
    priority_queue<int> urgencyLevelPq;
    stack<string> tempStackName;
    stack<int> tempStackSeclevel;

    while (!nameQueue.empty())
    {
        if (urgencyLevelQueue.front()  < 4)
        {
            tempStackName.push(nameQueue.front());
            nameQueue.pop();
            urgencyLevelQueue.pop();
        }
        else
        {
            namePq.push(nameQueue.front());
            urgencyLevelPq.push(urgencyLevelQueue.front());
            nameQueue.pop();
            urgencyLevelQueue.pop();
        }
    }

    priority_queue<string> tempPqName = namePq;
    priority_queue<int> tempPqSeclevel = urgencyLevelPq;

    cout << "Treating order highest to lowest: " << endl;
    while (!tempPqName.empty())
    {
        cout << tempPqName.top() << " - " << tempPqSeclevel.top() << endl;
        tempPqName.pop();
        tempPqSeclevel.pop();
    }
   
    cout << "Student who will borrow books later: " << endl;
    while (!tempStackName.empty())
    {
        cout << tempStackName.top() << endl;
        tempStackName.pop();
    }
}