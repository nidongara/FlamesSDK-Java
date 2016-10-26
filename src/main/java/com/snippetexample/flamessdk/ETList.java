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

import com.snippetexample.flamessdk.annotations.ExternalName;
import com.snippetexample.flamessdk.annotations.InternalName;
import com.snippetexample.flamessdk.annotations.SoapObject;
import com.exacttarget.fuelsdk.internal.List;

/**
 * An <code>ETList</code> object represents an email list
 * in the Salesforce Marketing Cloud.
 */

@SoapObject(internalType = List.class)
public class ETList extends ETSoapObject {
    @ExternalName("id")
    private String id = null;
    @ExternalName("key")
    @InternalName("customerKey")
    private String key = null;
    @ExternalName("name")
    @InternalName("listName")
    private String name = null;
    @ExternalName("description")
    private String description = null;
    @ExternalName("createdDate")
    private Date createdDate = null;
    @ExternalName("modifiedDate")
    private Date modifiedDate = null;
    @ExternalName("folderId")
    @InternalName("category")
    private Integer folderId = null;
    @ExternalName("classification")
    @InternalName("listClassification")
    private Classification classification = null;
    @ExternalName("type")
    private Type type = null;
    @ExternalName("subscribers")
    protected java.util.List<ETSubscriber> subscribers;

    public ETList() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @deprecated
     * Use <code>getKey()</code>.
     */
    @Deprecated
    public String getCustomerKey() {
        return getKey();
    }

    /**
     * @deprecated
     * Use <code>setKey()</code>.
     */
    @Deprecated
    public void setCustomerKey(String customerKey) {
        setKey(customerKey);
    }

    /**
     * @deprecated
     * Use <code>getFolderId()</code>.
     */
    @Deprecated
    public Integer getCategoryId() {
        return getFolderId();
    }

    /**
     * @deprecated
     * Use <code>setFolderId()</code>.
     */
    @Deprecated
    public void setCategoryId(Integer categoryId) {
        setFolderId(categoryId);
    }
    
    public java.util.List<ETSubscriber> getSubscribers() {
        if (subscribers == null) {
            subscribers = new ArrayList<ETSubscriber>();
        }
        return this.subscribers;
    }

    public enum Classification {
        EXACT_TARGET_LIST("ExactTargetList"),
        PUBLICATION_LIST("PublicationList"),
        SUPPRESSION_LIST("SuppressionList");
        private final String value;

        Classification(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum Type {
        GLOBAL_UNSUBSCRIBE("GlobalUnsubscribe"),
        MASTER("Master"),
        PRIVATE("Private"),
        PUBLIC("Public"),
        SALES_FORCE("SalesForce");
        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
