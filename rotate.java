class LinkedList
{

static class Node
{
    int data;
    Node next;
}
//pushing values to linked list
static Node push(Node head_ref, int new_data)
{
    Node new_node = new Node();
    new_node.data = new_data;
    new_node.next = (head_ref);
    (head_ref) = new_node;
    return head_ref;
}
 
static void printList(Node node)
{
    while (node != null)
    {
        System.out.print(node.data + " -> ");
        node = node.next;
    }
    System.out.print( "null");
}
 
//Rotate clockwise
static Node rightRotate(Node head, int k)
{
    if (head == null)
        return head;
    Node tmp = head;
    int len = 1;
    while (tmp.next != null)
    {
        tmp = tmp.next;
        len++;
    }
    if (k > len)
        k = k % len;
    k = len - k;   
    if (k == 0 || k == len)
        return head;
    Node current = head;
    int cnt = 1;
    while (cnt < k && current != null)
    {
        current = current.next;
        cnt++;
    }
    if (current == null)
        return head;
    Node kthnode = current;
    tmp.next = head;
    head = kthnode.next;
    kthnode.next = null;
    return head;
}
 
// Driver code
public static void main(String args[])
{
 
    /* The constructed linked list is:
    1.2.3.4.5 */
    Node head = null;
    head = push(head, 5);
    head = push(head, 4);
    head = push(head, 3);
    head = push(head, 2);
    head = push(head, 1);
    int k = 2;
    Node updated_head = rightRotate(head, k);
    printList(updated_head);
}
}
