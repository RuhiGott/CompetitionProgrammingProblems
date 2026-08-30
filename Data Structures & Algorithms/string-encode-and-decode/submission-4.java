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
        StringBuilder n = new StringBuilder();

        while (i < str.length()) {
            while (str.charAt(i) != '#') {
                n.append(str.charAt(i));
                i++;
            }
            i++;
            strs.add(str.substring(i, i + Integer.parseInt(n.toString())));
            i += Integer.parseInt(n.toString());

            n = new StringBuilder();
        }

        return strs;
    }
}
