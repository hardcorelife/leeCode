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
        boolean[] isVisit=new boolean[10000];//0~9999共10000种可能
        boolean[] isDead=new boolean[10000];
        for (String deadEnd : deadends) {
            int deadNum = Integer.parseInt(deadEnd);//字符串转十进制数，“0101”=101；
            isDead[deadNum] = true;//标记deadends里的数字是禁忌数
        }
        //如果"0000"在deadEnds中，返回-1
        if(isDead[0]) {
            return -1;
        }
        if("0000".equals(target)) {
            return 0;
        }

        int step=0;
        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(Integer.parseInt(target));//放入target作为根节点，查找到“0000”退出
        isVisit[Integer.parseInt(target)]=true;//标记target已经访问
        int last=Integer.parseInt(target);//当前最后一个数
        int cenglast=last;
        while(!queue.isEmpty())
        {
            while(true)
            {
                int[] neighbor=new int[8];
                int head=queue.poll();
                if(head==0) {
                    //查找到“0000”退出
                    return step;
                }
                int[] nei=neighbor(head);//邻居节点
                for(int i=0;i<8;i++)
                {
                    int trans=nei[i];
                    if(isVisit[trans] || isDead[trans]) {
                        //如果邻居节点已经访问或者是禁忌数，则跳过下面的步骤，直接i++
                        continue;
                    }
                    //如果不是将这个数放入队列
                    queue.offer(trans);
                    last=trans;
                    isVisit[trans]=true;//标记为已尝试
                }
                if(head==cenglast) {
                    //如果当前的节点和上一层的最后一个节点相同，说明已经遍历了这一整层
                    //退出第二层while循环
                    break;
                }
            }
            step++;
            cenglast=last;
        }
        return -1;


    }

    private int[] neighbor(int code)
    //转成int型之后用 +9，+1来取余数，+9相当于-1，还避免了用if来求解。
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