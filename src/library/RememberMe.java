/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author AnhLee
 */
public class RememberMe {
    File file = new File("rememberMe/save.txt");
    public void SAVE(JTextField name, JPasswordField password){      //Save the UserName and Password (for one user)
        try {
            if(!file.exists()) file.createNewFile();  //if the file !exist create a new one

            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
            bw.write(name.getText()); //write the name
            bw.newLine(); //leave a new Line
            bw.write(password.getPassword()); //write the password
            bw.close(); //close the BufferdWriter

        } catch (IOException e) { e.printStackTrace(); }        

 }
    public void UPDATE(JTextField name, JPasswordField password){ //UPDATE ON OPENING THE APPLICATION

        try {
            if(file.exists()){    //if this file exists
                Scanner scan = new Scanner(file);   //Use Scanner to read the File
                name.setText(scan.nextLine());  //append the text to name field
                password.setText(scan.nextLine()); //append the text to password field
                scan.close();
            }
        } catch (FileNotFoundException e) {         
            e.printStackTrace();
        }                
   }
    public void FORGET(){
        if(file.exists()){    //if this file exists
            file.delete();
        }                
   }
}
