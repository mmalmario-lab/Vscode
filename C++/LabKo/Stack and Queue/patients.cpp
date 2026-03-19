#include <iostream>
#include <queue>
#include <stack>
using namespace std;

int main()
{
    queue<string> qName;
    queue<int> qSeclevel;

    for (int i = 0; i < 5; i++)
    {
        cout << "Enter patient name: ";
        string name;
        cin >> name;

        cout << "Enter patient priority (1-9): ";
        int priority;
        cin >> priority;

        qName.push(name);
        qSeclevel.push(priority);
    }

    priority_queue<string> pqName;
    priority_queue<int> pqSeclevel;

    while (!qName.empty())
    {
        pqName.push(qName.front());
        pqSeclevel.push(qSeclevel.front());
        qName.pop();
        qSeclevel.pop();
    }
    
    priority_queue<string> tempPqName = pqName;
    priority_queue<int> tempPqSeclevel = pqSeclevel;
    
    cout << "Treating order highest to lowest: " << endl;
    while (!pqName.empty())
    {  
        cout << pqName.top() << " - " << pqSeclevel.top() << endl;
        pqName.pop();
        pqSeclevel.pop();
    }
   
    stack<string> tempStackName;
    stack<int> tempStackSeclevel;

    cout << "Patient temporarily left: " << endl;
    while (!tempPqName.empty())
    {   
        if(tempPqSeclevel.top() < 3){
            tempStackName.push(tempPqName.top());
            tempStackSeclevel.push(tempPqSeclevel.top());
        }
        tempPqSeclevel.pop();
        tempPqName.pop();

    }

    while (!tempStackName.empty())
    {
        cout << tempStackName.top() << endl;
        tempStackName.pop();
    }
    return 0;
}
