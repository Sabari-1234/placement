package org.zohoL2Chennai;

public class removeTargetInString {
    public static void main(String[] args) {
        String str="mamabbmabma";
        String target="mab";
        removeTarget(str,target);
    }

    private static void removeTarget(String str,String target) {
        String res="";
        for(int i=0;i<str.length();i++){
            res+=str.charAt(i)+"";
            if(res.contains(target)){
                res=res.substring(0,res.length()-target.length());
            }
        }
        System.out.println(res);
    }


}
