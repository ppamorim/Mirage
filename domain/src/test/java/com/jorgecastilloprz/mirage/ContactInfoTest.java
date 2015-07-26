package com.jorgecastilloprz.mirage;

import com.jorgecastilloprz.mirage.model.ContactInfo;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jorge
 * @since 26/07/15
 */
public class ContactInfoTest {

  @Test public void shouldHaveDefaultTwitterId() throws Exception {
    ContactInfo contactInfo = new ContactInfo(null, null, null, null);
    assertEquals("", contactInfo.getTwitterId());
  }

  @Test public void shouldHaveDefaultFacebookId() throws Exception {
    ContactInfo contactInfo = new ContactInfo(null, null, null, null);
    assertEquals("", contactInfo.getFacebookId());
  }

  @Test public void shouldHaveDefaultFacebookName() throws Exception {
    ContactInfo contactInfo = new ContactInfo(null, null, null, null);
    assertEquals("", contactInfo.getFacebookName());
  }

  @Test public void shouldHaveDefaultFacebookUsername() throws Exception {
    ContactInfo contactInfo = new ContactInfo(null, null, null, null);
    assertEquals("", contactInfo.getFacebookUsername());
  }

  @Test public void shouldUseGivenTwitterId() throws Exception {
    ContactInfo contactInfo =
        new ContactInfo("000000", "999999", "MockFacebookUsername", "MockFacebookName");
    assertEquals("000000", contactInfo.getTwitterId());
  }

  @Test public void shouldUseGivenFacebookId() throws Exception {
    ContactInfo contactInfo =
        new ContactInfo("000000", "999999", "MockFacebookUsername", "MockFacebookName");
    assertEquals("999999", contactInfo.getFacebookId());
  }

  @Test public void shouldUseGivenFacebookName() throws Exception {
    ContactInfo contactInfo =
        new ContactInfo("000000", "999999", "MockFacebookUsername", "MockFacebookName");
    assertEquals("MockFacebookName", contactInfo.getFacebookName());
  }

  @Test public void shouldUseGivenFacebookUsername() throws Exception {
    ContactInfo contactInfo =
        new ContactInfo("000000", "999999", "MockFacebookUsername", "MockFacebookName");
    assertEquals("MockFacebookUsername", contactInfo.getFacebookUsername());
  }
}