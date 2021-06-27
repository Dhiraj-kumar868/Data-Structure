
#include<stdio.h>
#include<stdlib.h>
struct node
{
    int data;
    struct node *next;
};
struct node *head, *p;
void createlist()
{
    int k, n;
    printf ("Number of nodes: ");
    scanf ("%d", &n);
    for (k=0; k<n; k++)
    {
        if (k == 0)
        {
            head = (struct node *) malloc(sizeof(struct node));
            p = head;
        }
        else
        {
            p->next = (struct node *) malloc(sizeof(struct node));
            p = p->next;
        }
        printf("Enter value to node: ",k+1);
        scanf ("%d", &p->data);
    }
    p->next = head;
}
void display()
{
    if(head == NULL)
    {
        printf("\nEmpty List...\n");
        return;
    }
    p = head;
    do
    {
        printf (" %d ", p->data);
        p = p->next;
    }while (p->next != head);
    printf (" %d ", p->data);
    printf ("\n");
}
void insertAtBeginning()
{
    struct node* newNode = (struct node*) malloc(sizeof(struct node));
    printf("Enter the new data: ");
    scanf("%d", &newNode->data);
    p=head;
     do
    {
        p = p->next;
    }while (p->next != head);
    printf (" %d ", p->data);
    newNode->next = head;
    p->next=newNode;
    head = newNode;


}
void insertAtEnd()
{
    struct node* prev;
    struct node* newNode = (struct node*) malloc(sizeof(struct node));
    printf("Enter the new data: ");
    scanf("%d", &newNode->data);
    newNode->next = NULL;
    prev = head;
    if (prev == NULL)
    {
        head = newNode;
        return;
    }
    while (prev->next != head)
        prev = prev->next;
    prev->next = newNode;
    newNode->next=head;
}
void insertAtPos()
{
    int pos, i, nodes=0;
    struct node *newNode, *prev;
    struct node* curr=head;
    do
    {
        nodes++;
        curr=curr->next;
    }while(curr->next != head);
    nodes++;
    printf("\nEnter the position: ");
    scanf("%d", &pos);
    if(pos < 1 || pos > nodes)
    {
        printf("Invalid Input...");
        return;
    }
    newNode =(struct node*) malloc(sizeof(struct node));
    printf("\nEnter the new data: ");
    scanf("%d", &newNode->data);
    if(pos==1)
    {
      insertAtBeginning();
      return;
    }
    i = 1;
    curr = head;
    while(i<pos)
    {
        i++;
        prev = curr;
        curr = curr->next;
    }
    newNode->next = prev->next;
    prev->next = newNode;
}
void insertAfter()
{
    int value;
    printf("Enter the value after which you want to enter data: ");
    scanf("%d",&value);
     struct node *node = (struct node *)malloc(sizeof(struct node));

    printf("\nEnter the data to the node : ");
    scanf("%d",&node->data);
    struct node *ptr=head;
    if(ptr->data==value)
    {
        ptr=ptr->next;
        head->next=node;
        node->next=ptr;
        return;
    }
    p=head;
    ptr=ptr->next;
    while(ptr!=head && ptr->data!=value)
    {
        ptr=ptr->next;
    }
    if(ptr==NULL)
    {
        printf("%d is not present in the list.\n",value);
        return;
    }


    node->next = ptr->next;
    ptr->next=node;

}

void deleteAtBeginning()
{
    struct node *tmp,*prev;
    tmp=head;
    do
    {
        prev=tmp;
        tmp=tmp->next;
    }while(tmp!=head);
    p = head;
    prev->next=p->next;
    head = p->next;
    free(p);
}

void deleteAtEnd()
{
    struct node *prev;
    p = head;
    while(p->next != head)
    {
        prev = p;
        p = p->next;
    }
    free(p);
    prev->next = head;
}

int countnode()
{
    int len = 1;
    p = head;
    p=p->next;
    while (p!=head)
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
    struct node *prev;
    printf("Enter the position of node you want to delete : ");
    scanf("%d",&pos);
    if(pos>len && pos<1)
    {
        printf("Invalid position...\n");
        return;
    }
    p = head;
    prev=head;
    if(pos==1)
    {
      deleteAtBeginning();
      return;
    }
    p=p->next;
    for(int i=1;i<pos-1 && p!=head;i++)
    {
        prev=p;
        p=p->next;
    }
    prev->next = p->next;
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
                printf("Number of node = %d\n",countnode());
                break;
            case 11:
            	exit(0);
            default:
                printf("Wrong Choice..!!");
                printf("\n");
        }
    } while (ch);
    return(0);
}

