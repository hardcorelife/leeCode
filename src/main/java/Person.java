import java.lang.reflect.Method;

/**
 * @author qiweigang
 * @date 2019-12-12 10:32
 */
public class Person {
    private String name="crossover" ;
    private String msg ;

    public Person(String name, String msg) {
        this.name = name;
        this.msg = msg;
        System.out.println(name+"的描述是"+msg);
    }

    public Person() {
        super();
    }

    public void say(String name ,String msg){
        System.out.println(name+"说："+msg);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static void main(String[] args) {
        try {
            //首先获取类类型
            Class c1 = Class.forName("Person") ;

            //通过newInstance()方法生成一个实例
            Object o1 = c1.newInstance() ;

            //获取该类的say方法
            Method m1 = c1.getMethod("say", String.class,String.class) ;

            //通过invoke方法调用该方法
            m1.invoke(o1, "张三","你好啊") ;

            Method[] methods = c1.getDeclaredMethods() ;
            for(Method m : methods){
                System.out.println(m.getName());
            }

//            Method[] methods2 = c1.getMethods() ;
//            for (Method method : methods2) {
//                System.out.println(method.getName());
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
