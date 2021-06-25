 #include<stdio.h>
 #include<stdlib.h>
 struct node
 {
     int info;
     struct node*link;
 } ;
 struct node *create(struct node*start,int data)
 {
     struct node*tmp,*p;
     tmp=(struct node*)malloc(sizeof(struct node));
     tmp->info=data;
     p=start;
     if(start==NULL)
     {
       tmp->link=NULL;
       start=tmp;
       return start;

     }
    while(p->link!=NULL)
    {
        p=p->link;
    }
    p->link=tmp;
    tmp->link=NULL;
    return start;
 };
 struct node *insertatstart(struct node*start,int data)
 {
     struct node*tmp;
     tmp=(struct node*)malloc(sizeof(struct node));
     tmp->info=data;
     tmp->link=start;
     start=tmp;
     return start;
 };
 struct node *insertatend(struct node*start,int data)
 {
     struct node*tmp,*p;
     tmp=(struct node*)malloc(sizeof(struct node));
     tmp->info=data;
     p=start;
     while(p->link!=NULL)
     {
         p=p->link;
     }
     p->link=tmp;
     tmp->link=NULL;
     return start;
 };
 struct node *insertatanyloc(struct node*start,int data,int pos)
 {
     int i;
     struct node*p,*tmp;
     tmp=(struct node*)malloc(sizeof(struct node));
     tmp->info=data;
     if(pos==1)
     {
         tmp->link=start;
         start=tmp;
         return start;
     }
     p=start;
     for(i=1;i<pos-1 && p!=NULL;i++)
        p=p->link;
     if(p==NULL)
     {
         printf("There are less than %d elements\n",pos);
     }
     else
     {
         tmp->link=p->link;
         p->link=tmp;
     }
     return start;
 };
 struct node *insertafterspecificelement(struct node*start,int data,int value)
 {
     struct node*p,*tmp;
     tmp=(struct node*)malloc(sizeof(struct node));
     tmp->info=data;
     p=start;
     while(p!=NULL)
     {
         if(p->info==value)
         {
             tmp->link=p->link;
             p->link=tmp;
         }
         p=p->link;
     }
     return start;
 };
 struct node *delatbeg(struct node *start)
 {
   struct node *tmp;
   if(start==NULL)
   {
       printf("List is empty\n");
       return start;
   }
   tmp=start;
   start=start->link;
   free(tmp);
   return start;
 };
 struct node *delatend(struct node *start)
 {
   struct node *tmp,*p;
   p=start;
  
   while(p->link!=NULL)
   {
       tmp=p;
       p=p->link;
   }
   tmp->link=NULL;
   free(p);
   return start;
 };
 struct node *delatanypos(struct node *start,int pos)
 {
   struct node *tmp,*p;
   p=start;
   if(start==NULL)
   {
       printf("List is empty\n");
       return start;
   }
   for(int i=2;i<pos && p!=NULL;i++)
   {
       p=p->link;
   }
   tmp=p->link;
   p->link=tmp->link;
   free(tmp);
   return start;
 };
 void count(struct node *start)
 {
     struct node *p;
     int i=0;
     p=start;
     while(p!=NULL)
     {
         i++;
         p=p->link;
     }
     printf("Total no. of nodes= %d\n",i);
 }
 void disp(struct node*start)
 {
     struct node*p;
     if(start==NULL)
     {
         printf("List is empty.\n");
     }
     else
     {
         p=start;
         printf("List:\n");
         while(p!=NULL)
         {
             printf("%d\t",p->info);
             p=p->link;
         }
         printf("\n\n");
     }
 }


int main()
{
    struct node*start=NULL;
    int ch,data,pos,value,i,n;
    while(1)
    {
        printf("1-To create.\n");
        printf("2-To display\n");
        printf("3-To insert at start\n");
        printf("4-To insert at end\n");
        printf("5-To insert at any location\n");
        printf("6-To insert after a specific element\n");
        printf("7-To delete at beginning\n");
        printf("8-To delete at end\n");
        printf("9-To delete at any position\n");
        printf("10-To count the total number of nodes\n");
        printf("11-End program\n");
        printf("Enter choice:");
        scanf("%d",&ch);
        printf("\n\n");
        switch(ch)
        {
           case 1:
                if(start!=NULL)
                {
                    printf("List is not empty\n");
                    break;
                }
                printf("Enter the number of elements you want to store: ");
                scanf("%d",&n);
                for(i=0;i<n;i++)
                {
                  printf("Enter element: ");
                  scanf("%d",&data);
                  start=create(start,data);
                }
                break;
          case 2:
                disp(start);
                break;
          case 3:
                printf("Enter element: ");
                scanf("%d",&data);
                start=insertatstart(start,data);
                break;
          case 4:
                printf("Enter element: ");
                scanf("%d",&data);
                start=insertatend(start,data);
                break;
          case 5:
                printf("Enter element: ");
                scanf("%d",&data);
                printf("Enter position: ");
                scanf("%d",&pos);
                start=insertatanyloc(start,data,pos);
                break;
          case 6:
                printf("Enter new element: ");
                scanf("%d",&data);
                printf("Enter value after which you want to store the new element: ");
                scanf("%d",&value);
                start=insertafterspecificelement(start,data,value);
                break;
          case 7:
                 start=delatbeg(start);
                 break;
          case 8:
                 start=delatend(start);
                 break;
          case 9:
                 printf("Enter the position of node you want to delete: ");
                 scanf("%d",&pos);
                 start=delatanypos(start,pos);
                 break;
          case 10:
                 count(start);
                 break;                          
          case 11:      
                exit(0);
        }
    }
    return(0);
}


