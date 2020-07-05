package com.mtb.manytomany.dialect;

import org.hibernate.MappingException;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

/**
 * @author MithileshB
 * @created 04/07/2020 - 7:40 PM
 * @project spring-boot-mybatis
 *  Identity column support
 *   for ex : we need to tell Hiberna te how sqlite handles @Id columns, which we can
 *   do with a custom IdentityColumnSupport implementation
 */


public class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {

    @Override
    public boolean supportsIdentityColumns() {
        return super.supportsIdentityColumns();
    }

    @Override
    public String getIdentitySelectString(String table, String column, int type) throws MappingException {
            return "select last_insert_rowid()";
    }

    @Override
    public String getIdentityColumnString(int type) throws MappingException {
        return "integer";
    }


}
