struct ListNode* deleteMiddle(struct ListNode* head){ 
    struct ListNode*slow=head;
    struct ListNode*fast=head;
    struct ListNode*prev=NULL;
    if(!head->next){
        return NULL;
    }
    else{
        while(fast && fast->next){
            prev=slow;
            slow=slow->next;
            fast=fast->next->next;
            
        }
        prev->next=slow->next;
        return head;
    }

}