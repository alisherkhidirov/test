import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "test" )
    public Object[][] test() {
        Object[][] objects = new Object[0][5];
        objects[0][0] = "Alisher";
        objects[0][1] = "Khidirov";
        objects[0][2] = "sdet";
        objects[0][3] = "099098990";
        objects[0][4] = "HR";
        return objects;
    }
}
