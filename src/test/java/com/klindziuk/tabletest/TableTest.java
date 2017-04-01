package com.klindziuk.tabletest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TableTest extends BaseTest{

	@BeforeClass
	public void beforeTestClass() throws Exception {
		super.beforeTestClass();
		tablePage.selectStructure();
		tablePage.selectColumns();
	}

	@AfterClass
	public void afterTestClass() {
		tablePage.logOut();
	}

	@Test
	public void testTable() {
		// check id field
		Assert.assertEquals(tablePage.getIdName(), "u_id");
		Assert.assertEquals(tablePage.getIdType(), "int(11)");
		Assert.assertEquals(tablePage.getIdNotNull(), "No");
		Assert.assertEquals(tablePage.getIdAutoIncrement(), "AUTO_INCREMENT");
		// check login
		Assert.assertEquals(tablePage.getLoginName(), "u_login");
		Assert.assertEquals(tablePage.getLoginType(), "varchar(255)");
		Assert.assertEquals(tablePage.getLoginNotNull(), "No");
		// check password
		Assert.assertEquals(tablePage.getPasswordName(), "u_password");
		Assert.assertEquals(tablePage.getPasswordType(), "char(40)");
		Assert.assertEquals(tablePage.getPasswordNotNull(), "No");
		// check email
		Assert.assertEquals(tablePage.getEmailName(), "u_email");
		Assert.assertEquals(tablePage.getEmailType(), "varchar(255)");
		Assert.assertEquals(tablePage.getEmailNotNull(), "No");
		// check name
		Assert.assertEquals(tablePage.getNameName(), "u_name");
		Assert.assertEquals(tablePage.getNameType(), "varchar(255)");
		Assert.assertEquals(tablePage.getNameNotNull(), "No");
		// check remember
		Assert.assertEquals(tablePage.getRememberName(), "u_remember");
		Assert.assertEquals(tablePage.getRememberType(), "char(40)");
		Assert.assertEquals(tablePage.getRememberNotNull(), "No");
		// check collation
		Assert.assertEquals(tablePage.getCollation(), "utf8_general_ci");
		// check AutoIncrement
		Assert.assertEquals(tablePage.getAutoIncrement(), "3");
	}
}