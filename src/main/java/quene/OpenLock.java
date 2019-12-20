package quene;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author qiweigang
 * @date 2019-12-13 10:59
 */
public class OpenLock {
    public int openLock(String[] deadends, String target) {
        boolean[] isVisit=new boolean[10000];//0~9999��10000�ֿ���
        boolean[] isDead=new boolean[10000];
        for (String deadEnd : deadends) {
            int deadNum = Integer.parseInt(deadEnd);//�ַ���תʮ����������0101��=101��
            isDead[deadNum] = true;//���deadends��������ǽ�����
        }
        //���"0000"��deadEnds�У�����-1
        if(isDead[0]) {
            return -1;
        }
        if("0000".equals(target)) {
            return 0;
        }

        int step=0;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(Integer.parseInt(target));//����target��Ϊ���ڵ㣬���ҵ���0000���˳�
        isVisit[Integer.parseInt(target)]=true;//���target�Ѿ�����
        int last=Integer.parseInt(target);//��ǰ���һ����
        int cenglast=last;
        while(!queue.isEmpty())
        {
            while(true)
            {
                int[] neighbor=new int[8];
                int head=queue.poll();
                if(head==0) {
                    //���ҵ���0000���˳�
                    return step;
                }
                int[] nei=neighbor(head);//�ھӽڵ�
                for(int i=0;i<8;i++)
                {
                    int trans=nei[i];
                    if(isVisit[trans] || isDead[trans]) {
                        //����ھӽڵ��Ѿ����ʻ����ǽ�����������������Ĳ��裬ֱ��i++
                        continue;
                    }
                    //������ǽ�������������
                    queue.offer(trans);
                    last=trans;
                    isVisit[trans]=true;//���Ϊ�ѳ���
                }
                if(head==cenglast) {
                    //�����ǰ�Ľڵ����һ������һ���ڵ���ͬ��˵���Ѿ���������һ����
                    //�˳��ڶ���whileѭ��
                    break;
                }
            }
            step++;
            cenglast=last;
        }
        return -1;


    }

    private int[] neighbor(int code)
    //ת��int��֮���� +9��+1��ȡ������+9�൱��-1������������if����⡣
    {
        int[] res=new int[8];
        int a=code%10;
        int b=(code/10)%10;
        int c=(code/100)%10;
        int d=(code/1000)%10;
        res[0]=d*1000+c*100+b*10+(a+10-1)%10;
        res[1]=d*1000+c*100+b*10+(a+1)%10;
        res[2]=d*1000+c*100+((b+10-1)%10)*10+a;
        res[3]=d*1000+c*100+((b+1)%10)*10+a;
        res[4]=d*1000+((c+10-1)%10)*100+b*10+a;
        res[5]=d*1000+((c+1)%10)*100+b*10+a;
        res[6]=((d+10-1)%10)*1000+c*100+b*10+a;
        res[7]=((d+1)%10)*1000+c*100+b*10+a;
        return res;
    }

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        OpenLock obj = new OpenLock();
        int step =  obj.openLock(deadends, target);
        System.out.println(step);
        boolean t = isIsomprphis("add","tes");
        t = isIsomprphis("add","tjj");
        System.out.println(t);
    }

    public static boolean isIsomprphis(String left,String right){
        List<Integer> normalizeLeft = normalize(left);
        List<Integer> normalizeRight = normalize(right);

        return normalizeLeft.equals(normalizeRight);
    }

    private static List<Integer> normalize(String s){
        List<Integer> charset = s.chars().boxed().distinct().collect(Collectors.toList());
        return  s.chars().boxed().map(charset::indexOf).collect(Collectors.toList());

    }
}