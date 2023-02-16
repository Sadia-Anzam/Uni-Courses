#include<iostream>
#include<fstream>
#include<queue>

using namespace std;

void print(int srV, int quV, int par[])
{
    if(srV==quV)
    {
        cout<<quV<<"->";
    }
    else if(par[quV]==-1)
    {
        cout<<"no path";
    }
    else
    {
        print(srV,par[quV],par);
        cout<<quV<<"->";
    }
}

int main()
{
    int v,e;
    ifstream read;

    read.open("input.txt");
    //cout<<"Enter the vertex and edges:";
    read>>v>>e;

    int** graph= new int*[v];

    for(int i=0; i<v; i++)
    {
        graph[i]= new int[v];
    }

    for(int i=0; i<v; i++)
    {
        for(int j=0; j<v; j++)
        {
            read>>graph[i][j];
        }
    }

    int sr,ds;
    cout<<"Enter source and destination:";
    cin>>sr>>ds;

    int* vs= new int[v];
    int* par= new int[v];

    queue<int>bfs;
    vs[sr]=1;
    par[sr]=-1;

    bfs.push(sr);
    while(!bfs.empty())
    {
        int de=bfs.front();
        bfs.pop();
        for(int i=0; i<v; i++)
        {
            if(graph[de][i]==1)
            {
                if(vs[i]=0)
                {
                    bfs.push(i);
                    vs[i]=1;
                    par[i]=de;

                }
            }
        }
        vs[de]=2;
    }

    cout<<"Shortest path:\n";
    print(sr,ds,par);

    return 0;

}
