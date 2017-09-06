package com.maxmind.minfraud.request;

import com.maxmind.minfraud.request.Email.Builder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmailTest {

    @Test
    public void testAddress() throws Exception {
        Email email = new Builder().address("test@test.org").build();
        assertEquals("raw email", "test@test.org", email.getAddress());
        assertEquals("domain set from email", "test.org", email.getDomain());
    }

    @Test
    public void testAddressMd5() throws Exception {
        Email email = new Builder().addressMd5("test@test.org").build();
        assertEquals("MD5 generated from email", "476869598e748d958e819c180af31982", email.getAddress());
        assertEquals("domain set from email", "test.org", email.getDomain());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() throws Exception {
        new Builder().address("a@test@test.org").build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddressMd5() throws Exception {
        new Builder().addressMd5("a@test@test.org").build();
    }

    @Test
    public void testEmailSetTwice() {
        Email email = new Builder().addressMd5("test@test.org").address("test@test.org").build();
        assertEquals("email returned after overwriting MD5 hash", "test@test.org", email.getAddress());
    }

    @Test
    public void testDomain() throws Exception {
        String domain = "domain.com";
        Email email = new Builder().domain(domain).build();
        assertEquals(domain, email.getDomain());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDomain() throws Exception {
        new Builder().domain(" domain.com").build();
    }
}
