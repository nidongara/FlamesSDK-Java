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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.snippetexample.flamessdk.annotations.InternalName;
import com.snippetexample.flamessdk.annotations.ExternalName;
import com.snippetexample.flamessdk.annotations.SoapObject;
import com.exacttarget.fuelsdk.internal.Attribute;
import com.exacttarget.fuelsdk.internal.Subscriber;

/**
 * An <code>ETSubscriber</code> object represents an email subscriber
 * in the Salesforce Marketing Cloud.
 */

@SoapObject(internalType = Subscriber.class, unretrievable = {
    "Attributes", "ModifiedDate"
})
public class ETSubscriber extends ETSoapObject {
    @ExternalName("id")
    private String id = null;
    @ExternalName("key")
    @InternalName("subscriberKey")
    private String key = null;
    @ExternalName("createdDate")
    private Date createdDate = null;
    @ExternalName("modifiedDate")
    private Date modifiedDate = null;
    @ExternalName("emailAddress")
    private String emailAddress = null;
    @ExternalName("preferredEmailType")
    @InternalName("emailTypePreference")
    private ETEmail.Type preferredEmailType = null;
    @ExternalName("status")
    private Status status = null;
    @ExternalName("unsubscribedDate")
    private Date unsubscribedDate = null;
    @ExternalName("lists")
    private List<ETSubscriberList> lists = null;
    @ExternalName("attributes")
    protected List<Attribute> attributes;

    public ETSubscriber() {}

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ETEmail.Type getPreferredEmailType() {
        return preferredEmailType;
    }

    public void setPreferredEmailType(ETEmail.Type preferredEmailType) {
        this.preferredEmailType = preferredEmailType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getUnsubscribedDate() {
        return unsubscribedDate;
    }

    public void setUnsubscribedDate(Date unsubscribedDate) {
        this.unsubscribedDate = unsubscribedDate;
    }

    public List<ETSubscriberList> getLists() {
	   if (lists == null) {
		   lists = new ArrayList<ETSubscriberList>();
	   }
	   return lists;
    }
    
    /**
     * Gets the value of the attributes property.
     */
    public List<Attribute> getAttributes() {
        if (attributes == null) {
            attributes = new ArrayList<Attribute>();
        }
        return this.attributes;
    }		

    /**
     * @deprecated
     * Use <code>getKey()</code>.
     */
    @Deprecated
    public String getSubscriberKey() {
        return getKey();
    }

    /**
     * @deprecated
     * Use <code>setKey()</code>.
     */
    @Deprecated
    public void setSubscriberKey(String subscriberKey) {
        setKey(subscriberKey);
    }

    public enum Status {
        ACTIVE("Active"),
        BOUNCED("Bounced"),
        DELETED("Deleted"),
        HELD("Held"),
        UNSUBSCRIBED("Unsubscribed");
        private final String value;

        Status(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
