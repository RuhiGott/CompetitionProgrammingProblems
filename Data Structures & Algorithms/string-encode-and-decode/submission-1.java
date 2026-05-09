class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length());
            sb.append(":");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> decoding = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder sbLength = new StringBuilder();
            
            while (str.charAt(i) != ':') {
                sbLength.append(str.charAt(i));
                i++;
            }
            i++;

            int length = Integer.parseInt(sbLength.toString());
            
            
            decoding.add(str.substring(i, i + length));
            i += length - 1;
        }

        return decoding;
    }
}
