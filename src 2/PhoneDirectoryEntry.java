
/**
 * CIS 2168-004 Fall 2019 Data Structures
 * @author alyssacolella
 * tui91984@temple.edu
 * Lab 6
 * PhoneDirectoryEntry class
 * This class includes the constructor for a PhoneDirectoryEntry methods, getter and setter methods, and a compareTo method
 */
public class PhoneDirectoryEntry 
{
    private String firstName;
    private String lastName;
    private String number;
    
    public PhoneDirectoryEntry(String firstName, String lastName, String number)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }
    
    //setter methods
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setNumber(String number)
    {
        this.number = number;
    }
    
    //getter methods
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getNumber()
    {
        return number;
    }
    
    /**
     * A method to compare two PhoneDirectoryEntry elements alphabetically
     * @param other PhoneDirectoryEntry element to compare to
     * @return 1, -1, or 0 depending on which entry comes before another in the directory
     */
    public int compareTo(PhoneDirectoryEntry other)
    {
        if(this.lastName.compareTo(other.lastName) == 0 && this.firstName.compareTo(other.firstName) == 0) //same name
        {
            return 0;
        }
        else if(this.lastName.compareTo(other.lastName) < 0)
        {
            return -1;
        }
        else if(this.lastName.compareTo(other.lastName) > 0)
        {
            return 1;
        }
        else if(this.firstName.compareTo(other.firstName) < 0)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }
}
