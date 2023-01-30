#include <stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/wait.h> 
#include<sys/types.h>

int main() {

  int *p,num,i,j,temp,count=0;

  pid_t pid;

  printf("Enter number of elements: ");
    scanf("%d", &num);

    p = (int*) calloc(num, sizeof(int));
    if(p == NULL)
    {
        printf("Error! memory not allocated.");
        exit(0);
    }

    printf("Elements entered: \n");
    for(i=0;i<num;i++)
     scanf("%d,",&p[i]);

  printf("\n");

  /* fork a child process */
  pid = fork();
  if (pid < 0) { /* error occurred */
   fprintf(stderr, "Fork Failed\n");
   return 1;
  }
  else if (pid == 0) { /* child process */
   printf("Child is producing the bubble sorted number...\n");
   for(i=0;i<num;i++)
   {
     for (j=0;j<num-1;j++)
      {
        if (p[j] > p[j+1])
          {
            temp=p[j];
            p[j]=p[j+1];
            p[j+1]=temp;
          }
      }
   }
   //printing the sorted list 
 
  printf("\nSorted list in ascending order:\n");
  for ( i = 0 ; i < num ; i++ )
    printf("%d,", p[i]);

    printf("\n");
  }
  else { /* parent process */
  /* parent will wait for the child to complete */
   printf("Parent is waiting for child to complete..\n");
   wait(NULL);
   printf("\nChild Complete....\nparent ends....\n");
  }
  free(p);
  return 0;
}