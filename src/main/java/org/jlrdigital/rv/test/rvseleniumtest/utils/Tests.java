package org.jlrdigital.rv.test.rvseleniumtest.utils;

import java.io.IOException;

import org.dbunit.IDatabaseTester;
import org.dbunit.operation.DatabaseOperation;
import org.slf4j.LoggerFactory;

//import org.dbunit.IDatabaseTester;
//import org.dbunit.operation.DatabaseOperation;



/*
 * Tests Class
 * 
 * Controls the Browser (Selenium) and the Page model.
 * 
 */

public class Tests implements MandatoryMethods {

    public Browser browser;
    public Page currentPage;
    private String testName;

    private IDatabaseTester databaseTester;
    //private static String mariaDbUrl = settings.getProperty("mariaDbUrl");

    public static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger("SeleniumTests");
    public static TestCase testCase;

    @Override
    public void setUp() {

        try {
            System.out.println("Setting up parent");
            this.browser = new Browser(Variables.browserName);


         /*   if (Variables.useDBUnit.equals("true")) {
	            databaseTester = testCase.getDatabaseTester();
                testCase.getJdbcConnection().setAutoCommit(false);
                databaseTester.onSetup();
                testCase.getJdbcConnection().commit();
            }*/

        } catch (Exception e) {
            System.out.println("Data conflict");

            e.printStackTrace();
            try {
                System.out.println("attempting removal");
                if (Variables.useDBUnit.equals("true")) {
                    databaseTester.setSetUpOperation(DatabaseOperation.DELETE);
                    databaseTester.onSetup();
                    testCase.getJdbcConnection().commit();

                    databaseTester = testCase.getDatabaseTester();
	                databaseTester.onSetup();
                    testCase.getJdbcConnection().commit();
                }    


            } catch (Exception e1) {
                System.out.println("Could not remove data");
                e1.printStackTrace();
            }

        }
    }

    private void executeSqlQuery(String query) {
        try {
            testCase.getConnection().getConnection().createStatement().execute(query);
            testCase.getConnection().getConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void removeAllPswData(long pswId) {


        executeSqlQuery("delete from psw_db.psw_part where psw_id = " + pswId);
        executeSqlQuery("delete from psw_db.plant_psw where psw_id = " + pswId);
        executeSqlQuery("delete from psw_db.programme_psw where psw_id = " + pswId);
        executeSqlQuery("delete from psw_db.psw_status_history where psw_id = " + pswId);
        executeSqlQuery("delete from psw_db.supplier_check_list_lines where psw_id = " + pswId);
        executeSqlQuery("delete from psw_db.mandatory_document where psw_id = " + pswId);
        executeSqlQuery("delete from psw_db.mandatory_document_aar where psw_id= " + pswId);
        executeSqlQuery("delete from psw_db.part_submission_warrant where psw_id = " + pswId);

//        executeSqlQuery("delete from common_db.notification");
    }

    @Override
    public void tearDown() {
        try {
            databaseTester.onTearDown();
            testCase.getJdbcConnection().commit();

            databaseTester.getConnection().close();
        } catch (Exception e) {
            //System.out.println("DBUnit not used, so tearDown bypassed.");
        }

        if (testName != null) {
        	System.out.println("Test: "+testName+" complete");
        }
        testName = null;
        
        try {
        	this.browser.endSession();
        } catch(Exception e) {
        	// If the browser session is ended by another class, we don't 
        	// need to worry about closing it.
        	// e.g. The TestsForBamboo class closes the browser session by
        	// running another classes tests inside its self.
        	this.browser.endSession();
        }
    }


    protected void setLoggingName(String testName) {
    	System.out.println(" ");
        if (testName != null) {
        	System.out.println("Running "+testName);
        	this.testName = testName;
        }
    }

    public String createCharLimitString(int chars) throws IOException {
        String text = "";
        for (int i = 0; i < chars; i++) {
            text += "b";
        }
        return text;
    }

}
