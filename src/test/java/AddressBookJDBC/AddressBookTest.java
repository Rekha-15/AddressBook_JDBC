package AddressBookJDBC;

import org.junit.Assert;
import org.junit.Test;
import model.AddressBookData;
import java.util.List;

public class AddressBookTest {
	static AddressBookService addressBookService;

	@Test
	public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount() throws AddressBookException {
		AddressBookService addressBookService = new AddressBookService();
		List<AddressBookData> addressBookData = addressBookService
				.readAddressBookData(AddressBookService.IOService.DB_IO);
		Assert.assertEquals(3, addressBookData.size());
	}

	@Test
	public void givenAddressBook_WhenUpdate_ShouldSyncWithDB() throws AddressBookException {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.updateRecord("Rekha", "GKW Lauout");
		boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("Rekha");
		Assert.assertTrue(result);
	}

	@Test
	public void givenAddressBook_WhenRetrieved_ShouldMatchCountInGivenRange() throws AddressBookException {
		AddressBookService addressBookService = new AddressBookService();
		List<AddressBookData> addressBookData = addressBookService
				.readAddressBookData(AddressBookService.IOService.DB_IO, "2018-02-14", "2020-06-02");
		Assert.assertEquals(3, addressBookData.size());
	}

	@Test
	public void givenAddressBook_WhenRetrieved_ShouldReturnCountOfCity() throws AddressBookException {
		AddressBookService addressBookService = new AddressBookService();
		Assert.assertEquals(3, addressBookService.readAddressBookData("count", "Bangalore"));
	}

	@Test
	public void givenAddressBookDetails_WhenAdded_ShouldSyncWithDB() throws AddressBookException {
		AddressBookService addressBookService = new AddressBookService();
		addressBookService.readAddressBookData(AddressBookService.IOService.DB_IO);
		addressBookService.addNewContact("Rasmi", "Shree", "GKW layour", "Bangalore", "Kar", "560056", "8909987876",
				"rasmi@gmail.com", "2020-11-22");
		boolean result = addressBookService.checkUpdatedRecordSyncWithDatabase("Rasmi");
		Assert.assertTrue(result);
	}
}