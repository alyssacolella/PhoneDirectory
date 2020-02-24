
import java.util.LinkedList;

/**
 * CIS 2168-004 Fall 2019 Data Structures
 * @author alyssacolella
 * tui91984@temple.edu
 * Lab 6
 * OrderedPhoneDirectory class
 * This class includes the OrderedPhoneDirectory constructor and methods to manipulate a linked list of phone directory entry elements
 */
public class OrderedPhoneDirectory 
{
    //declare new linked list
    private LinkedList <PhoneDirectoryEntry> directory;
    
    /**
     * An OrderedPhoneDirectory constructor that declares the linked list of PhoneDirectoryEntry elements
     */
    public OrderedPhoneDirectory()
    {         
        this.directory = new LinkedList<>();
    }
    
    /**
     * A method to add PhoneDirectoryEntry elements to the linked list in alphabetical order by last name 
     * @param firstName entry's first name
     * @param lastName entry's last name
     * @param number entry's phone number
     * @return true if entry added, false if not
     */
    public boolean addInOrder(String firstName, String lastName, String number)
    {
        PhoneDirectoryEntry entry = new PhoneDirectoryEntry(firstName, lastName, number);
       
        if(directory.size() == 0) //if directory is empty
        {
            directory.add(0, entry);
            return true;
        }
        
        //check if new entry matches full name of existing entry
        for(int i = 0; i < directory.size(); i++)
        {
            if(entry.compareTo(directory.get(i)) == 0)
            {
                return false;
            }  
        }
       
        //add entry in correct index
        for(int i= 0; i < directory.size(); i++)
        {
            if(entry.compareTo(directory.get(i)) < 0)
            {
                directory.add(i, entry);
                return true;
            }
        }

        //new entry not alphabetically before any others, add to end of directory
        directory.add(entry);
        return true;
        
    }
    
    /**
     * A method to turn the elements in the linked list to a string
     * @return print directory
     */
    public String toString()
    {
        String printDirectory = "Phone Directory: \n\n";
        
        for(int i = 0; i < directory.size(); i++)
        {
            printDirectory += directory.get(i).getFirstName() + " " + directory.get(i).getLastName() + "  |  " + directory.get(i).getNumber() + "\n";
        }
        return printDirectory;
    }
    
    /**
     * A method to search the directory for a specific person and return their phone number
     * @param firstName first name to search for
     * @param lastName last name to search for
     * @return phone number of specified person, or null if person does not exist in directory
     */
    public String search(String firstName, String lastName)
    {
        for(int i = 0; i < directory.size(); i++)
        {
            if(directory.get(i).getLastName().equals(lastName))
            {
                if(directory.get(i).getFirstName().equals(firstName))
                {
                    System.out.println(directory.get(i).getFirstName() + " " + directory.get(i).getLastName() + "'s number is " + directory.get(i).getNumber() + ".\n");
                    return directory.get(i).getNumber();
                }
            }
        }
        System.out.println("There is no " + firstName + " " + lastName + " in this directory.\n");
        return null;
    }
    
    /**
     * A method to find the person with a specified phone number
     * @param phone phone number of person to find
     * @return name of person, or null if no one in directory has the specified phone number
     */
    public String search(String phone)
    {
        for(int i = 0; i < directory.size(); i++)
        {
            if(directory.get(i).getNumber().equals(phone))
            {
                System.out.println("The number " + directory.get(i).getNumber() + " belongs to " + directory.get(i).getFirstName() + " " + directory.get(i).getLastName() + ".\n");
                return phone;
            }
        }
        System.out.println("No one in the directory has the phone number " + phone + ".\n");
        return null;
    }
    
    /**
     * A method to provide the people in the directory with a common area code
     * @param areaCode common area code to look for
     * @return list of people with common area code, or null if no on shares the area code
     */
    public LinkedList<String> search(int areaCode)
    {
        LinkedList<String> sameAreaCode = new LinkedList<>();
        
        for(int i = 0; i < directory.size(); i++)
        {
            if(directory.get(i).getNumber().substring(0,3).equals(String.valueOf(areaCode)))
            {
                sameAreaCode.add((directory.get(i).getFirstName() + directory.get(i).getLastName()));
            }
        }
        
        if(sameAreaCode.size() > 0)
        {
            System.out.println("The following people have the area code " + areaCode + ":");
            for(int i = 0; i < sameAreaCode.size(); i++)
            {
                System.out.print(sameAreaCode.get(i) + "\n");
            }
            return sameAreaCode;
        }
        else
        {
            System.out.println("\nNo one in this directory has the area code " + areaCode + ".\n");
            return null;
        }
    }
    
    /**
     * A method to change the number of an 
     * @param firstName
     * @param lastName
     * @param newPhoneNumber
     * @return old number if number changed, null if not
     */
    public String set(String firstName, String lastName, String newPhoneNumber)
    {
        for(int i = 0; i < directory.size(); i++)
        {
            if(directory.get(i).getLastName().equals(lastName))
            {
                if(directory.get(i).getFirstName().equals(firstName))
                {
                    String oldNumber = directory.get(i).getNumber();
                    directory.get(i).setNumber(newPhoneNumber);
                    return "Old number: " + oldNumber + "\n";
                }      
            }
        }
        System.out.println(firstName + " " + lastName + " does not exist in this directory. Can't change number.\n");
        return null;
    }
    
    /**
     * A method to remove a person from the directory
     * @param firstName first name of person to remove
     * @param lastName last name of person to remove
     * @return true if person is removed, false if they are not in directory
     */
    public boolean remove(String firstName, String lastName)
    {
        for(int i = 0; i < directory.size(); i++)
        {
            if(directory.get(i).getLastName().equals(lastName) && directory.get(i).getFirstName().equals(firstName) )
            {
                System.out.println(directory.get(i).getFirstName() + " " + directory.get(i).getLastName() + " has been removed from the directory.\n");
                directory.remove(directory.get(i));  
                return true;
            }     
        }
        
        System.out.println(firstName + " " + lastName + " is not in the directory. Can't remove them.\n");
        return false;
    }
    
}
