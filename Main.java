package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        try(BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter fileWthCode = new BufferedWriter(new FileWriter("fileWthCode.txt"));
            BufferedReader rd1 = new BufferedReader(new FileReader("fileWthCode.txt"));
            BufferedWriter fileWthEditedCode = new BufferedWriter(new FileWriter("fileWthEditedCode.txt"));){

            String txt;
            while (!(txt = rd.readLine()).equals("end")){
                fileWthCode.write(txt+"\n");
                fileWthCode.flush();
            }

            String txt1 = "";//
            while((txt = rd1.readLine())!=null){
                txt1+=txt +"\n";
            }
            String EditTxt1 = txt1.replaceAll("(//.+)|(//)", "");
            String EditTxt2 = EditTxt1.replaceAll("/\\*(.|\\s|.&&\\s)*?\\*/", "");
            fileWthEditedCode.write(EditTxt2);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
