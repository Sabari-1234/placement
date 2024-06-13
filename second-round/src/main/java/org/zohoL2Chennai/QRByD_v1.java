package org.zohoL2Chennai;



public class QRByD_v1 {
    public static void main(String[] args) {
        divide(1.2);
    }

    private static void divide(double f) {
        int count =1;
        double f1=f;
        String s;
        while (true) {
            s=f+"";
            int index=s.indexOf('.');
            String sub=s.substring(index+1,s.length());
            try {
                if(Long.parseLong(sub)==0){
                    break;
                }
                else{
                    f+=f1;
                    count++;
                }
            }
            catch (NumberFormatException e){
                s=f1+"";
                String q=s.substring(0,s.indexOf('.'));
                String r=s.substring(s.indexOf('.')+1,s.length());
                String d="1";
                count=0;
                while (count<r.length()){
                    d+="0";
                    count++;
                }
                System.out.println(q+" "+r+"/"+d);
                return;
            }
        }
        int count1=count;
        String sub=s.substring(0,s.indexOf('.'));
        int val=Integer.parseInt(sub);
        int quotient=0;
        while(count<val){
            count+=count1;
            quotient++;
        }
        count-=count1;

        System.out.println(quotient+" "+(val-count)+"/"+count1);

    }
}
