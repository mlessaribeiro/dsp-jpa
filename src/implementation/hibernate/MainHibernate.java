package implementation.hibernate;

import abstraction.gui.ProgramMenu;
import javax.swing.JOptionPane;

public class MainHibernate {
    public static void main (String[] args)throws Exception{
        int n = 0;
        while(n == 0){
            JOptionPane.showMessageDialog( null,"Hibernate");
            new ProgramMenu().init(new PersistenceHibernate());
            n = 0;
        }
    }    
}
