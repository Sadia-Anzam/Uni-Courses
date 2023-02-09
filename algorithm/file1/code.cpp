#include<iostream>
#include<fstream>

using namespace std;

int main(){
 int k,i,size1;
ifstream input;
input.open("input.txt");
input>>size1;
cout<<"the size:";
    cout<<size1;
    int *arrayy=new int [size1];

        for(k=0; k<size1; k++)
    {
        input>>arrayy[k];
    }

    cout<<"\nthe values of array:";


ofstream output;
output.open("output.txt");
output<<"1D array:";
for(i=0; i<size1; i++)
    {
        output<<arrayy[i];

    }


return 0;
}
