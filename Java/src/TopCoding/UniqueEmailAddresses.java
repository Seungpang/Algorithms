package TopCoding;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        StringAndArray.UniqueEmailAddresses a = new StringAndArray.UniqueEmailAddresses();
        String[] emails = {"test.email+james@coding.com",
            "test.e.mail+toto.jane@coding.com",
            "testemail+tom@cod.ing.com"};

        System.out.println(a.solution(emails));
    }

    public int solve(String[] emails) {
        Set<String> set = new HashSet<>();

        for(String email : emails) {
            String[] parts = email.split("@");
            String[] id = parts[0].split("\\+");
            set.add(id[0].replaceAll(".", "") + "@" + parts[1]);
        }
        return set.size();
    }
}
