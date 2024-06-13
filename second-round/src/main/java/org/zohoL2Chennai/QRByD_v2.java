package org.zohoL2Chennai;

public class QRByD_v2 {
    public static void main(String[] args) {
        fracDivide(10.122);
    }

    private static void fracDivide(double f) {
            String s=f+"";
            String q=s.substring(0,s.indexOf('.'));

            String remain=s.substring(s.indexOf('.')+1,s.length());

            String tens="1";
            int len=remain.length();

            while(len!=0){
                tens+="0";
                len--;
            }
            float f1=Integer.parseInt(remain);
            float f2=Integer.parseInt(tens);
            for(int i=Integer.parseInt(remain);i>=2;i--){
                if(f1%i==0 && f2%i==0){
                    f1= f1/i;
                    f2= f2/i;
                    break;
                }
            }

        System.out.println(q+" "+(int)f1+"/"+(int)f2);
    }
}
