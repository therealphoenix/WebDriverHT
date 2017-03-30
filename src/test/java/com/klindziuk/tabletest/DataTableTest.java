package com.klindziuk.tabletest;

import org.testng.annotations.Test;
import org.testng.Assert;

public class DataTableTest extends BaseTest {

		@Test
	public void testData_User1() {
		// check u_id
		Assert.assertEquals(tablePage.getUser1Id(), "1");
		// check u_login
		Assert.assertEquals(tablePage.getUser1Login(), "user1");
		// check u_password
		Assert.assertEquals(tablePage.getUser1Password(), "e38ad214943daad1d64c102faec29de4afe9da3d");
		// check u_email
		Assert.assertEquals(tablePage.getUser1Email(), "user1@mail.com");
		// check u_name
		Assert.assertEquals(tablePage.getUser1Name(), "Pupkin");
		// check u_remember
		Assert.assertEquals(tablePage.getUser1Remember(), "");
	}

	@Test
	public void testData_User2() {
		// check u_id
		Assert.assertEquals(tablePage.getUser2Id(), "2");
		// check u_login
		Assert.assertEquals(tablePage.getUser2Login(), "user2");
		// check u_password
		Assert.assertEquals(tablePage.getUser2Password(), "2aa60a8ff7fcd473d321e0146afd9e26df395147");
		// check u_email
		Assert.assertEquals(tablePage.getUser2Email(), "user2@mail.com");
		// check u_name
		Assert.assertEquals(tablePage.getUser2Name(), "Smith");
		// check u_remember
		Assert.assertEquals(tablePage.getUser2Remember(), "");
	}
}