package abstraction.gui;

import static java.lang.System.exit;

import javax.swing.JOptionPane;

import abstraction.model.Person;
import abstraction.interfaces.PersistencePerson;

public class ProgramMenu{
    public void init(PersistencePerson persistencia){
        int parada = Integer.parseInt(JOptionPane.showInputDialog("DIGITE:\n1: inserir contatos\n2: imprimir contatos\n0: sair"));
            switch(parada){
                case(0):
                    JOptionPane.showMessageDialog(null,"FINALIZAR PROGRAMA");
                    exit(-1);
                case(1):{
                    Person person = new Person();
                    person.setName(JOptionPane.showInputDialog("Type name:"));
                    person.setAdress(JOptionPane.showInputDialog("Type adress:"));
                    person.setPhone(JOptionPane.showInputDialog("Type phone:"));
                    person.setEmail(JOptionPane.showInputDialog("Type email:"));
                    persistencia.save(person);
                    break;
                }
                case(2):{
                    persistencia.list();
                    break;
                }
                default:
                    JOptionPane.showMessageDialog(null,"Invalid option");
           }
    }
}

