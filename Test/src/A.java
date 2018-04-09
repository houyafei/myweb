/**
 * 不解释
 *
 * @author yafei.hou  on 2018/1/26
 */
public class A {

    static int a = 1;

    @Override
    public String toString() {
        System.out.println(a);
        return String.valueOf(a++);
    }
}
