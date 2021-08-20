public class Codec {
    final char DELIMITER = '#';
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append(DELIMITER);
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            //Find the number of characters
            StringBuilder sb = new StringBuilder();
            while(arr[i] != DELIMITER){
                sb.append(arr[i++]);
            }
            i++;
            
            //Iteration the enter string to add to res list
            int numOfChars = Integer.valueOf(sb.toString());
            int end = i + numOfChars;
            sb = new StringBuilder();
            while(i < end){
                sb.append(arr[i++]);
            }
            i--;
            res.add(sb.toString());
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
