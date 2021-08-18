package testDirectory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {
        Map<String, Integer> test = new HashMap<>();
        Map<String, Integer> aa = new HashMap<>();
        aa.put("Test.test", 2);
        aa.put("Test.test2", 4);
        test.putAll(aa);
        aa.put("Test.test", 5);
        System.out.println(aa.toString());
        Member meber = new Member(testDirectory.test.AA);

        System.out.println(meber.getAbc().getName().contains("NE"));

        //System.out.println(Test.test.toString());
    }
}


class Member {

    public test abc;

    public test getAbc() {
        return abc;
    }

    public void setAbc(test abc) {
        this.abc = abc;
    }

    public Member(test abc) {
        this.abc = abc;
    }
}

enum test {
    AA("NE"),
    BB("BB");

    test(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}

