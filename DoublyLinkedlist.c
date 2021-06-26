
#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next,*prev;
};
struct node *head, *p;
void createlist()
{
    int i, n;
    printf ("Number of nodes: ");
    scanf ("%d", &n);
    for (i=0; i<n; i++)
    {
        if (i == 0)
        {
            head = (struct node *) malloc(sizeof(struct node));
            p = head;
            p->prev=NULL;
        }
        else
        {
            p->next = (struct node *) malloc(sizeof(struct node));
            p->next->prev=p;
            p = p->next;
        }
        printf("Enter value to node %d: ",i+1);
        scanf ("%d", &p->data);
    }
    p->next = NULL;
}
void display()
{
    if(head == NULL)
    {
        printf("\nEmpty List...\n");
        return;
    }
    p = head;
    while (p != NULL)
    {
        printf (" %d ", p->data);
        p = p->next;
    }
    printf ("\n");
}
void insertAtBeginning()
{
    struct node* tmp = (struct node*) malloc(sizeof(struct node));
    printf("Enter the new data: ");
    scanf("%d", &tmp->data);
    tmp->next = head;
    head->prev=tmp;
    tmp->prev=NULL;
    head = tmp;
}
void insertAtEnd()
{
    struct node* tmp = (struct node*) malloc(sizeof(struct node));
    printf("Enter the new data: ");
    scanf("%d", &tmp->data);
    p=head;
    tmp->next = NULL;
    if (p == NULL)
    {
        tmp->prev=NULL;
        head = tmp;
        return;
    }
    while (p->next != NULL)
        p = p->next;
    p->next = tmp;
    tmp->prev=p;


}
void insertAtPos()
{
    int pos, i;
    struct node *tmp;
    tmp=(struct node*)malloc(sizeof(struct node));
    printf("\nEnter the position: ");
    scanf("%d", &pos);
    printf("\nEnter the new data: ");
    scanf("%d", &tmp->data);
    if(pos==1)
     {
         tmp->next=head;
         tmp->prev=NULL;
         head=tmp;
     }
     p=head;
     for(i=1;i<pos-1 && p!=NULL;i++)
        p=p->next;
     if(p==NULL)
     {
         printf("There are less than %d elements\n",pos);
     }
     else
     {
         tmp->next=p->next;
         tmp->prev=p;
         p->next=tmp;
     }
}
void insertAfter()
{
    int value,newvalue;
    printf("Enter the value after which you want to enter data: ");
    scanf("%d",&value);
     printf("Enter the new value  : ");
    scanf("%d",&newvalue);
     struct node *tmp;
     tmp=(struct node*)malloc(sizeof(struct node));
     tmp->data=newvalue;
     p=head;
     while(p!=NULL)
     {
         if(p->data==value)
         {
             tmp->next=p->next;
             tmp->prev=p;
             p->next=tmp;
         }
         p=p->next;
     }

}

void deleteAtBeginning()
{
    p = head;
    head = p->next;
    head->prev=NULL;
    free(p);
}

void deleteAtEnd()
{
    struct node *tmp;
    p = head;
    while(p->next != NULL)
    {
        tmp = p;
        p = p->next;
    }
    free(p);
    tmp->next = NULL;
}

int countnode()
{
    int len = 0;
    p = head;
    while (p!=NULL)
    {
        len++;
        p = p->next;
    }
    return len;
}

void deleteAtPos()
{
    int pos,len;
    len = countnode();
    struct node *tmp;
    printf("Enter the position of node you want to delete : ");
    scanf("%d",&pos);
    if(pos>len && pos<1)
    {
        printf("Invalid position...\n");
        return;
    }
    p = head;
    for(int i=1;i<pos && p!=NULL;i++)
    {
        tmp=p;
        p=p->next;
    }
    tmp->next = p->next;
    p->next->prev=tmp;
    free(p);
}



int main()
{
    int ch=1,n;
    do
    {
        printf("Enter what operation you want to perform\n");
        printf("1-To create linked list\n");
        printf("2-To display the list\n");
        printf("3-To insert node at beginning\n");
        printf("4-To insert node at end\n");
        printf("5-To insert node at specific position\n");
        printf("6-To insert after given value\n");
        printf("7-To delete at beginning\n");
        printf("8-To delete at end\n");
        printf("9-To delete at specific position\n");
        printf("10-To count number of node in the list\n");
        printf("11-Exit\n");
        printf("Enter your choice:");
        scanf("%d",&n);

        switch (n)
        {
            case 1:
                createlist();
                break;
            case 2:
                display();
                break;
            case 3:
                insertAtBeginning();
                break;
            case 4:
                insertAtEnd();
                break;
            case 5:
                insertAtPos();
                break;
            case 6:
                insertAfter();
                break;
            case 7:
                deleteAtBeginning();
                break;
            case 8:
                deleteAtEnd();
                break;
            case 9:
                deleteAtPos();
                break;
            case 10:
                printf("Number of node = %d",countnode());
                printf("\n");
                break;
            case 11:
            	exit(0);
            default:
                printf("Wrong Choice..!!");
        }
    } while (ch);
}

