package StringAndArray;

import java.util.*;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses a = new UniqueEmailAddresses();
        String[] emails = {"Test.test.email+james@coding.com",
                "Test.test.e.mail+toto.jane@coding.com",
                "testemail+tom@cod.ing.com"};

        System.out.println(a.solution(emails));
    }


    public int numUniqueEmails(String[] emails){
        Set<String> set = new HashSet<>();

        for(String email: emails){
            String localName = makeLocalName(email);
            String domainName = makeDomainName(email);
            set.add(localName+"@"+domainName);
        }
        return set.size();
    }

    private String makeDomainName(String email){
        return email.substring(email.indexOf('@')+1);
    }

    private String makeLocalName(String email){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<email.length(); i++){
            if(email.charAt(i)=='.'){
                continue;
            }
            if(email.charAt(i)=='+'){
                break;
            }
            if(email.charAt(i)=='@'){
                break;
            }
            String str = String.valueOf(email.charAt(i));
            sb.append(str);
        }
        return sb.toString();
    }

    public int solution(String[] emails) {

        Set<String> set = new HashSet<>();

        for(String email : emails) {
            String[] parts = email.split("@");
            String[] localName = parts[0].split("\\+");
            set.add(localName[0].replace(".", "") + "@" + parts[1]);
        }
        return set.size();
    }

}
