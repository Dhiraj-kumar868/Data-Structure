#include<stdio.h>
#include<stdlib.h>
#define MAX 5
int a[MAX],top=-1;
void isempty()
{
    if(top==-1)
    {
       printf("stack is empty.\n"); 
    }
    else
    {
       printf("Stack is not empty.\n");
    }
    
}
void push()
{
    int data,n;
    if(top==MAX-1)
    {
        printf("\nstack is full.\n");
    }
    printf("Enter the number of element you want to push:");
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    {
        printf("Enter the %d element to be pushed: ",i+1);
        scanf("%d",&data);
        top++;
        a[top]=data;
    }
}
void pop()
{
    if(top==-1)
    {
        printf("stack is empty.\n");
    }
    else
    {
      printf("Popped element: %d\n",a[top]);
      top--;
    }
    
}
void display()
{
    int i;
    if(top>=0)
    {
        printf("Elements: ");
        for(i=top;i>=0;i--)
        {
            printf("\n%d\n",a[i]);
        }
        printf("\n");
    }
    else
    {
      printf("Stack is empty.\n");
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