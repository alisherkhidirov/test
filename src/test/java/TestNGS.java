import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class TestNGS {


    @DataProvider(name = "so")
     public Object[] data() {

        return null;
    }

    @Test(testName = "test", description = "testing")
    void test(Method method) {

        Test test = method.getAnnotation(Test.class);
        System.out.println(test.description());
        System.out.println(test.testName());
    }
}
