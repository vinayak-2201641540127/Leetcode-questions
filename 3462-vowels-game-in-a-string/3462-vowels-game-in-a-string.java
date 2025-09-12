class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character>set = new HashSet<>();
        set.add('a');set.add('e');
        set.add('i');set.add('o');
        set.add('u');
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i)))count++;
        }
        if(count == 0)return false;
        return true; 
    }
}