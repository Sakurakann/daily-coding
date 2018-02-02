----------------------------------------
-- 创建一个初始值为10M,内容自动扩充的表空间 --
----------------------------------------
CREATE TABLESPACE BASE_CRUD
DATEFILE 'E:\DATE\BASE.DBF'
SIZE 10M AUTOEXTEND ON;

-- 查看创建的表空间 --
SELECT FILE_NAME, TABLESPACE_NAME, BYTES, AUTOEXTENSIBLE,
FROM DBA_DATA_FILES
WHERE TABLESPACE_NAME = 'BASE_CRUD';

-- 调整表空间的大小 --
ALTER DATABASE DATAFILE 'D:\DATA\BASE.DBF' SIZE 60M;

ALTER TABLESPACE BASE_CRUD ADD DATAFILE 'E:\DATA\ORIGINAL.DBF'
SIZE 20M AUTOEXTEND ON;

-- 删除表空间 --
DROP TABLESPACE BASE_CRUD;
-- 删除表空间及其中的数据 --
DROP TABLESPACE BASE_CRUD INCLUDING CONTENTS;

-- 创建用户 --
CREATE USER SKNN IDENTIFIED BY SAKURA
DEFAULT TABLESPACE BASE_CURD
TEMPORARY TABLESPACE TEMP
QUOTA UNLIMITED ON BASE_CRUD
PASSWORD EXPIRE;

-- 查看创建的用户 --




