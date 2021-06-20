import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class zad5 {
    public static  void main(String[] args) throws IOException {
        //Zad 5.1
        File file6 = new File("src/zadanie_5.txt");
        file6.createNewFile();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file6));
        bufferedWriter.newLine();
        bufferedWriter.append("Zadanie 5.1");
        bufferedWriter.flush();


        File file = new File("src/data/wypozyczenia.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
         File file1 = new File("src/data/studenci.txt");
        BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
        File file2 = new File("src/data/meldunek.txt");
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file2));


        List<String> times = new ArrayList<>();
        String a, b = "", c = "";
        bufferedReader.readLine();
        String recordPesel = "";
        int times1 = 0;
        int i1 =0;
        while ((a=bufferedReader.readLine())!=null){
            String [] tab = a.split("\t");

            if((b.split(tab[1])).length==1) {
                i1++;
                b += " "+ tab[1];
            }else{
                if(times1<(b.split(tab[1])).length){
                    times1 = b.split(tab[1]).length;
                    recordPesel = tab[1];
                }

            }
        }
        bufferedReader1.readLine();
        bufferedReader = new BufferedReader(new FileReader(file));
        while ((a=bufferedReader.readLine())!=null){
            String [] tab = a.split("\t");
if(tab[1].equals(recordPesel)){
    times.add(tab[2]);
}
        }
        while ((a=bufferedReader1.readLine())!=null){
            String [ ] tab = a.split("\t");
            if(tab[0].trim().equals(recordPesel.trim())){
                recordPesel=tab[1];
                bufferedWriter.newLine();
                bufferedWriter.write(tab[2]+" "+tab[1]);
                bufferedWriter.flush();

                break;
            }
        }
        for (String s: times
             ) {
            bufferedWriter.newLine();
            bufferedWriter.write(s);

        }
        bufferedWriter.flush();

        //Zad 5.2
        bufferedWriter.newLine();
        bufferedWriter.write("Zad 5.2");
        bufferedWriter.flush();

        List<String> rooms = new ArrayList<>();
        int id=  0;
        bufferedReader2.readLine();
        List<skeleton> rooms1 = new ArrayList<>();
while ((a=bufferedReader2.readLine())!=null){
    String [] tab = a.split("\t");
    if(id<Integer.parseInt(tab[1]))
        id=Integer.parseInt(tab[1]);
}
int [] tab2 = new int[id];
for(int i =0; i < id; i++){
    skeleton skeleton = new skeleton();
    skeleton.setLp(String.valueOf(i+1));
    skeleton.setBooks("");
    rooms1.add(skeleton);
}
bufferedReader2 = new BufferedReader(new FileReader(file2));
        bufferedReader2.readLine();
        while ((a=bufferedReader2.readLine())!=null) {
            String [] tab = a.split("\t");
tab2[Integer.parseInt(tab[1])-1]++;

            }
        int i2= 0;
        id=0;
        for (int t : tab2){
            if(t!=0) {
                i2 += t;
                id++;
            }
        }
        double o = (double)i2/(double)id;
        int o1 = (int) ((double)o*10000);

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(((double)o1)/10000));
        bufferedWriter.flush();
        //Zad 5.3

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf("Zad 5.3"));
        bufferedWriter.flush();

        int woman = 0;
        int man = 0;
        bufferedReader1 = new BufferedReader(new FileReader(file1));
        bufferedReader1.readLine();
        while ((a=bufferedReader1.readLine())!=null){
            String [] tab = a.split("\t");
            String [] tab1 = tab[0].split("", 11);
            if(Integer.parseInt(tab1[9])%2==0)
                woman++;
            else
                man++;
        }

        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(woman));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(man));
        bufferedWriter.flush();
        //Zad 5.4
        bufferedWriter.newLine();
        bufferedWriter.write("Zad 5.4");
        bufferedWriter.flush();
        bufferedReader1 = new BufferedReader(new FileReader(file1));
        bufferedReader1.readLine();
        String d="";
        int i = 0;
        List<String> tab3 = new ArrayList<>();
        while ((a=bufferedReader1.readLine())!=null){
            String [] tab1 = a.split("\t");
            bufferedReader = new BufferedReader(new FileReader(file2));
            bufferedReader.readLine();
            while ((d=bufferedReader.readLine())!=null){
                String [] tab =d.split("\t");
                if(tab1[0].equals(tab[0])){
                    i =1;
                }
            }
            if(i==0){
                tab3.add(tab1[1]+" "+tab1[2]);
            }
i=0;
        }
        System.out.println(tab3.size());
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(tab3);
        List<String> sorted = new ArrayList<>();
        sorted.addAll(treeSet);
        for (String t: sorted ) {
            bufferedWriter.newLine();
            bufferedWriter.write(t);
        }

        bufferedWriter.flush();


        //Zad 5.5
        bufferedWriter.newLine();
        bufferedWriter.write("Zad 5.5");
        bufferedWriter.flush();
        bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.readLine();
        int m =0;
        int wyp = 0;
        String u="";
        while ((a=bufferedReader.readLine())!=null) {
            String [] tab = a.split("\t");
            bufferedReader2 = new BufferedReader(new FileReader(file2));
            bufferedReader2.readLine();
            while ((u = bufferedReader2.readLine()) != null) {
                String [] tab1 = u.split("\t");
if(tab1[0].equals(tab[1])){
    if(rooms1.get(Integer.parseInt(tab1[1])-1).getBooks().split(tab[2]).length<=1){
        wyp++;
        skeleton skeleton = new skeleton();
        skeleton.setLp(rooms1.get(Integer.parseInt(tab1[1])-1).getLp());
        skeleton.setBooks(rooms1.get(Integer.parseInt(tab1[1])-1).getBooks()+"\t"+tab[2]);
        rooms1.set(Integer.parseInt(tab1[1])-1, skeleton);
    }
    m=1;
    break;
}
            }
            if(m==0){
                wyp++;

            }else {
                m=0;
            }
        }
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(wyp));
        bufferedWriter.flush();
    }
    public static  class skeleton{
        private String lp;
        private String books;

        public String getLp() {
            return lp;
        }

        public void setLp(String lp) {
            this.lp = lp;
        }

        public String getBooks() {
            return books;
        }

        public void setBooks(String books) {
            this.books = books;
        }
    }

}
