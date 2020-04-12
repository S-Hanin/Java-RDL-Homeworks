package dbutils;

import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;

public enum Connection {
    H2 {
        DataSource dataSource = null;

        @Override
        public DataSource getDataSource() {
            if (dataSource != null) {
                return dataSource;
            }
            var ds = new JdbcDataSource();
            ds.setURL("jdbc:h2:~/temp/hw");
            ds.setUser("sa");
            ds.setPassword("");
            dataSource = ds;
            return dataSource;
        }
    };

    abstract public DataSource getDataSource();
}
