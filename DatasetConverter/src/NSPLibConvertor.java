import java.io.*;

public class NSPLibConvertor {
    public NSPLibConvertor() {
    }
    public void convertDataset() throws IOException {
        // Core dataset
        int[] sets = {25, 30, 50, 60, 75, 100};
        for (int set : sets) {
            for (int r = 1; r <= 10; r++) {
                File file = new File(
                        "C:\\Users\\tonie\\Documents\\4de jaar unief\\Masterproef\\Datasets\\DatasetConverter\\DatasetConverter\\dataset NSPLib\\instances\\N" + set + "\\" + r + ".nsp");
                //Minizinc dataset
                File fileMZ = new File("DatasetConverter/dataset NSPLib/minizinc_datafiles/N" + set + "_" + r + "nsp.dzn");
                BufferedReader br = new BufferedReader(new FileReader(file));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileMZ));

                // Size parameters
                String[] st = br.readLine().split("\t");
                int amountOfEmployees = Integer.parseInt(st[0]);
                int horizon = Integer.parseInt(st[1]);
                int amountOfShifts = Integer.parseInt(st[2]);
                bw.append("amountOfEmployees = " + amountOfEmployees + ";\n");
                bw.append("horizonLength = " + horizon + ";\n");
                bw.append("amountOfShifts = " + amountOfShifts + ";\n\n");
                br.readLine();

                // Shifts per day
                bw.append("shiftsPerDay = [|");
                for(int i = 0; i < horizon; i++){
                    st = br.readLine().split("\t");
                    for(int j = 0; j < amountOfShifts; j++){
                        bw.append(st[j]);
                        bw.append(",");
                    }
                    bw.append("\n|");
                }
                bw.append("];\n\n");
                br.readLine();

                // Employee preferences
                bw.append("preferences = array3d(" + "1.." + amountOfEmployees + ",1.." + horizon + ",1.." + amountOfShifts + ",[");
                for(int i = 0; i < amountOfEmployees; i++){
                    st = br.readLine().split("\t");
                    for(int j = 0; j < horizon; j++){
                        for(int k = 0; k < amountOfShifts; k++){
                            bw.append(st[j*amountOfShifts + k]);
                            bw.append(",");
                        }
                    }
                }
                bw.append("]);");

                br.close();
                bw.close();
            }
        }
        // Extra cases
    }
}
