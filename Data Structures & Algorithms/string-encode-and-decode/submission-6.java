class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String str: strs) {
            res += str.length() + "#" + str;
        }
        System.out.println(">> " +  res);
        return res;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j ++;
            }
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            list.add(str.substring(i, j));
            System.out.println("?? length"+ length);
            System.out.println("?? "+ str.substring(i, j));
            i = j;
        }
        return list;
    }
}
