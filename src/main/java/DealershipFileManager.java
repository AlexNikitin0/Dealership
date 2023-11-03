import java.io.*;

public class DealershipFileManager {




    public void getDealership ()throws IOException{
        FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    }

    public void saveDealership()throws IOException{
        FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv", true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    }
}
