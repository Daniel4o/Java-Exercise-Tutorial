import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

  public boolean addNewContact(Contact contact){
       int doesExist = findContact(contact.getName());
       if(doesExist >= 0) return false;
       myContacts.add(contact);
       return true;
    }

    public boolean updateContact(Contact currentContact, Contact newContact) {
        int doesExist = findContact(currentContact);
        if(doesExist < 0) return false;
        myContacts.set(doesExist, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
      if(findContact(contact) < 0) return false;
      myContacts.remove(contact);
      return true;
    }

    private int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    private int findContact(String contact) {
      for(int i =0; i<myContacts.size();i ++) {
          Contact contacts = myContacts.get(i);
          if(contacts.getName() == contact) return i;
      }
        return -1;
    }

    public Contact queryContact(String name){
      int doesExist = findContact(name);
      if(doesExist <0) return null;
            return myContacts.get(doesExist);
    }

    public void printContacts() {
        System.out.println("Contact List:");
        for(int i =0; i<myContacts.size(); i++) {
            System.out.println((i+1) +". " + myContacts.get(i).getName() + " -> " + myContacts.get(i).getPhoneNumber());
        }
    }
}
