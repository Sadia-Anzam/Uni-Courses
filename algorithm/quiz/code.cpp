#include<iostream>
using namespace std;
#define INF 9999

int minCoins(int values[],int n,int target) {

   int change[target+1];
   change[0] = 0;
   int i,j;
   for(j=1;j<=target;j++) {
      int min = INF;

      for(i=0;i<n;i++) {
         if(j>=values[i] && (change[j-values[i]]+1) < min)
            min = change[j-values[i]]+1;
      }

      change[j] = min;
   }
   return change[target];
}
int main() {
   int values[] = {1,2,5,9};
   int n = sizeof(values)/sizeof(values[0]);
   int target = 13;
   int min = minCoins(values,n,target);
   cout<<"\nMin no. of coins required :: "<<min;
   cout<<endl;
}
