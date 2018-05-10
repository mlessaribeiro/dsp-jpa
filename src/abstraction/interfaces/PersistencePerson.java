package abstraction.interfaces;

import abstraction.model.Person;

public interface PersistencePerson {

    public void save(Person pessoa);
    
    public void list();
    
}
