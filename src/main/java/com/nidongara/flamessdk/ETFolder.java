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

package com.nidongara.flamessdk;

import java.util.Date;

import com.nidongara.flamessdk.annotations.ExternalName;
import com.nidongara.flamessdk.annotations.InternalName;
import com.nidongara.flamessdk.annotations.InternalProperty;
import com.nidongara.flamessdk.annotations.SoapObject;
import com.nidongara.flamessdk.internal.DataFolder;

/**
 * An <code>ETFolder</code> object represents a folder
 * in the Salesforce Marketing Cloud.
 */

@SoapObject(internalType = DataFolder.class)
public class ETFolder extends ETSoapObject {
    @ExternalName("id")
    private String id = null;
    @ExternalName("key")
    @InternalName("customerKey")
    private String key = null;
    @ExternalName("name")
    private String name = null;
    @ExternalName("description")
    private String description = null;
    @ExternalName("createdDate")
    private Date createdDate = null;
    @ExternalName("modifiedDate")
    private Date modifiedDate = null;
    @ExternalName("contentType")
    private String contentType = null;
    @ExternalName("parentFolder")
    @InternalProperty("ParentFolder.CustomerKey")
    private ETFolder parentFolder = null;
    @ExternalName("isActive")
    private Boolean isActive = null;
    @ExternalName("isEditable")
    private Boolean isEditable = null;
    @ExternalName("allowChildren")
    private Boolean allowChildren = null;

    public ETFolder() {}

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getParentFolderKey() {
        if (parentFolder == null) {
            return null;
        }
        return parentFolder.getKey();
    }

    public void setParentFolderKey(String parentFolderKey) {
        if (parentFolder == null) {
            parentFolder = new ETFolder();
        }
        parentFolder.setKey(parentFolderKey);
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getIsEditable() {
        return isEditable;
    }

    public void setIsEditable(Boolean isEditable) {
        this.isEditable = isEditable;
    }

    public Boolean getAllowChildren() {
        return allowChildren;
    }

    public void setAllowChildren(Boolean allowChildren) {
        this.allowChildren = allowChildren;
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
     * Use <code>getParentFolderKey()</code>.
     */
    @Deprecated
    public ETFolder getParentFolder() {
        return parentFolder;
    }

    /**
     * @deprecated
     * Use <code>setParentFolderKey()</code>.
     */
    @Deprecated
    public void setParentFolder(ETFolder parentFolder) {
        this.parentFolder = parentFolder;
    }
}
