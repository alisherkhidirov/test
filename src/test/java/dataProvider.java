import org.testng.annotations.DataProvider;

public class dataProvider {

    @DataProvider(name = "0")
    public Object[][] test1() {
       Object[][] objects = new Object[1][5];
        objects[0][0] = "aaaaaaaa";
        objects[0][1] = "bbbbbbbb";
        objects[0][2] = "sdet";
        objects[0][3] = "0909";
        objects[0][4] = "HR";
        return objects;
    }
}
