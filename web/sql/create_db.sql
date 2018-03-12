--Sql server
USE master;
GO
IF DB_ID (N'musica_db') IS NOT NULL
DROP DATABASE musica_db;
GO
CREATE DATABASE musica_db;
GO
-- Verify the database files and sizes
SELECT name, size, size*1.0/128 AS [Size in MBs]
FROM sys.master_files
WHERE name = N'musica_db';
GO
