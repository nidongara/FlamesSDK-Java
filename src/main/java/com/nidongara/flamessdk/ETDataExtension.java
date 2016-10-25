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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.nidongara.flamessdk.ETDataExtensionColumn.Type;
import com.nidongara.flamessdk.annotations.ExternalName;
import com.nidongara.flamessdk.annotations.InternalName;
import com.nidongara.flamessdk.annotations.RestObject;
import com.nidongara.flamessdk.annotations.SoapObject;
import com.exacttarget.fuelsdk.internal.APIObject;
import com.exacttarget.fuelsdk.internal.APIProperty;
import com.exacttarget.fuelsdk.internal.DataExtension;
import com.exacttarget.fuelsdk.internal.DataExtensionObject;

/**
 * An <code>ETDataExtension</code> object represents a data extension
 * in the Salesforce Marketing Cloud.
 */

@RestObject(path = "/data/v1/customobjectdata/key/{key}/rowset",
            primaryKey = "key",
            collection = "items",
            totalCount = "count")
@SoapObject(internalType = DataExtension.class, unretrievable = {
    "ID", "Fields"
})
public class ETDataExtension extends ETSoapObject {
	static final int DEFAULT_PAGE_SIZE = 2500;
    private static Logger logger = Logger.getLogger(ETDataExtension.class);

    @ExternalName("id")
    @InternalName("objectID")
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
    @ExternalName("folderId")
    @InternalName("categoryID")
    private Integer folderId = null;
    @ExternalName("columns")
    @InternalName("fields")
    private List<ETDataExtensionColumn> columns = new ArrayList<ETDataExtensionColumn>();
    @ExternalName("isSendable")
    private Boolean isSendable = null;
    @ExternalName("isTestable")
    private Boolean isTestable = null;

    public ETDataExtension() {}

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

    public List<ETDataExtensionColumn> getColumns() {
        return columns;
    }

    public ETDataExtensionColumn getColumn(String name) {
        for (ETDataExtensionColumn column : columns) {
            if (column.getName().equals(name.toLowerCase())) {
                return column;
            }
        }
        return null;
    }

    public void addColumn(String name) {
        addColumn(name, null, null, null, null, null, null, null);
    }

    public void addColumn(String name, Type type) {
        addColumn(name, type, null, null, null, null, null, null);
    }

    public void addColumn(String name, Boolean isPrimaryKey) {
        addColumn(name, null, null, null, null, isPrimaryKey, null, null);
    }

    public void addColumn(String name, Type type, Boolean isPrimaryKey) {
        addColumn(name, type, null, null, null, isPrimaryKey, null, null);
    }

    public void addColumn(String name,
                          Type type,
                          Integer length,
                          Integer precision,
                          Integer scale,
                          Boolean isPrimaryKey,
                          Boolean isRequired,
                          String defaultValue)
    {
        ETDataExtensionColumn column = new ETDataExtensionColumn();
        column.setName(name.toLowerCase());
        if (type != null) {
            column.setType(type);
        } else {
            // default is text type
            column.setType(Type.TEXT);
        }
        // mimics the UI default values for length, precision, and scale
        if (column.getType() == Type.TEXT) {
            if (length != null) {
                column.setLength(length);
            } else {
                column.setLength(50);
            }
        }
        if (column.getType() == Type.DECIMAL) {
            if (precision != null) {
                column.setPrecision(precision);
            } else {
                column.setPrecision(18);
            }
            if (scale != null) {
                column.setScale(scale);
            } else {
                column.setScale(0);
            }
        }
        column.setIsPrimaryKey(isPrimaryKey);
        if (isPrimaryKey != null && isPrimaryKey) {
            column.setIsRequired(true);
        } else {
            column.setIsRequired(isRequired);
        }
        column.setDefaultValue(defaultValue);
        addColumn(column);
    }

    public void addColumn(ETDataExtensionColumn column) {
        columns.add(column);
    }

    public List<String> getColumnNames()
        throws ETSdkException
    {
        if (columns == null) {
            columns = retrieveColumns();
        }
        return getColumnNames(columns);
    }

    public Boolean getIsSendable() {
        return isSendable;
    }

    public void setIsSendable(Boolean isSendable) {
        this.isSendable = isSendable;
    }

    public Boolean getIsTestable() {
        return isTestable;
    }

    public void setIsTestable(Boolean isTestable) {
        this.isTestable = isTestable;
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


    public static ETResponse<ETDataExtensionRow> select(ETClient client,
                                                        String dataExtension,
                                                        String... filter)
        throws ETSdkException
    {
        return select(client, dataExtension, null, null, ETFilter.parse(filter));
    }

    public static ETResponse<ETDataExtensionRow> select(ETClient client,
                                                        String dataExtension,
                                                        Integer page,
                                                        Integer pageSize,
                                                        ETFilter filter)
        throws ETSdkException
    {
        String name = null;

        //
        // The data extension can be specified using key or name:
        //

        ETExpression e = ETExpression.parse(dataExtension);
        if (e.getProperty().toLowerCase().equals("key")
                && e.getOperator() == ETExpression.Operator.EQUALS) {
            name = e.getValue();
            // if no columns are explicitly requested
            // retrieve all columns
            if (filter.getProperties().isEmpty()) {
                filter.setProperties(retrieveColumnNames(client, name));
            }
        } else if (e.getProperty().toLowerCase().equals("name")
                && e.getOperator() == ETExpression.Operator.EQUALS) {
            name = e.getValue();
            // if no columns are explicitly requested
            // throw an exception
            // because we need the key
            // to retrieve columns
            if (filter.getProperties().isEmpty()) {
                throw new ETSdkException("columns must be specified "
                        + "when retrieving data extensions by name");
            }

        } else {
            throw new ETSdkException("invalid data extension filter string");
        }

        ETResponse<ETDataExtensionRow> response =
                retrieve(client,
                                      "DataExtensionObject[" + name + "]",
                                      filter,
                                      ETDataExtensionRow.class);
        
        List<ETResult<ETDataExtensionRow>> rowSet = sortRowSet(response.getResults(), filter);
        
        List<ETResult<ETDataExtensionRow>> paginatedRowSet;
           if (page == null) {
              page = response.getPage();
               if (page == null) {
                 page = 1;
             }
         }
         int iPage = page;
         if (pageSize == null) {
             pageSize = response.getPageSize();
             if (pageSize == null) {
                 pageSize = DEFAULT_PAGE_SIZE;
             }
         }
         int iPageSize = pageSize;
         int pageStart = (iPage - 1) * iPageSize;
         int pageEnd = pageStart + iPageSize;
         if (pageStart < rowSet.size()) {
             if (pageEnd > rowSet.size()) {
                 pageEnd = rowSet.size();
             }
         } else {
             pageEnd = pageStart;
         }
         paginatedRowSet = rowSet.subList(pageStart, pageEnd);
         response = createResponse(response, paginatedRowSet, page, pageSize, pageEnd, rowSet.size());
         logger.debug("final response: " + response);

        //
        // XXX reenable support for paginated retrieves via REST API
        //

//        String json = restResponse.getPayload();
//
//        JsonParser jsonParser = new JsonParser();
//        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
//
//        if (jsonObject.get("page") != null) {
//            response.setPage(jsonObject.get("page").getAsInt());
//            logger.trace("page = " + response.getPage());
//            response.setPageSize(jsonObject.get("pageSize").getAsInt());
//            logger.trace("pageSize = " + response.getPageSize());
//            response.setTotalCount(jsonObject.get("count").getAsInt());
//            logger.trace("totalCount = " + response.getTotalCount());
//
//            if (response.getPage() * response.getPageSize() < response.getTotalCount()) {
//                response.setMoreResults(true);
//            }
//
//            JsonElement elements = jsonObject.get("items");
//            if (elements != null) {
//                for (JsonElement element : elements.getAsJsonArray()) {
//                    JsonObject object = element.getAsJsonObject();
//                    ETDataExtensionRow row = new ETDataExtensionRow();
//                    JsonObject keys = object.get("keys").getAsJsonObject();
//                    for (Map.Entry<String, JsonElement> entry : keys.entrySet()) {
//                        row.setColumn(entry.getKey(), entry.getValue().getAsString(), false);
//                    }
//                    JsonObject values = object.get("values").getAsJsonObject();
//                    for (Map.Entry<String, JsonElement> entry : values.entrySet()) {
//                        row.setColumn(entry.getKey(), entry.getValue().getAsString(), false);
//                    }
//                    row.setClient(client);
//                    ETResult<ETDataExtensionRow> result = new ETResult<ETDataExtensionRow>();
//                    result.setObject(row);
//                    response.addResult(result);
//                }
//            }
//        }

        return response;
    }
    private static List<ETResult<ETDataExtensionRow>> sortRowSet(List<ETResult<ETDataExtensionRow>> rowSet, ETFilter filter) throws ETSdkException {
        logger.debug("rowSet: " + rowSet);
        logger.debug("filter: " + filter);
        if (filter.getOrderBy() != null && filter.getOrderBy().size() > 0) {
            // Sort the results
            final String orderByColumn = filter.getOrderBy().get(0).toLowerCase();
            List<String> list = filter.getProperties();
            if (list.contains(orderByColumn)) {
                final boolean sortAsc = filter.getOrderByAsc();
                List<ETResult<ETDataExtensionRow>> sortedRowSet = rowSet;
                Collections.sort(sortedRowSet, new Comparator<ETResult<ETDataExtensionRow>>() {
                    public int compare(ETResult<ETDataExtensionRow> o1, ETResult<ETDataExtensionRow> o2) {
                        if (o1.getObject().getColumn(orderByColumn) == null) {
                            return 0;
                        }
                        int result = o1.getObject().getColumn(orderByColumn).compareTo(o2.getObject().getColumn(orderByColumn));
                        return (sortAsc ? result : -result);
                    }
                });
                rowSet = sortedRowSet;
                logger.debug("sortedRowSet: " + sortedRowSet);
            } else {
                throw new ETSdkException("Can't order by '" + orderByColumn + "' as it is not in selected columns list: "
                        + list);
            }
        }
        return rowSet;
    }

    private static ETResponse<ETDataExtensionRow> createResponse(ETResponse<ETDataExtensionRow> response,
                                                                 List<ETResult<ETDataExtensionRow>> paginatedRowSet,
                                                                 Integer page, Integer pageSize, Integer pageEnd,
                                                                 Integer totalCount) {
        ETResponse<ETDataExtensionRow> pr = new ETResponse<ETDataExtensionRow>();
        pr.setResponseCode(response.getResponseCode());
        pr.setResponseMessage(response.getResponseMessage());
        pr.setStatus(response.getStatus());
        pr.setPage(page);
        pr.setPageSize(pageSize);
        pr.setTotalCount(totalCount);
        pr.setMoreResults((pageEnd < totalCount));
        pr.setRequestId(response.getRequestId());
        pr.getResults().addAll(paginatedRowSet);
        return pr;
    }
    
    public static ETResponse<ETDataExtensionRow> select(ETClient client,
                                                        String dataExtension,
                                                        Integer page,
                                                        Integer pageSize,
                                                        String... filter)
        throws ETSdkException
    {
        return select(client, dataExtension, page, pageSize, ETFilter.parse(filter));
    }

    /**
     * @deprecated
     * Pass columns in <code>filter</code> argument.
     */
    @Deprecated
    public static ETResponse<ETDataExtensionRow> select(ETClient client,
                                                        String dataExtension,
                                                        ETFilter filter,
                                                        String... columns)
        throws ETSdkException
    {
        return select(client, dataExtension, filter, null, null, columns);
    }

    /**
     * @deprecated
     * Pass columns in <code>filter</code> argument.
     */
    @Deprecated
    public static ETResponse<ETDataExtensionRow> select(ETClient client,
                                                        String dataExtension,
                                                        ETFilter filter,
                                                        Integer page,
                                                        Integer pageSize,
                                                        String... columns)
        throws ETSdkException
    {
        // use the columns parameters as the properties and
        // order by part of the filter, but override
        // the expression portion with the filter parameter
        ETFilter f = ETFilter.parse(columns);
        f.setExpression(filter.getExpression());
        return select(client, dataExtension, page, pageSize, f);
    }

    /**
     * @deprecated
     * Pass columns in <code>filter</code> argument.
     */
    @Deprecated
    public static ETResponse<ETDataExtensionRow> select(ETClient client,
                                                        String dataExtension,
                                                        String filter,
                                                        Integer page,
                                                        Integer pageSize,
                                                        String... columns)
        throws ETSdkException
    {
        return select(client, dataExtension, ETFilter.parse(filter), page, pageSize, columns);
    }

    public ETResponse<ETDataExtensionRow> select(ETFilter filter)
        throws ETSdkException
    {
        return select(null, null, filter);
    }

    public ETResponse<ETDataExtensionRow> select(String... filter)
        throws ETSdkException
    {
        return select(null, null, ETFilter.parse(filter));
    }

    public ETResponse<ETDataExtensionRow> select(Integer page,
                                                 Integer pageSize,
                                                 ETFilter filter)
        throws ETSdkException
    {
        // if no columns are explicitly requested retrieve all columns
        if (filter.getProperties().isEmpty()) {
            filter.setProperties(getColumnNames());
        }
        return select(getClient(), "key=" + getKey(), page, pageSize, filter);
    }

    public ETResponse<ETDataExtensionRow> select(Integer page,
                                                 Integer pageSize,
                                                 String... filter)
        throws ETSdkException
    {
        return select(page, pageSize, ETFilter.parse(filter));
    }

    /**
     * @deprecated
     * Pass columns in <code>filter</code> argument.
     */
    @Deprecated
    public ETResponse<ETDataExtensionRow> select(ETFilter filter,
                                                 String... columns)
        throws ETSdkException
    {
        return select(filter, null, null, columns);
    }

    /**
     * @deprecated
     * Pass columns in <code>filter</code> argument.
     */
    @Deprecated
    public ETResponse<ETDataExtensionRow> select(ETFilter filter,
                                                 Integer page,
                                                 Integer pageSize,
                                                 String... columns)
        throws ETSdkException
    {
        // use the columns parameters as the properties and
        // order by part of the filter, but override
        // the expression portion with the filter parameter
        ETFilter f = ETFilter.parse(columns);
        f.setExpression(filter.getExpression());
        // if no columns are explicitly requested retrieve all columns
        if (f.getProperties().isEmpty()) {
            f.setProperties(getColumnNames());
        }
        return select(getClient(), "key=" + getKey(), page, pageSize, f);
    }

    /**
     * @deprecated
     * Pass columns in <code>filter</code> argument.
     */
    @Deprecated
    public ETResponse<ETDataExtensionRow> select(String filter,
                                                 Integer page,
                                                 Integer pageSize,
                                                 String... columns)
        throws ETSdkException
    {
        return select(ETFilter.parse(filter), page, pageSize, columns);
    }

    public ETResponse<ETDataExtensionRow> insert(ETDataExtensionRow... rows)
        throws ETSdkException
    {
        return insert(Arrays.asList(rows));
    }

    public ETResponse<ETDataExtensionRow> insert(List<ETDataExtensionRow> rows)
        throws ETSdkException
    {
        for (ETDataExtensionRow row : rows) {
            //
            // Set the data extension name if it isn't already set:
            //

            if (row.getDataExtensionKey() == null) {
                row.setDataExtensionKey(key);
            }
        }

        return create(getClient(), rows);
    }

    public ETResponse<ETDataExtensionRow> update(ETDataExtensionRow... rows)
        throws ETSdkException
    {
        return update(Arrays.asList(rows));
    }

    public ETResponse<ETDataExtensionRow> update(List<ETDataExtensionRow> rows)
        throws ETSdkException
    {
        for (ETDataExtensionRow row : rows) {
            //
            // Set the data extension name if it isn't already set:
            //

            if (row.getDataExtensionKey() == null) {
                row.setDataExtensionKey(key);
            }
        }

        return update(getClient(), rows);
    }

    public ETResponse<ETDataExtensionRow> delete(ETDataExtensionRow... rows)
        throws ETSdkException
    {
        return delete(Arrays.asList(rows));
    }

    public ETResponse<ETDataExtensionRow> delete(List<ETDataExtensionRow> rows)
        throws ETSdkException
    {
        List<APIObject> internalRows = new ArrayList<APIObject>();

        for (ETDataExtensionRow row : rows) {
            //
            // We hand construct this one, since all we need
            // to pass in are the primary keys, and we pass them
            // in to DeleteRequest differently (in the Keys
            // property) than we received it from
            // RetrieveRequest (in the Properties property):
            //

            DataExtensionObject internalRow = new DataExtensionObject();
            DataExtensionObject.Keys keys = new DataExtensionObject.Keys();
            hydrate(); // make sure we've retrieved all columns
            for (ETDataExtensionColumn column : columns) {
                if (column.getIsPrimaryKey()) {
                    APIProperty property = new APIProperty();
                    property.setName(column.getName());
                    property.setValue(row.getColumn(property.getName()));
                    keys.getKey().add(property);
                }
            }
            internalRow.setName(name);
            internalRow.setKeys(keys);
            internalRows.add(internalRow);
        }

        // call delete method that operates on internal objects
        return delete(getClient(), internalRows, true);
    }

    public ETResponse<ETDataExtensionRow> update(String filter, String... values)
        throws ETSdkException
    {
        List<ETDataExtensionRow> rows = getMatchingRows(filter);
        for (ETDataExtensionRow row : rows) {
            for (String value : values) {
                ETExpression expression = ETExpression.parse(value);
                // must be an assign operation
                if (expression.getOperator() != ETExpression.Operator.EQUALS) {
                    throw new ETSdkException("must be an assign operation: " + expression);
                }
                row.setColumn(expression.getProperty(), expression.getValue());
            }
        }
        return update(rows);
    }

    public ETResponse<ETDataExtensionRow> delete(String filter)
        throws ETSdkException
    {
        List<ETDataExtensionRow> rows = getMatchingRows(filter);
        return delete(rows);
    }

    public void hydrate()
        throws ETSdkException
    {
        retrieveColumns();
    }

    public static List<ETDataExtensionColumn> retrieveColumns(ETClient client,
                                                              String key)
        throws ETSdkException
    {
        //
        // Automatically refresh the token if necessary:
        //

        client.refreshToken();

        //
        // Retrieve all column objects with the specified key:
        //

        ETExpression expression = new ETExpression();
        expression.setProperty("DataExtension.CustomerKey");
        expression.setOperator(ETExpression.Operator.EQUALS);
        expression.addValue(key);

        ETFilter filter = new ETFilter();
        filter.setExpression(expression);

        ETResponse<ETDataExtensionColumn> response =
                retrieve(client,
                                               ETDataExtensionColumn.class,
                                               null, // page
                                               null, // pageSize
                                               filter);

        return response.getObjects();
    }

    public List<ETDataExtensionColumn> retrieveColumns()
        throws ETSdkException
    {
        columns = retrieveColumns(getClient(), getKey());
        return columns;
    }

    private static List<String> retrieveColumnNames(ETClient client,
                                                    String key)
        throws ETSdkException
    {
        return getColumnNames(retrieveColumns(client, key));
    }

    private List<ETDataExtensionRow> getMatchingRows(String filter)
        throws ETSdkException
    {
        List<ETDataExtensionRow> rows = new ArrayList<ETDataExtensionRow>();

        hydrate(); // make sure we've retrieved all columns

        //
        // Only retrieve primary key columns:
        //

        List<String> primaryKeyColumnNames = new ArrayList<String>();
        for (ETDataExtensionColumn column : columns) {
            if (column.getIsPrimaryKey()) {
                primaryKeyColumnNames.add(column.getName());
            }
        }

        int page = 1;
        int page_size = 2500;

        ETResponse<ETDataExtensionRow> response = null;
        do {
            ETFilter parsedFilter = ETFilter.parse(filter);
            parsedFilter.setProperties(primaryKeyColumnNames);
            response = select(page++, page_size, parsedFilter);
            rows.addAll(response.getObjects());
        } while (response.hasMoreResults() == true);

        return rows;
    }

    private static List<String> getColumnNames(List<ETDataExtensionColumn> columns) {
        List<String> columnNames = new ArrayList<String>();
        for (ETDataExtensionColumn column : columns) {
            columnNames.add(column.getName());
        }
        return columnNames;
    }
}
