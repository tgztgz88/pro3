package com.tgz;

public class AddTwoNumbersTest {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode hand=new ListNode();
        ListNode now=hand;
        ListNode l1now=new ListNode();
        l1now=l1;
        ListNode l2now=new ListNode();
        l2now=l2;
        if(l1now.val==0)return l2;//第一个数为0  直接返回第二个数
        if(l2now.val==0)return l1;//第二个数为0  直接返回第一个数
        while (l1now==null&&l2now==null){
            now.next=new ListNode();
            now=now.next;
            if(l1now==null){now.val=l2now.val;l2now=l2now.next;continue;}
            else if(l2now==null){now.val=l1now.val;l1now=l1now.next;continue;}
            else{now.val=l1now.val+l2now.val;l1now=l1now.next;l2now=l2.next;}
        }
            return hand.next;
    }

    public static void main(String[] args) {
       ListNode l2=new ListNode(2);
        ListNode l4=new ListNode(4);
        ListNode l3=new ListNode(3);

        l2.next=l4;
        l4.next=l3;

        ListNode l5=new ListNode(5);
        ListNode l6=new ListNode(6);
        ListNode l4_2=new ListNode(4);
        l5.next=l6;
        l6.next=l4_2;

        AddTwoNumbersTest addTwoNumbersTest=new AddTwoNumbersTest();
        ListNode result=addTwoNumbersTest.addTwoNumbers(l2,l5);
        while (result!=null){
            System.out.print(result.val+"---");
            result=result.next;
        }
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
      ListNode() {  }
  }
