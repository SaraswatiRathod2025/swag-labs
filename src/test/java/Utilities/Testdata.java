package Utilities;

import org.testng.annotations.DataProvider;

import Base.Handlebrowser;

public class Testdata extends Handlebrowser {
	@DataProvider(name = "InvalidCredentialsTestData")
	public String[][] testData1() {
		return new String[][] { { "standard_user", "uhgugiy8768768" }, { "ihgiu8768768", "secret_sauce" },
				{ "87687gjhjb", "kjhiuy9898" } };
	}

}
