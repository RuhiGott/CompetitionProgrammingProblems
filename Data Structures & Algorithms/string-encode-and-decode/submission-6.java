class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int n = Integer.parseInt(str.substring(i, str.indexOf("#", i)));
            
            i = str.indexOf("#", i) + 1;
            strs.add(str.substring(i, i + n));
            
            i += n;
        }


        return strs;
    }
}
