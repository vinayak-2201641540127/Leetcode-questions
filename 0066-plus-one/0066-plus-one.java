class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int carry=0;
        // int flag=0;
        int rem=1;
        List<Integer>list=new ArrayList<>();
        if(digits[n-1]+1<=9){
            digits[n-1]=digits[n-1]+1;
            return digits;
        }
        for(int i=n-1;i>=0;i--){
          if(digits[i]+rem+carry>9){
               list.add(0);
               carry=1;
               rem=0;
        }
        else{
            if(carry==1){
                list.add(digits[i]+1);
                carry=0;
            }
            else{
                list.add(digits[i]);
            }
        }
        }
        if(carry==1)list.add(carry);

        if(list.size()!=n)n++;
        
        int ar[]=new int[n];
        int j=list.size()-1;
        for(int i=0;i<list.size();i++){
           ar[i]=list.get(j--);
       }
        return ar;
    }
}