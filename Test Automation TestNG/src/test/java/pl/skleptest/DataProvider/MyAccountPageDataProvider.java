package pl.skleptest.DataProvider;

import org.testng.annotations.DataProvider;

public class MyAccountPageDataProvider {
    @DataProvider(name = "DataProviderMyAccountObject")
    public Object[] registerData(){
        MyAccountPageObject myAccountPageObject = new MyAccountPageObject();
        myAccountPageObject.setMail("123@gmail.com");
        myAccountPageObject.setPassword("1234567890ASDZXC!@#");
        return new Object[]{myAccountPageObject};
    }
}
