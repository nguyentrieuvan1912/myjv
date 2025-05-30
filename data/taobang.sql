create database QLLop
go
use QLLop
go
 CREATE TABLE GiaoVien(
   maGiaoVien  VARCHAR (10) primary key,
   tenGiaoVien NVARCHAR (30) NOT NULL,     
);
CREATE TABLE LopHoc(
   maLop  VARCHAR (10) primary key,
   tenLop NVARCHAR (30)  NULL,
   maGiaoVien  VARCHAR (10) ,  
   siSo int, 
   Constraint F_LP_HN Foreign key(maGiaoVien) references GiaoVien(maGiaoVien),
);
INSERT GiaoVien([maGiaoVien], [tenGiaoVien]) VALUES ('123Hoang', N'Phạm Văn Hoàng')
INSERT GiaoVien([maGiaoVien], [tenGiaoVien]) VALUES ('456Vinh', N'Lê Thế Vinh')
INSERT GiaoVien([maGiaoVien], [tenGiaoVien]) VALUES ('678Long', N'Nguyễn Ngọc Long')

INSERT LopHoc([maLop], [tenLop],[maGiaoVien],[siSo]) VALUES ('ĐH15A', N'Đại học 15A','123Hoang',50)

INSERT LopHoc([maLop], [tenLop],[maGiaoVien],[siSo]) VALUES ('ĐH14B', N'Đại học 14B','456Vinh',45)

INSERT LopHoc([maLop], [tenLop],[maGiaoVien],[siSo]) VALUES ('ĐHK16C', N'Đại học 16C','678Long',60)

INSERT LopHoc([maLop], [tenLop],[maGiaoVien],[siSo]) VALUES ('ĐH13D', N'Đại học 13D','123Hoang',57)


SELECT * 
FROM LopHoc 
JOIN GiaoVien ON LopHoc.maGiaoVien = GiaoVien.maGiaoVien;
