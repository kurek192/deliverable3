import java.util.ArrayList;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner
{
    
    public static void main(String[] args)
    {
        ArrayList<Class> test_classes = new ArrayList<Class>();
        boolean failures = false;

        test_classes.add(HomepageTest.class);
        test_classes.add(FactorialTest.class);
        test_classes.add(FibonacciTest.class);
        test_classes.add(HelloTest.class);
        test_classes.add(CathedralTest.class);

        for (Class c: test_classes)
        {
            Result results = JUnitCore.runClasses(c);

            for (Failure f : results.getFailures()) {
                System.out.println(f.toString());
            }

            if (!results.wasSuccessful())
            {
            failures = true;
            }
        }

        if (failures)
        {
            System.out.println("\n!!! - At least one failure, see above.");
        } else {

            System.out.println("\nALL TESTS PASSED");
        }
    }
}