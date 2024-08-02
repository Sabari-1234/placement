package org.zohoL2Chennai;

public class removeTargetString_V2 {
    public static void main(String[] args) {
        String str="mamabbmabma";
        String target="mab";
        removeTarget(str,target);
    }

    private static void removeTarget(String str,String target) {
        String res="";
        for(int i=0;i<str.length();i++){
            res+=str.charAt(i)+"";
            if(stringContains(res,target)){

                res=subString(res.length()-target.length(),res);
            }
        }
        System.out.println(res);
    }
    private static boolean stringContains(String subString,String target) {
        int j=subString.length()-1;

        for(int i=target.length()-1;i>=0;i--){

            if(j<0 || target.charAt(i)!=subString.charAt(j)){
                return false;
            }
            j--;
        }
        return true;

    }
    private static String subString(int end,String res){
        String sub="";
        for(int i=0;i<end;i++){
            sub+=res.charAt(i);
        }
        return sub;
    }

}
