import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class zad4 {
    public static void main(String[] args) throws IOException {
        //Zad 4.1
        File file1 = new File("src/zadanie_4.txt");
        file1.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        bufferedWriter.newLine();
        bufferedWriter.append("Zadanie 4.1");
        bufferedWriter.flush();
        int r = 200;
        String a = "";
        int times = 0;
        File file = new File("src/data/punkty.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> points = new ArrayList<>();
        while ((a=bufferedReader.readLine())!=null){
            String [] tab = a.split(" ");
            int q =(int)Math.pow((double)(Integer.parseInt(tab[0])-200), 2)
                    +(int)Math.pow((double)(Integer.parseInt(tab[1])-200),2);
            if(q==(200*200)){
                points.add(a);
            }
            if(q<200*200){
                times++;
            }
        }
        for (String t: points) {
            bufferedWriter.newLine();
            bufferedWriter.append(t);
            bufferedWriter.flush();
        }
        bufferedWriter.newLine();
        bufferedWriter.append(String.valueOf(times));
        bufferedWriter.flush();

        //Zad 4.2
        bufferedWriter.newLine();
        bufferedWriter.append("Zadanie 2");
        bufferedWriter.flush();
        int point = 0;
        times = 0;
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file));
        while ((a=bufferedReader1.readLine())!=null){
            point++;
            String [] tab = a.split(" ");
            int q =(int)Math.pow((double)(Integer.parseInt(tab[0])-200), 2)
                    +(int)Math.pow((double)(Integer.parseInt(tab[1])-200),2);
            if(q<=200*200){
                times++;
            }

            if(point==100){
                double Pk = ((double)times/100)*(400*400)/(200*200);
                bufferedWriter.newLine();
                bufferedWriter.append(String.valueOf(Pk));
                bufferedWriter.flush();
            }
             if(point==1000){
                 double Pk = ((double) times/1000)*(400*400)/(200*200);
                 bufferedWriter.newLine();
                 bufferedWriter.append(String.valueOf(Pk));
                 bufferedWriter.flush();              }
             if(point==5000){
                 double Pk = ((double) times/5000)*(400*400)/(200*200);
                 bufferedWriter.newLine();
                 bufferedWriter.append(String.valueOf(Pk));
                 bufferedWriter.flush();              }


        }
        double
                Pk = ((double)times/10000)*(400*400)/(200*200);
        bufferedWriter.newLine();
        bufferedWriter.append(String.valueOf(Pk));
        bufferedWriter.flush();
        //Zad 4.3
        bufferedWriter.newLine();
        bufferedWriter.append("Zadanie 4.3");
        bufferedWriter.flush();
        point = 0;
        times = 0;
        //System.out.println(Math.abs(-34));
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
        List<String> list = new ArrayList<>();
        while ((a=bufferedReader2.readLine())!=null && point<1700){
            point++;
            String [] tab = a.split(" ");
            int q =(int)Math.pow((double)(Integer.parseInt(tab[0])-200), 2)
                    +(int)Math.pow((double)(Integer.parseInt(tab[1])-200),2);
            if(q<=200*200){
                times++;
            }
            double pi = ((double)times/point)*(400*400)/(200*200);
            double e = Math.abs((Math.PI)-pi);
            int a1 = (int)((double)(e*10000));
            double a2 = (double) a1/10000;
            bufferedWriter.newLine();
           bufferedWriter.append(String.valueOf(a2));
bufferedWriter.flush();

        }
    }
}
