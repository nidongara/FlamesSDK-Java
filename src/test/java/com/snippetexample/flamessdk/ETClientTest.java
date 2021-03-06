//
// This file is part of the Fuel Java SDK.
//
// Copyright (c) 2013, 2014, 2015, ExactTarget, Inc.
// All rights reserved.
//
// Redistribution and use in source and binary forms, with or without
// modification, are permitted provided that the following conditions
// are met:
//
// * Redistributions of source code must retain the above copyright
// notice, this list of conditions and the following disclaimer.
//
// * Redistributions in binary form must reproduce the above copyright
// notice, this list of conditions and the following disclaimer in the
// documentation and/or other materials provided with the distribution.
//
// * Neither the name of ExactTarget, Inc. nor the names of its
// contributors may be used to endorse or promote products derived
// from this software without specific prior written permission.
//
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
// "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
// LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
// A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
// HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
// SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
// LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
// DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
// THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
// (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
// OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
//

package com.snippetexample.flamessdk;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ETClientTest {
    @BeforeClass
    public static void setUpBeforeClass()
        throws ETSdkException
    {
        Assume.assumeNotNull(ETClientTest.class
                .getResource("/fuelsdk-test.properties"));
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testBackwardCompatibility1()
        throws ETSdkException
    {
        ETClient client = new ETClient();
        ETFilter filter = new ETFilter();
        filter.setProperty("key");
        filter.setOperator(ETFilter.Operator.EQUALS);
        filter.addValue("dataextension_default");
        ETResponse<ETFolder> response = client.retrieve(ETFolder.class,
                                                        filter);
        assertIsDataExtensionFolder(response);
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testBackwardCompatibility2()
        throws ETSdkException
    {
        ETClient client = new ETClient();
        ETFilter filter = new ETFilter();
        filter.setProperty("key");
        filter.setOperator(ETFilter.Operator.EQUALS);
        filter.addValue("dataextension_default");
        ETResponse<ETFolder> response = client.retrieve(ETFolder.class,
                                                        filter,
                                                        "key");
        assertEquals(1, response.getObjects().size());
        ETFolder folder = response.getObjects().get(0);
        assertNull(folder.getId());
        assertEquals("dataextension_default", folder.getKey());
        assertNull(folder.getName());
        assertNull(folder.getDescription());
        assertNull(folder.getCreatedDate());
        assertNull(folder.getModifiedDate());
        assertNull(folder.getContentType());
        assertNull(folder.getParentFolderKey());
        assertNull(folder.getIsActive());
        assertNull(folder.getIsEditable());
        assertNull(folder.getAllowChildren());
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testBackwardCompatibility3()
        throws ETSdkException
    {
        ETClient client = new ETClient();
        ETFilter filter = new ETFilter();
        filter.setProperty("key");
        filter.setOperator(ETFilter.Operator.EQUALS);
        filter.addValue("dataextension_default");
        ETResponse<ETFolder> response = client.retrieve(ETFolder.class,
                                                        filter,
                                                        "key",
                                                        "name");
        assertEquals(1, response.getObjects().size());
        ETFolder folder = response.getObjects().get(0);
        assertNull(folder.getId());
        assertEquals("dataextension_default", folder.getKey());
        assertEquals("Data Extensions", folder.getName());
        assertNull(folder.getDescription());
        assertNull(folder.getCreatedDate());
        assertNull(folder.getModifiedDate());
        assertNull(folder.getContentType());
        assertNull(folder.getParentFolderKey());
        assertNull(folder.getIsActive());
        assertNull(folder.getIsEditable());
        assertNull(folder.getAllowChildren());
    }

    @Test
    @SuppressWarnings("deprecation")
    public void testBackwardCompatibility4()
        throws ETSdkException
    {
        ETClient client = new ETClient();
        ETFilter filter = new ETFilter();
        filter.setProperty("key");
        filter.setOperator(ETFilter.Operator.EQUALS);
        filter.addValue("dataextension_default");
        ETResponse<ETFolder> response = client.retrieve(ETFolder.class,
                                                        filter,
                                                        "key",
                                                        "name",
                                                        "description");
        assertEquals(1, response.getObjects().size());
        ETFolder folder = response.getObjects().get(0);
        assertNull(folder.getId());
        assertEquals("dataextension_default", folder.getKey());
        assertEquals("Data Extensions", folder.getName());
        assertEquals("", folder.getDescription());
        assertNull(folder.getCreatedDate());
        assertNull(folder.getModifiedDate());
        assertNull(folder.getContentType());
        assertNull(folder.getParentFolderKey());
        assertNull(folder.getIsActive());
        assertNull(folder.getIsEditable());
        assertNull(folder.getAllowChildren());
    }

    //
    // XXX make these available to all tests
    //

    private DateFormat dateFormat =
            new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    private void assertIsDataExtensionFolder(ETResponse<ETFolder> response) {
        assertEquals(1, response.getObjects().size());
        ETFolder folder = response.getObjects().get(0);
        assertEquals("94511", folder.getId()); // XXX make configurable
        assertEquals("dataextension_default", folder.getKey());
        assertEquals("Data Extensions", folder.getName());
        assertEquals("", folder.getDescription());
        assertEquals("2014-08-10T23:50:00.833", // XXX make configurable
                dateFormat.format(folder.getCreatedDate()));
        assertEquals("2014-08-10T23:50:00.833", // XXX make configurable
                dateFormat.format(folder.getModifiedDate()));
        assertEquals("dataextension", folder.getContentType());
        assertNull(folder.getParentFolderKey());
        assertTrue(folder.getIsActive());
        assertFalse(folder.getIsEditable());
        assertTrue(folder.getAllowChildren());
    }
}
