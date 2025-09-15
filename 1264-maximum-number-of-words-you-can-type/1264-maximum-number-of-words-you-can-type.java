class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int n = brokenLetters.length();
        Set<Character>set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(brokenLetters.charAt(i));
        }
        String words[] = text.split(" ");
        int ans = words.length;
        for(String word: words){
            for(int i=0; i<word.length(); i++){
                if(set.contains(word.charAt(i))){
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}