package org.chess.Main;

import org.chess.DataBase.DataBase;
import org.chess.Person.Person;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    static Random random =new Random();
    public static void main(String[] args) {
        int players=7;
        int created=1;
        while (created<=players){
            DataBase.players.put(created, new Person(created,"player"+" "+created));
            created++;
        }
        int totalMatches=5;

            System.out.println("Match:"+1);
            matchMaking();
            for(Integer key:DataBase.players.keySet()){
                DataBase.players.get(key).setPlyedOrNot(false);
            }
            for(int i=1;i<=totalMatches;i++) {
            System.out.println("Match:"+i);
            matchMakingByPoints();
            for(Integer key:DataBase.players.keySet()){
                DataBase.players.get(key).setPlyedOrNot(false);
            }

        }

    }
    private static void matchMakingByPoints() {
        int count=0;
        for(int i=0;i<DataBase.soretedPlayers.size()-2;i+=2){
            DataBase.soretedPlayers.get(i).setPlyedOrNot(true);
            DataBase.soretedPlayers.get(i+1).setPlyedOrNot(true);
            double point=random.nextDouble();
            if(point<0.4){
                DataBase.soretedPlayers.get(i+1).setPoints(DataBase.soretedPlayers.get(i+1).getPoints()+1);
            } else if (point>0.6) {
                DataBase.soretedPlayers.get(i).setPoints(DataBase.soretedPlayers.get(i).getPoints()+1);
            }
            else{
                DataBase.soretedPlayers.get(i+1).setPoints(DataBase.soretedPlayers.get(i+1).getPoints()+0.5);
                DataBase.soretedPlayers.get(i).setPoints(DataBase.soretedPlayers.get(i).getPoints()+0.5);
            }
            System.out.println(DataBase.soretedPlayers.get(i).getPersonName()+" vs "+DataBase.soretedPlayers.get(i+1).getPersonName());
        }
        DataBase.soretedPlayers.get(DataBase.soretedPlayers.size()-1).setBuyPoints(DataBase.soretedPlayers.get(DataBase.soretedPlayers.size()-1).getBuyPoints()+1);
        System.out.println(DataBase.soretedPlayers.get(DataBase.soretedPlayers.size()-1).getPersonName()+"is buy player");
        orderPlayers();
        pointsTable();
    }
    private static void matchMaking() {int count=0;
        for(Integer key:DataBase.players.keySet()){
            if(count==3) break;
            if(DataBase.players.get(key).isPlyedOrNot()){
                continue;
            }
            int rand=random.nextInt(7);
            if(rand==0) rand=7;
            while( DataBase.players.get(rand).isPlyedOrNot() || rand==key){
                rand=random.nextInt(7);
                if(rand==0) rand=7;
            }
            DataBase.players.get(key).setPlyedOrNot(true);
            DataBase.players.get(rand).setPlyedOrNot(true);
            double point=random.nextDouble();
            if(point<0.4){
                DataBase.players.get(rand).setPoints(DataBase.players.get(rand).getPoints()+1);
            } else if (point>0.6) {
                DataBase.players.get(key).setPoints(DataBase.players.get(key).getPoints()+1);
            }
            else{
                DataBase.players.get(rand).setPoints(DataBase.players.get(rand).getPoints()+0.5);
                DataBase.players.get(key).setPoints(DataBase.players.get(key).getPoints()+0.5);
            }
            System.out.println("player "+key+" "+"vs"+" "+"player "+rand);

            count++;
        }
        for (Integer key:DataBase.players.keySet()){
            if(!DataBase.players.get(key).isPlyedOrNot()){
                DataBase.players.get(key).setBuyPoints(DataBase.players.get(key).getBuyPoints()+1);
                System.out.println("player "+key+"is buy player");
            }
        }
        orderPlayers();
        pointsTable();

    }
    private static void orderPlayers() {
        DataBase.soretedPlayers=new ArrayList<>();
        for(Integer key:DataBase.players.keySet()){
            if(!DataBase.soretedPlayers.isEmpty()){
                for(int i=0;i<DataBase.soretedPlayers.size();i++){
                    if(DataBase.players.get(key).compareTo(DataBase.soretedPlayers.get(i))==1 )
                    {
                        DataBase.soretedPlayers.add(i,DataBase.players.get(key));
                        break;
                    } else if (i==DataBase.soretedPlayers.size()-1) {
                        DataBase.soretedPlayers.add(DataBase.players.get(key));
                        break;
                    }
                }
            }
            else{
                DataBase.soretedPlayers.add(DataBase.players.get(key));
            }
        }
    }
    private static void pointsTable() {
        System.out.println("------------------------------------------------------------------- ");
        System.out.println("player  "+"    |    "+"points "+" | "+" buyPoints"+"   |    "+"totalPpoints");
        for (int i=0;i<DataBase.soretedPlayers.size();i++){
            System.out.println(DataBase.soretedPlayers.get(i).getPersonName()+"    |    "+DataBase.soretedPlayers.get(i).getPoints()+"     |       "+DataBase.soretedPlayers.get(i).getBuyPoints()+"      |     "+(DataBase.soretedPlayers.get(i).getPoints()+DataBase.soretedPlayers.get(i).getBuyPoints()));
        }
        System.out.println("--------------------------------------------------------------------");
    }

}
