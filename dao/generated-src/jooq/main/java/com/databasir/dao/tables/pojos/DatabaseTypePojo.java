/*
 * This file is generated by jOOQ.
 */
package com.databasir.dao.tables.pojos;


import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * customer database types
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DatabaseTypePojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer       id;
    private String        databaseType;
    private String        icon;
    private String        description;
    private String        jdbcDriverFileUrl;
    private String        jdbcDriverFilePath;
    private String        jdbcDriverClassName;
    private String        jdbcProtocol;
    private String        urlPattern;
    private Boolean       deleted;
    private Integer       deletedToken;
    private LocalDateTime updateAt;
    private LocalDateTime createAt;

    public DatabaseTypePojo() {}

    public DatabaseTypePojo(DatabaseTypePojo value) {
        this.id = value.id;
        this.databaseType = value.databaseType;
        this.icon = value.icon;
        this.description = value.description;
        this.jdbcDriverFileUrl = value.jdbcDriverFileUrl;
        this.jdbcDriverFilePath = value.jdbcDriverFilePath;
        this.jdbcDriverClassName = value.jdbcDriverClassName;
        this.jdbcProtocol = value.jdbcProtocol;
        this.urlPattern = value.urlPattern;
        this.deleted = value.deleted;
        this.deletedToken = value.deletedToken;
        this.updateAt = value.updateAt;
        this.createAt = value.createAt;
    }

    public DatabaseTypePojo(
        Integer       id,
        String        databaseType,
        String        icon,
        String        description,
        String        jdbcDriverFileUrl,
        String        jdbcDriverFilePath,
        String        jdbcDriverClassName,
        String        jdbcProtocol,
        String        urlPattern,
        Boolean       deleted,
        Integer       deletedToken,
        LocalDateTime updateAt,
        LocalDateTime createAt
    ) {
        this.id = id;
        this.databaseType = databaseType;
        this.icon = icon;
        this.description = description;
        this.jdbcDriverFileUrl = jdbcDriverFileUrl;
        this.jdbcDriverFilePath = jdbcDriverFilePath;
        this.jdbcDriverClassName = jdbcDriverClassName;
        this.jdbcProtocol = jdbcProtocol;
        this.urlPattern = urlPattern;
        this.deleted = deleted;
        this.deletedToken = deletedToken;
        this.updateAt = updateAt;
        this.createAt = createAt;
    }

    /**
     * Getter for <code>databasir.database_type.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Setter for <code>databasir.database_type.id</code>.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for <code>databasir.database_type.database_type</code>. such as
     * mysql, postgresql, mysql5.5 and so on
     */
    public String getDatabaseType() {
        return this.databaseType;
    }

    /**
     * Setter for <code>databasir.database_type.database_type</code>. such as
     * mysql, postgresql, mysql5.5 and so on
     */
    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    /**
     * Getter for <code>databasir.database_type.icon</code>.
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * Setter for <code>databasir.database_type.icon</code>.
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Getter for <code>databasir.database_type.description</code>.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for <code>databasir.database_type.description</code>.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for <code>databasir.database_type.jdbc_driver_file_url</code>.
     */
    public String getJdbcDriverFileUrl() {
        return this.jdbcDriverFileUrl;
    }

    /**
     * Setter for <code>databasir.database_type.jdbc_driver_file_url</code>.
     */
    public void setJdbcDriverFileUrl(String jdbcDriverFileUrl) {
        this.jdbcDriverFileUrl = jdbcDriverFileUrl;
    }

    /**
     * Getter for <code>databasir.database_type.jdbc_driver_file_path</code>.
     */
    public String getJdbcDriverFilePath() {
        return this.jdbcDriverFilePath;
    }

    /**
     * Setter for <code>databasir.database_type.jdbc_driver_file_path</code>.
     */
    public void setJdbcDriverFilePath(String jdbcDriverFilePath) {
        this.jdbcDriverFilePath = jdbcDriverFilePath;
    }

    /**
     * Getter for <code>databasir.database_type.jdbc_driver_class_name</code>.
     */
    public String getJdbcDriverClassName() {
        return this.jdbcDriverClassName;
    }

    /**
     * Setter for <code>databasir.database_type.jdbc_driver_class_name</code>.
     */
    public void setJdbcDriverClassName(String jdbcDriverClassName) {
        this.jdbcDriverClassName = jdbcDriverClassName;
    }

    /**
     * Getter for <code>databasir.database_type.jdbc_protocol</code>.
     */
    public String getJdbcProtocol() {
        return this.jdbcProtocol;
    }

    /**
     * Setter for <code>databasir.database_type.jdbc_protocol</code>.
     */
    public void setJdbcProtocol(String jdbcProtocol) {
        this.jdbcProtocol = jdbcProtocol;
    }

    /**
     * Getter for <code>databasir.database_type.url_pattern</code>.
     */
    public String getUrlPattern() {
        return this.urlPattern;
    }

    /**
     * Setter for <code>databasir.database_type.url_pattern</code>.
     */
    public void setUrlPattern(String urlPattern) {
        this.urlPattern = urlPattern;
    }

    /**
     * Getter for <code>databasir.database_type.deleted</code>.
     */
    public Boolean getDeleted() {
        return this.deleted;
    }

    /**
     * Setter for <code>databasir.database_type.deleted</code>.
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * Getter for <code>databasir.database_type.deleted_token</code>.
     */
    public Integer getDeletedToken() {
        return this.deletedToken;
    }

    /**
     * Setter for <code>databasir.database_type.deleted_token</code>.
     */
    public void setDeletedToken(Integer deletedToken) {
        this.deletedToken = deletedToken;
    }

    /**
     * Getter for <code>databasir.database_type.update_at</code>.
     */
    public LocalDateTime getUpdateAt() {
        return this.updateAt;
    }

    /**
     * Setter for <code>databasir.database_type.update_at</code>.
     */
    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * Getter for <code>databasir.database_type.create_at</code>.
     */
    public LocalDateTime getCreateAt() {
        return this.createAt;
    }

    /**
     * Setter for <code>databasir.database_type.create_at</code>.
     */
    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DatabaseTypePojo (");

        sb.append(id);
        sb.append(", ").append(databaseType);
        sb.append(", ").append(icon);
        sb.append(", ").append(description);
        sb.append(", ").append(jdbcDriverFileUrl);
        sb.append(", ").append(jdbcDriverFilePath);
        sb.append(", ").append(jdbcDriverClassName);
        sb.append(", ").append(jdbcProtocol);
        sb.append(", ").append(urlPattern);
        sb.append(", ").append(deleted);
        sb.append(", ").append(deletedToken);
        sb.append(", ").append(updateAt);
        sb.append(", ").append(createAt);

        sb.append(")");
        return sb.toString();
    }
}
