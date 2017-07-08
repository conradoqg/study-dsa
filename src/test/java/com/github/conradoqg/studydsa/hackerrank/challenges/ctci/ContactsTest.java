package com.github.conradoqg.studydsa.hackerrank.challenges.ctci;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContactsTest {

	@Test
	public void testContacts_Case1() {
		Contacts.ContactsTree contacts = new Contacts.ContactsTree();
		
		contacts.add("hack");
		contacts.add("hackerrank");
		
		assertTrue(contacts.find("hac") == 2);
		assertTrue(contacts.find("hak") == 0);
	}
	
	@Test
	public void testContacts_Case2() {
		Contacts.ContactsTree contacts = new Contacts.ContactsTree();
		
		contacts.add("s");
		contacts.add("ss");
		contacts.add("sss");
		
		assertTrue(contacts.find("s") == 3);
		assertTrue(contacts.find("ss") == 2);
		assertTrue(contacts.find("sss") == 1);
		assertTrue(contacts.find("ssss") == 0);
	}
}
