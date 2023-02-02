import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class MathUtilTest {
    MathUtil mathUtil=new MathUtil();
    @Test
    void test1(){
        assertEquals(mathUtil.sum(1,1),2);
    }
    @Test
    void test2(){
        assertEquals(mathUtil.sum(2,1),3);
    }
}
