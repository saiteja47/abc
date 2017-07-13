package org.jlrdigital.rv.test.rvseleniumtest.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.DatabaseTestCase;
import org.dbunit.IDatabaseTester;
import org.dbunit.IOperationListener;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import static org.jlrdigital.rv.test.rvseleniumtest.utils.Variables.*;


/**
 * Created by Fraser on 11/05/2016.
 */
public class TestCase extends DatabaseTestCase {


    private static String resources = "src/main/resources/";
    private static String driver = "org.mariadb.jdbc.Driver";
    private static String port = ":3306/";
    private static String pretense = "jdbc:mariadb://";
    private String dataSetName;
    private Connection jdbcConnection;

    public Connection getJdbcConnection() {
        return jdbcConnection;
    }


    public TestCase(String string) {
        dataSetName = string;
    }

    @Override
    public IDatabaseConnection getConnection() throws Exception {

        Class.forName(driver);
        jdbcConnection = DriverManager.getConnection(getConnectionUrl(), dbUser, dbPass);
        DatabaseConnection dbConn = new DatabaseConnection(jdbcConnection);
        DatabaseConfig dbConf = dbConn.getConfig();
        dbConf.setProperty(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, true);
        dbConf.setProperty(DatabaseConfig.FEATURE_QUALIFIED_TABLE_NAMES, true);
        dbConf.setProperty(DatabaseConfig.PROPERTY_METADATA_HANDLER, new FixedMySqlMetadataHandler());

        return dbConn;
    }


    public IDatabaseTester getDatabaseTester() throws Exception {
        IDatabaseTester db1 = newDatabaseTester();
        db1.setDataSet(getDataSet());

        db1.setSetUpOperation(DatabaseOperation.INSERT);
        db1.setOperationListener(IOperationListener.NO_OP_OPERATION_LISTENER);
        db1.setTearDownOperation(DatabaseOperation.DELETE);

        return db1;
    }


    protected String getConnectionUrl() {
        return (pretense + mariaDbUrl + port);

    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder()
                .setColumnSensing(true)
                .build(new FileInputStream(resources + dataSetName));
    }

}
