class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate("", 0, n);
        return res;
    }

    public boolean isValid(String str){
        int sum=0;
        for(char ch:str.toCharArray()){
            if(ch=='('){
                sum++;
            }
            if(ch==')'){
                sum--;
            }
            if(sum<0) return false;
        }
        return sum==0;
    }

    public void generate(String curr, int len, int n){
        if(len==2*n){
            if(isValid(curr)){
                res.add(curr);
                return;
            }
            return;
        }

        curr+='(';
        generate(curr, len+1, n);
        curr = curr.substring(0, curr.length()-1);
        curr += ')';
        generate(curr, len+1, n);
    }
}