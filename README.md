# ace-database-junit-demo
Using databases with ACE JUnit tests (including setup)

## Notes

Created using DB2 on Cloud, with credentials provided before running the tests:
```
mqsisetdbparms -w C:\Users\684084897\git\ace-database-junit-demo\DatabaseTestServer -n odbc::DB2Cloud -u USERID -p PASSWORD
```

The main application requires a table to have been created before running. This table is a simple 
one copied from the [ACE demo pipeline](https://github.com/ot4i/ace-demo-pipeline/blob/6e567e2a1edd44b2db7ae27ef9036156af92ff5d/TeaSharedLibraryJava/com/ibm/ot4i/ace/pipeline/demo/tea/PostIndex_UpdateDB.java#L47):
```
CREATE TABLE Tea(id INTEGER, name VARCHAR(128))
```
and the goal is to validate the application logic with real database interactions.

The table name is overridden using a [server.conf.yaml](/DatabaseTestServer/overrides/server.conf.yaml) setting:
```
UserVariables:
  databaseReaderTableName: 'TEST_Tea'
```
and the database setup itself is performed in an `@BeforeAll` method in the test code that calls a flow to do the actual work.
