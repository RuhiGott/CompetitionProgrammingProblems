class Solution {

    public String encode(List<String> strs) {

        // LENGTH # STRING
        StringBuilder encoding = new StringBuilder();

        for (String str : strs) {
            encoding.append(str.length()).append("#").append(str);
        }

        return encoding.toString();
    }   

    public List<String> decode(String str) {
        List<String> decoding = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            StringBuilder length = new StringBuilder(); 

            while (str.charAt(i) != '#') {
                length.append(str.charAt(i));
                i++;
            }

            int lengthInt = Integer.parseInt(length.toString());

            decoding.add(str.substring(i + 1, i + lengthInt + 1));

            i += lengthInt;
        }

        return decoding;

    }
}
