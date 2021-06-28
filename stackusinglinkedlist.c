#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *link;
};
struct node *top=NULL;
void isempty()
{
    if(top==NULL)
    {
        printf("Stack is empty.\n");
    }
    else
    {
        printf("Stack is not empty.\n");
    }
    
}
void push()
{
    int n,value;
  struct node *newnode;
  printf("Enter the number value to be pushed: ");
  scanf("%d",&n);
  for(int i=0;i<n;i++)
  {
    newnode=(struct node*)malloc(sizeof(struct node));
    printf("Enter the %d value to be pushed: ",i+1);
    scanf("%d",&value);
    newnode->data=value;
    newnode->link=top;
    top=newnode;
  }
}
void display()
{
    struct node *tmp;
    tmp=top;
    if(top==NULL)
    {
        printf("Stack is empty.\n");
    }
    else
    {
      while(tmp!=NULL)
      {
          printf("%d\n ",tmp->data);
          tmp=tmp->link;
      }
    }  
}
void pop()
{
    struct node *tmp;
    tmp=top;
    if(top==NULL)
    {
        printf("Stack is empty.\n");
    }
    else
    {
        printf("popped element is %d\n",top->data);
        top=top->link;
        tmp->link=NULL;
        free(tmp);
    }
    
}
int main()
{
    int ch;
    while(1)
    {
        printf("1-To check if the stack is empty.\n");
        printf("2-To push.\n");
        printf("3-To pop.\n");
        printf("4-To display the contents of stack.\n");
        printf("5-To Exit.\n");
        printf("Enter the choice: ");
        scanf("%d",&ch);
        switch(ch)
        {
            case 1:
                  isempty();
                  break;
            case 2:
                   push();
                   break;
            case 3:
                  pop();
                  break;
            case 4:
                  display();
                  break;
            case 5:
                  exit(0);
                  break;
            default:
                  printf("Wrong choice.\n");                                   
        }
    }
    return(0);
}