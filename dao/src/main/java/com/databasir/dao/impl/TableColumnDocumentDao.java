package com.databasir.dao.impl;

import com.databasir.dao.tables.pojos.TableColumnDocumentPojo;
import lombok.Getter;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.databasir.dao.Tables.TABLE_COLUMN_DOCUMENT;

@Repository
public class TableColumnDocumentDao extends BaseDao<TableColumnDocumentPojo> {

    @Autowired
    @Getter
    private DSLContext dslContext;

    public TableColumnDocumentDao() {
        super(TABLE_COLUMN_DOCUMENT, TableColumnDocumentPojo.class);
    }

    public List<TableColumnDocumentPojo> selectByDatabaseDocumentId(Integer schemaDocumentId) {
        return getDslContext()
                .select(TABLE_COLUMN_DOCUMENT.fields()).from(TABLE_COLUMN_DOCUMENT)
                .where(TABLE_COLUMN_DOCUMENT.DATABASE_DOCUMENT_ID.eq(schemaDocumentId))
                .fetchInto(TableColumnDocumentPojo.class);
    }

    public List<TableColumnDocumentPojo> selectByDatabaseDocumentIdAndTableIdIn(Integer schemaDocumentId,
                                                                                Collection<Integer> tableIdIn) {
        if (tableIdIn == null || tableIdIn.isEmpty()) {
            return Collections.emptyList();
        }
        return getDslContext()
                .select(TABLE_COLUMN_DOCUMENT.fields()).from(TABLE_COLUMN_DOCUMENT)
                .where(TABLE_COLUMN_DOCUMENT.DATABASE_DOCUMENT_ID.eq(schemaDocumentId)
                        .and(TABLE_COLUMN_DOCUMENT.TABLE_DOCUMENT_ID.in(tableIdIn)))
                .fetchInto(TableColumnDocumentPojo.class);
    }

    public List<TableColumnDocumentPojo> selectByTableDocumentId(Integer tableDocumentId) {
        return getDslContext()
                .selectFrom(TABLE_COLUMN_DOCUMENT)
                .where(TABLE_COLUMN_DOCUMENT.TABLE_DOCUMENT_ID.eq(tableDocumentId))
                .fetchInto(TableColumnDocumentPojo.class);
    }

    public boolean exists(Integer tableDocumentId, String columnName) {
        return getDslContext()
                .fetchExists(TABLE_COLUMN_DOCUMENT, TABLE_COLUMN_DOCUMENT.TABLE_DOCUMENT_ID.eq(tableDocumentId)
                        .and(TABLE_COLUMN_DOCUMENT.NAME.eq(columnName)));
    }
}
