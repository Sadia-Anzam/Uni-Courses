#include <iostream>
#include <fstream>
using namespace std;

int main()
{
    int row,column;
    ifstream fileInput;
    fileInput.open("input.txt");
    fileInput>>row>>column;

    cout << "Row :" << row<< "\nColumn : " << column<< endl;

    int **array;
    array=new int *[row];
    for (int i=0;i<row;i++)
    {
        array[i]=new int [column];
    }

    for(int i=0;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {
            fileInput>>array[i][j];
        }
    }
    cout<<endl<<"Output : "<<endl;
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {
            cout<<array[i][j]<<" ";
        }
        cout<<endl;
    }

    ofstream fileOutput;
    fileOutput.open("output.txt",ios::app);
    fileOutput<<endl<<"New Output : \n";
    for(int i=0;i<row;i++)
    {
        for(int j=0;j<column;j++)
        {
            fileOutput<<array[i][j]*2<<" ";
        }
        fileOutput<<endl;
    }
    return 0;
}
