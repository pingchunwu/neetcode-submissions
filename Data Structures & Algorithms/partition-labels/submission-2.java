class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for (int i = 0 ; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> res = new ArrayList();
        int end = map.get(s.charAt(0));
        int count = 0;
        for (int i = 0 ; i < s.toCharArray().length; i++) {
            end = Math.max(map.get(s.charAt(i)), end);
            count++;
            if (end == i) {
                res.add(count);
                count = 0;
                continue;
            }
        }

        
        return res;
    }
}

// class Solution {
//     public List<Integer> partitionLabels(String s) {
//         Map<Character, Integer> map = new HashMap();
//         List<Integer> list = new ArrayList();
//         for (int i = 0 ; i < s.toCharArray().length; i++) {
//             char c = s.charAt(i);
//             if (map.get(c) == null) {
//                 map.put(c, i);
//                 list.add(i);
//             } else {
//                 int prev = map.get(c);
//                 for (int j = prev ; j < i; j++) {
//                     map.put(s.charAt(j), prev);
//                     list.set(j, prev);
//                 }
//                 list.add(prev);
//             }
//         }
//         int cur = list.get(0);
//         int count = 0;
//         List<Integer> res = new ArrayList();
//         for (int i : list) {
//             if (cur != i) {
//                 res.add(count);
//                 cur = i;
//                 count = 0;
//             }
//             count++;
//         }

//         res.add(count);
        
//         return res;
//     }
// }
