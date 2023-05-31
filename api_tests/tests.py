import mysql.connector

import mysql.connector

# Connect to MySQL database
conn = mysql.connector.connect(
    user='root',
    password='inventoryzut!@',
    host='localhost',
    port=3307
)

conn.database = 'inventoryzut'

cursor = conn.cursor()

cursor.execute("SHOW TABLES")
tables = cursor.fetchall()
for table in tables:
    print(f'Dropping table {table}')
    cursor.execute(f"DROP TABLE {table[0]}")

# Load and execute the init.sql file
with open('../db/init.sql', 'r') as file:
    sql_script = file.read()

# Execute the SQL script
cursor.execute(sql_script)

# Commit the changes and close the connection
conn.commit()
conn.close()