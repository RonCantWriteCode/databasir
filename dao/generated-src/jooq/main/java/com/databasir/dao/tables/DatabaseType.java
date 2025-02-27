/*
 * This file is generated by jOOQ.
 */
package com.databasir.dao.tables;


import com.databasir.dao.Databasir;
import com.databasir.dao.Keys;
import com.databasir.dao.tables.records.DatabaseTypeRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row13;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * customer database types
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DatabaseType extends TableImpl<DatabaseTypeRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>databasir.database_type</code>
     */
    public static final DatabaseType DATABASE_TYPE = new DatabaseType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatabaseTypeRecord> getRecordType() {
        return DatabaseTypeRecord.class;
    }

    /**
     * The column <code>databasir.database_type.id</code>.
     */
    public final TableField<DatabaseTypeRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>databasir.database_type.database_type</code>. such as
     * mysql, postgresql, mysql5.5 and so on
     */
    public final TableField<DatabaseTypeRecord, String> DATABASE_TYPE_ = createField(DSL.name("database_type"), SQLDataType.VARCHAR(128).nullable(false), this, "such as mysql, postgresql, mysql5.5 and so on");

    /**
     * The column <code>databasir.database_type.icon</code>.
     */
    public final TableField<DatabaseTypeRecord, String> ICON = createField(DSL.name("icon"), SQLDataType.VARCHAR(512).nullable(false).defaultValue(DSL.inline("", SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>databasir.database_type.description</code>.
     */
    public final TableField<DatabaseTypeRecord, String> DESCRIPTION = createField(DSL.name("description"), SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>databasir.database_type.jdbc_driver_file_url</code>.
     */
    public final TableField<DatabaseTypeRecord, String> JDBC_DRIVER_FILE_URL = createField(DSL.name("jdbc_driver_file_url"), SQLDataType.VARCHAR(1024).nullable(false), this, "");

    /**
     * The column <code>databasir.database_type.jdbc_driver_file_path</code>.
     */
    public final TableField<DatabaseTypeRecord, String> JDBC_DRIVER_FILE_PATH = createField(DSL.name("jdbc_driver_file_path"), SQLDataType.VARCHAR(512), this, "");

    /**
     * The column <code>databasir.database_type.jdbc_driver_class_name</code>.
     */
    public final TableField<DatabaseTypeRecord, String> JDBC_DRIVER_CLASS_NAME = createField(DSL.name("jdbc_driver_class_name"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>databasir.database_type.jdbc_protocol</code>.
     */
    public final TableField<DatabaseTypeRecord, String> JDBC_PROTOCOL = createField(DSL.name("jdbc_protocol"), SQLDataType.VARCHAR(128).nullable(false), this, "");

    /**
     * The column <code>databasir.database_type.url_pattern</code>.
     */
    public final TableField<DatabaseTypeRecord, String> URL_PATTERN = createField(DSL.name("url_pattern"), SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>databasir.database_type.deleted</code>.
     */
    public final TableField<DatabaseTypeRecord, Boolean> DELETED = createField(DSL.name("deleted"), SQLDataType.BOOLEAN.nullable(false).defaultValue(DSL.inline("0", SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>databasir.database_type.deleted_token</code>.
     */
    public final TableField<DatabaseTypeRecord, Integer> DELETED_TOKEN = createField(DSL.name("deleted_token"), SQLDataType.INTEGER.nullable(false).defaultValue(DSL.inline("0", SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>databasir.database_type.update_at</code>.
     */
    public final TableField<DatabaseTypeRecord, LocalDateTime> UPDATE_AT = createField(DSL.name("update_at"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>databasir.database_type.create_at</code>.
     */
    public final TableField<DatabaseTypeRecord, LocalDateTime> CREATE_AT = createField(DSL.name("create_at"), SQLDataType.LOCALDATETIME(0).nullable(false).defaultValue(DSL.field("CURRENT_TIMESTAMP", SQLDataType.LOCALDATETIME)), this, "");

    private DatabaseType(Name alias, Table<DatabaseTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private DatabaseType(Name alias, Table<DatabaseTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("customer database types"), TableOptions.table());
    }

    /**
     * Create an aliased <code>databasir.database_type</code> table reference
     */
    public DatabaseType(String alias) {
        this(DSL.name(alias), DATABASE_TYPE);
    }

    /**
     * Create an aliased <code>databasir.database_type</code> table reference
     */
    public DatabaseType(Name alias) {
        this(alias, DATABASE_TYPE);
    }

    /**
     * Create a <code>databasir.database_type</code> table reference
     */
    public DatabaseType() {
        this(DSL.name("database_type"), null);
    }

    public <O extends Record> DatabaseType(Table<O> child, ForeignKey<O, DatabaseTypeRecord> key) {
        super(child, key, DATABASE_TYPE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Databasir.DATABASIR;
    }

    @Override
    public Identity<DatabaseTypeRecord, Integer> getIdentity() {
        return (Identity<DatabaseTypeRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<DatabaseTypeRecord> getPrimaryKey() {
        return Keys.KEY_DATABASE_TYPE_PRIMARY;
    }

    @Override
    public List<UniqueKey<DatabaseTypeRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.KEY_DATABASE_TYPE_UK_DATABASE_TYPE_DELETED_DELETED_TOKEN);
    }

    @Override
    public DatabaseType as(String alias) {
        return new DatabaseType(DSL.name(alias), this);
    }

    @Override
    public DatabaseType as(Name alias) {
        return new DatabaseType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public DatabaseType rename(String name) {
        return new DatabaseType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public DatabaseType rename(Name name) {
        return new DatabaseType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row13 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row13<Integer, String, String, String, String, String, String, String, String, Boolean, Integer, LocalDateTime, LocalDateTime> fieldsRow() {
        return (Row13) super.fieldsRow();
    }
}
