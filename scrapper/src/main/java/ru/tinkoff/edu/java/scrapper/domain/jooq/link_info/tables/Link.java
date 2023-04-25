/*
 * This file is generated by jOOQ.
 */
package ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javax.annotation.processing.Generated;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jooq.Check;
import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.Keys;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.LinkInfo;
import ru.tinkoff.edu.java.scrapper.domain.jooq.link_info.tables.records.LinkRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.18.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Link extends TableImpl<LinkRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>LINK_INFO.LINK</code>
     */
    public static final Link LINK = new Link();

    /**
     * The class holding records for this type
     */
    @Override
    @NotNull
    public Class<LinkRecord> getRecordType() {
        return LinkRecord.class;
    }

    /**
     * The column <code>LINK_INFO.LINK.ID</code>.
     */
    public final TableField<LinkRecord, Long> ID = createField(DSL.name("ID"), SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>LINK_INFO.LINK.URL</code>.
     */
    public final TableField<LinkRecord, String> URL = createField(DSL.name("URL"), SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * The column <code>LINK_INFO.LINK.TYPE</code>.
     */
    public final TableField<LinkRecord, String> TYPE = createField(DSL.name("TYPE"), SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>LINK_INFO.LINK.LAST_UPDATE</code>.
     */
    public final TableField<LinkRecord, LocalDateTime> LAST_UPDATE = createField(DSL.name("LAST_UPDATE"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("'1970-01-01 00:00:00'"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>LINK_INFO.LINK.LAST_CHECK</code>.
     */
    public final TableField<LinkRecord, LocalDateTime> LAST_CHECK = createField(DSL.name("LAST_CHECK"), SQLDataType.LOCALDATETIME(6).nullable(false).defaultValue(DSL.field(DSL.raw("'1970-01-01 00:00:00'"), SQLDataType.LOCALDATETIME)), this, "");

    /**
     * The column <code>LINK_INFO.LINK.CHAT_ID</code>.
     */
    public final TableField<LinkRecord, Long> CHAT_ID = createField(DSL.name("CHAT_ID"), SQLDataType.BIGINT.nullable(false), this, "");

    private Link(Name alias, Table<LinkRecord> aliased) {
        this(alias, aliased, null);
    }

    private Link(Name alias, Table<LinkRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>LINK_INFO.LINK</code> table reference
     */
    public Link(String alias) {
        this(DSL.name(alias), LINK);
    }

    /**
     * Create an aliased <code>LINK_INFO.LINK</code> table reference
     */
    public Link(Name alias) {
        this(alias, LINK);
    }

    /**
     * Create a <code>LINK_INFO.LINK</code> table reference
     */
    public Link() {
        this(DSL.name("LINK"), null);
    }

    public <O extends Record> Link(Table<O> child, ForeignKey<O, LinkRecord> key) {
        super(child, key, LINK);
    }

    @Override
    @Nullable
    public Schema getSchema() {
        return aliased() ? null : LinkInfo.LINK_INFO;
    }

    @Override
    @NotNull
    public Identity<LinkRecord, Long> getIdentity() {
        return (Identity<LinkRecord, Long>) super.getIdentity();
    }

    @Override
    @NotNull
    public UniqueKey<LinkRecord> getPrimaryKey() {
        return Keys.CONSTRAINT_2;
    }

    @Override
    @NotNull
    public List<ForeignKey<LinkRecord, ?>> getReferences() {
        return Arrays.asList(Keys.CONSTRAINT_23A);
    }

    private transient Chat _chat;

    /**
     * Get the implicit join path to the <code>LINK_INFO.CHAT</code> table.
     */
    public Chat chat() {
        if (_chat == null)
            _chat = new Chat(this, Keys.CONSTRAINT_23A);

        return _chat;
    }

    @Override
    @NotNull
    public List<Check<LinkRecord>> getChecks() {
        return Arrays.asList(
            Internal.createCheck(this, DSL.name("CONSTRAINT_23"), "\"TYPE\" IN('stack', 'github')", true)
        );
    }

    @Override
    @NotNull
    public Link as(String alias) {
        return new Link(DSL.name(alias), this);
    }

    @Override
    @NotNull
    public Link as(Name alias) {
        return new Link(alias, this);
    }

    @Override
    @NotNull
    public Link as(Table<?> alias) {
        return new Link(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public Link rename(String name) {
        return new Link(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public Link rename(Name name) {
        return new Link(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    @NotNull
    public Link rename(Table<?> name) {
        return new Link(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    @NotNull
    public Row6<Long, String, String, LocalDateTime, LocalDateTime, Long> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super Long, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? super Long, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super Long, ? super String, ? super String, ? super LocalDateTime, ? super LocalDateTime, ? super Long, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
