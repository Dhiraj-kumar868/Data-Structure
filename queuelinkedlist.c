#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};
struct node *front=NULL,*rear=NULL;
void enqueue()
{
    int x;
    struct node *newnode;
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("Enter element:");
    scanf("%d",&x);
    newnode->data=x;
    newnode->next=NULL;
    if(front==NULL && rear==NULL)
    {
       front=rear=newnode;
    }
    else
    {
      rear->next=newnode;
      rear=newnode;
    }
}
void dequeue()
{
    struct node *tmp;
    tmp=front;
    if(front==NULL || rear==NULL)
    {
        printf("Queue is empty.\n");
    }
    else
    {
        front=front->next;
        tmp->next=NULL;
        free(tmp);
    }
    
}
void display()
{
    struct node *tmp;
    if(front==NULL && rear==NULL)
    {
        printf("Queue is empty.\n");
    }
    else
    {
      tmp=front;
      printf("Elements: ");
      while(tmp!=NULL)
      {
         printf("\n%d",tmp->data);
         tmp=tmp->next;
      }
    }
    printf("\n\n");
    
}
void isempty()
{
     if(front==NULL || rear==NULL)
    {
        printf("Queue is empty.\n");
    }
     else
    {
      printf("Queue is not empty.\n");  
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
        printf("\n5-To Exit");
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
               exit(0);
            default:
                printf("Wrong choice");               

        }
    }
    return(0);
}