#include<iostream>
#include<fstream>
#include<cstdlib>
#include<ctime>
using namespace std;

int main()
{
    int Size,i,j,k,l,m,Temp;
    ifstream Access;
    Access.open("Input_1000000.txt");
    Access>>Size;
    ofstream Show;
    srand(98565465965);
    Show<<endl;
    Show.open("Input_1000000.txt",ios::app);
    for(i=0;i<1000000;i++)
    {
        Show << rand() <<"\n";
    }
    Show.close();

    int *Array = new int [Size];
    for(i=0;i<Size;i++)
    {
        Access>>Array[i];
    }
    clock_t starTime=clock();//TimeStart
    for(j=0;j<Size;j++)
    {
        for(k=0;k<(Size-j-1);k++)
        {
            if(Array[k]>Array[k+1])
            {
                Temp=Array[k];
                Array[k]=Array[k+1];
                Array[k+1]=Temp;
            }

        }
    }
    clock_t endTime=clock();//EndTime
    double timeLapse=double(endTime-starTime)/CLOCKS_PER_SEC;//CountTime

    ofstream Print;
    Print.open("Output_1000000.txt");

    for(l=0;l<Size;l++)
    {
        Print<<Array[l]<<"\n";
    }
    cout <<"\n\nTime  : "<< timeLapse<< endl;
    delete []Array;

    return 0;
}
