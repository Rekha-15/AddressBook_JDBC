/********************************************************************************************
 * @Purpose JDBC AddressBook program to perform various operations in database. 
 * Exception class
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/

package AddressBookJDBC;

public class AddressBookException extends Exception {

    enum ExceptionType {
        DATABASE_EXCEPTION, NO_SUCH_CLASS
    }

    public ExceptionType type;

    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
}