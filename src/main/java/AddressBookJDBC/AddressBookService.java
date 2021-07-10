/********************************************************************************************
 * @Purpose JDBC AddressBook program to perform various operations in database. 
 * @author Rekha
 * @version 1.0
 * @since 24/06/2021
 ************************************************************************************************/
package AddressBookJDBC;

import java.util.List;

import model.AddressBookData;

public class AddressBookService {

    public enum IOService {
        DB_IO
    }

    private List<AddressBookData> addressBookList;
    private static AddressBookDBService addressBookDBService;

    public AddressBookService() {
        addressBookDBService = AddressBookDBService.getInstance();
    }

    public AddressBookService(List<AddressBookData> addresBookList) {
        this();
        this.addressBookList = addressBookList;
    }

    public List<AddressBookData> readAddressBookData(IOService ioservice) throws AddressBookException {
        if (ioservice.equals(IOService.DB_IO))
            this.addressBookList = addressBookDBService.readData();
        return this.addressBookList;
    }
}