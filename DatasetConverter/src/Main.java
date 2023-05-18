// Importing input output classes
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Curtois
        /*
        CurtoisConvertor c = new CurtoisConvertor();
        c.convertDataset(5);
        c.convertOutput();
         */

        // NPSLib
        NSPLibConvertor n = new NSPLibConvertor();
        n.convertDataset();
    }
}
