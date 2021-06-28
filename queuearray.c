#include<stdio.h>
#include<stdlib.h>
#define MAX 5
int q[MAX],front=-1,rear=-1;
void enqueue()
{
    int data;
    if(rear==MAX-1)
    {
        printf("Queue is full.\n");
    }
    else
    {
       if(front==-1)
       {
           front=0;
       }
       printf("Enter element:");
       scanf("%d",&data);
       rear++;
       q[rear]=data;
    }
}
void dequeue()
{
    if(front==-1 || front>rear)
    {
        printf("Queue is empty.\n");
    }
    else
    {
      front++;
    }
    
}
void display()
{
    int i;
    if(front==-1)
    {
        printf("Queue is empty.\n");
    }
    else
    {
      printf("Elements: ");
      for(i=front;i<=rear;i++)
      {
          printf("\n%d",q[i]);
      }
    }
  printf("\n\n");  
}
void isempty()
{
     if(front==-1 || rear==-1)
    {
        printf("Queue is empty.\n");
    }
     else
    {
      printf("Queue is not empty.\n");  
    }
}
void isfull()
{
   if(rear==MAX-1)
    {
        printf("Queue is full.\n");
    } 
    else
    {
      printf("Queue is not full.\n");  
    }
    
}
int main()
{
    int ch;
    while(1)
    {
        printf("\n1-To enqueue");
        printf("\n2-To dequeue");
        printf("\n3-To display");
        printf("\n4-To check queue is empty or not");
        printf("\n5-To check queue is full or not");
        printf("\n6-To Exit");
        printf("\nEnter choice:");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:
               enqueue();
               break;
            case 2:
               dequeue();
               break;
            case 3:
               display();
               break;
            case 4:
               isempty();
               break;
            case 5:
               isfull();
               break;
            case 6:
               exit(0);
            default:
                printf("Wrong choice");               

        }
    }
    return(0);
}