package com.databasir.dao.impl;

import com.databasir.dao.tables.pojos.TableTriggerDocumentPojo;
import lombok.Getter;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static com.databasir.dao.Tables.TABLE_TRIGGER_DOCUMENT;

@Repository
public class TableTriggerDocumentDao extends BaseDao<TableTriggerDocumentPojo> {

    @Autowired
    @Getter
    private DSLContext dslContext;

    public TableTriggerDocumentDao() {
        super(TABLE_TRIGGER_DOCUMENT, TableTriggerDocumentPojo.class);
    }

    public List<TableTriggerDocumentPojo> selectByDatabaseDocumentId(Integer schemaDocumentId) {
        return getDslContext()
                .select(TABLE_TRIGGER_DOCUMENT.fields()).from(TABLE_TRIGGER_DOCUMENT)
                .where(TABLE_TRIGGER_DOCUMENT.DATABASE_DOCUMENT_ID.eq(schemaDocumentId))
                .fetchInto(TableTriggerDocumentPojo.class);
    }

    public List<TableTriggerDocumentPojo> selectByDatabaseDocumentIdAndIdIn(Integer documentId,
                                                                            Collection<Integer> tableIdIn) {
        if (tableIdIn == null || tableIdIn.isEmpty()) {
            return Collections.emptyList();
        }
        return getDslContext()
                .select(TABLE_TRIGGER_DOCUMENT.fields()).from(TABLE_TRIGGER_DOCUMENT)
                .where(TABLE_TRIGGER_DOCUMENT.DATABASE_DOCUMENT_ID.eq(documentId)
                        .and(TABLE_TRIGGER_DOCUMENT.TABLE_DOCUMENT_ID.in(tableIdIn)))
                .fetchInto(TableTriggerDocumentPojo.class);
    }
}
