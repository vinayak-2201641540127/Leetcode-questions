class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>ans = new ArrayList<>();
        Set<String>business = new HashSet<>();
        List<Coupon>valid = new ArrayList<>();
        Map<String, Integer>map = Map.of(
            "electronics",0,
            "grocery",1,
            "pharmacy",2,
            "restaurant",3
        );
        business.add("electronics");
        business.add("grocery");
        business.add("pharmacy");
        business.add("restaurant");
        String regex = "^[a-zA-Z0-9_]+$";
        int n = code.length;
        for(int i=0; i<n; i++){
            String c = code[i];
            String b = businessLine[i];
            boolean active = isActive[i];
            if(c != null && c.matches(regex) && active == true &&    business.contains(b)){
                valid.add(new Coupon(c, b));
            }
        }

        valid.sort((a,b)->{
            int p1 = map.get(a.businessLine);
            int p2 = map.get(b.businessLine);
            if(p1 != p2)return p1-p2;
            return a.code.compareTo(b.code);
        });
        for(Coupon cp: valid){
            ans.add(cp.code);
        }
        return ans;
    }
}

class Coupon{
    String code, businessLine;
    Coupon(String code, String businessLine){
        this.code = code;
        this.businessLine = businessLine;
    }
}