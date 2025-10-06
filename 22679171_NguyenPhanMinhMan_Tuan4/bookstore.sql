CREATE DATABASE IF NOT EXISTS bookdb;
USE bookdb;

CREATE TABLE books (
    id VARCHAR(10) PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    author VARCHAR(100),
    price DOUBLE NOT NULL,
    quantity INT(11) DEFAULT 0,
    imgurl LONGTEXT,
    description TEXT
);

INSERT INTO books (id, title, author, price, quantity, imgurl, description) VALUES
('B01', 'Sổ tay viết văn', 'Tô Hoài', 99000, 10, 'so-tay-viet-van.jpg', 'Sổ tay hướng dẫn kỹ năng viết.'),
('B02', 'Nhật ký ma cà rồng 03 - Cơn thịnh nộ', '', 48000, 10, 'nhat-ky-ma-ca-rong-3.jpg', 'Tiểu thuyết giả tưởng kỳ bí.'),
('B03', 'Billy và Beth - 3 bí quyết của người thành đạt', '', 52000, 10, 'billy-beth.jpg', 'Kỹ năng phát triển bản thân.'),
('B04', 'Bí ẩn một cái tên', 'Nguyễn Hồng Dung (dịch)', 83000, 10, 'bi-an-mot-cai-chet.jpg', 'Tiểu thuyết trinh thám dịch.'),
('B05', 'Kẻ trộm sách', 'Markus Zusak', 71000, 10, 'ke-trom-sach.jpg', 'Câu chuyện về sbookdbách và chiến tranh.'),
('B06', 'Cơm & Phở', 'Xuân Sách', 120000, 10, 'com-pho.jpg', 'Sách văn hóa ẩm thực Việt.');

SELECT * FROM books