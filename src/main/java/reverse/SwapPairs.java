package reverse;

/**
 * @author qiweigang
 * @date 2019-12-07 15:49
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        System.out.println(head);
        if (head == null || head.next == null) {//������������ڵ�����С��2
            return head;
        }
        ListNode root = new ListNode(0);//���붨��һ�����ڵ㣬�Ӷ���ס��������ͷ��
        root.next = head;//�Զ���ڵ�next������������
        ListNode pre = root;//��Ҫһ���ڵ��ס����������ǰ����һ�ν�����ĩβ�ڵ�������

        while (pre.next != null && pre.next.next != null) {//��һ�ν�������һ���ڵ㣬���¸��ڵ㶼��Ϊ�ղ��ܽ���
            ListNode start = pre.next;//������һ�ν����ĵ�һ���ڵ�
            ListNode then = pre.next.next;//������һ�ν����ĵڶ����ڵ�
            //��һ���͵ڶ����ڵ�λ�ý���
            //�����и�����ע����ǣ�����λ�ý���������1->2->3->4->5���������2��3Ҫ������ִ�н�����������
            //1��ָ��3��Ȼ��2ִ��4�����3ָ��2,���������������ˡ�
            pre.next = then;
            start.next = then.next;
            then.next = start;

            pre = start;//��������һ�ν���ǰ���ϸ��ڵ�node
        }
        return root.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

}