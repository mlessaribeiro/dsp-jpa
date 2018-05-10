package implementation.txt;

import javax.swing.JOptionPane;

import abstraction.gui.ProgramMenu;

public class MainTxt{
    public static void main (String[] args)throws Exception{
        int n = 0;
        while(n == 0){
            JOptionPane.showMessageDialog( null,"File: TXT");
            new ProgramMenu().init(new PersistenceTxt("Contacts.txt"));
            n = 0;
        }
    }
}   