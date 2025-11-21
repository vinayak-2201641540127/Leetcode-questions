class Solution1 {
    public int countPalindromicSubsequence(String s) {
        int n =  s.length();
        Set<String>set = new HashSet<>();
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n; k++){
                    if(s.charAt(i) == s.charAt(k)){
                        String s1 =""+ s.charAt(i)+s.charAt(j)+s.charAt(k);
                        if(!set.contains(s1)){
                            set.add(s1);
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}

class Solution2 {
    public int countPalindromicSubsequence(String s) {
        int n =  s.length();
        int count = 0;
        Set<Character>set = s.chars().mapToObj(c -> (char)c).collect(Collectors.toSet()); 

        for(char ch: set){
            int i = -1;
            int j = 0;
            for(int k=0; k<n; k++){
                if(s.charAt(k) == ch){
                    if(i == -1)i=k;
                    j=k;
                }
            }
            Set<Character>set1 = new HashSet<>();
            for(int k=i+1; k<j; k++){
                if(!set1.contains(s.charAt(k)))set1.add(s.charAt(k));
            }
            count += set1.size();
        }       

        System.out.println(set);     

        return count;
    }
}


class Solution {
    public int countPalindromicSubsequence(String s) {
        int n =  s.length();
        int count = 0;
        int first[] = new int[26];
        int last[] = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for(int i=0; i<n; i++){
            int ch = (int)(s.charAt(i)-'a');
            if(first[ch] == -1)first[ch] = i;
            last[ch] = i; 
        }

        for(int i=0; i<26; i++){
            if(first[i] == -1)continue;
            Set<Character>set = new HashSet<>();
            for(int k=first[i]+1; k<last[i]; k++){
                set.add(s.charAt(k));
            }
            count += set.size();
        }

        return count;
    }
}