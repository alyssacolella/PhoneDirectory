
import java.util.LinkedList;

/**
 * CIS 2168-004 Fall 2019 Data Structures
 * @author alyssacolella
 * tui91984@temple.edu
 * Lab 6
 * OrderedPhoneDirectoryTest class
 * This class creates an OrderedPhoneDirectory and tests the methods of the PhoneDirectoryEntry and OrderedPhoneDirectoryEntry classes
 */
public class OrderedPhoneDirectoryTest 
{
    public static void main(String[] args) 
    {
        OrderedPhoneDirectory phoneDirectory = new OrderedPhoneDirectory(); //new OrderedPhoneDirectory
        
        //add PhoneDirectoryEntry elements to linked list
        phoneDirectory.addInOrder("Black", "Panther", "267-123-4567");
        phoneDirectory.addInOrder("Iron", "Man", "267-111-1111");
        phoneDirectory.addInOrder("Captain", "America", "610-123-9999");
        phoneDirectory.addInOrder("Spider", "Man", "215-833-8382");
        phoneDirectory.addInOrder("Hulk", "Smash", "267-909-7282");
        
        System.out.println(phoneDirectory.toString()); //print directory
        
        phoneDirectory.search("Iron", "Man"); //success case
        phoneDirectory.search("Ant", "Man"); //failure case
       
        phoneDirectory.search("610-123-9999"); //success case
        phoneDirectory.search("794-285-2852"); //failure case
        
        phoneDirectory.search(267); //success case
        phoneDirectory.search(999); //failure case
        
        phoneDirectory.set("Black", "Panther", "215-847-7000"); //success case
        phoneDirectory.set("Ant", "Man", "610-394-8342"); //failure case
        
        phoneDirectory.remove("Hulk", "Smash"); //success case
        phoneDirectory.remove("Ant", "Man"); //failure case 
        
        System.out.println(phoneDirectory.toString()); //print directory' 
    } 
}
