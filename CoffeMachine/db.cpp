#include <sqlite3.h>

// Funktion för att ansluta till databasen
sqlite3* connectToDatabase() {
    sqlite3* db;
    int rc = sqlite3_open("coffee_machine.db", &db);

    if (rc) {
        cerr << "Can't open database: " << sqlite3_errmsg(db) << endl;
        return nullptr;
    }
    else {
        cout << "Opened database successfully" << endl;
    }
    return db;
}

// Exempelfunktion för att hämta produkter
void getProducts(sqlite3* db) {
    char* errMsg = 0;
    const char* sql = "SELECT * FROM Products";

    int rc = sqlite3_exec(db, sql, callback, 0, &errMsg);

    if (rc != SQLITE_OK) {
        cerr << "SQL error: " << errMsg << endl;
        sqlite3_free(errMsg);
    }
    else {
        cout << "Operation done successfully" << endl;
    }
}

// Callback-funktion som används av sqlite3_exec
static int callback(void* NotUsed, int argc, char** argv, char** azColName) {
    for (int i = 0; i < argc; i++) {
        cout << azColName[i] << ": " << (argv[i] ? argv[i] : "NULL") << endl;
    }
    cout << "\n";
    return 0;
}
