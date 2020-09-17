package kakao.blind2019;

import java.util.*;

public class OpenChatingRoom{
    public String[] solution(String[] record) {
        List<String> ansList = new ArrayList<String>();
        Map<String, String> idmap = new HashMap<String, String>();

        for (String str : record) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
            if (cmd.equals("Enter") || cmd.equals("Change")) {
                String id = tokenizer.nextToken();
                String name = tokenizer.nextToken();
                idmap.put(id, name);
            }
        }

        for (String str : record) {
            StringTokenizer tokenizer = new StringTokenizer(str);
            String cmd = tokenizer.nextToken();
            if (cmd.equals("Enter")) {
                String id = tokenizer.nextToken();
                ansList.add(idmap.get(id) + "님이 들어왔습니다.");
            } else if (cmd.equals("Leave")) {
                String id = tokenizer.nextToken();
                ansList.add(idmap.get(id) + "님이 나갔습니다.");
            }
        }

        String[] answer = new String[ansList.size()];
        ansList.toArray(answer);

        return answer;
    }
}