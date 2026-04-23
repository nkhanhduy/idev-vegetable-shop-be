USE vegetable_shop_db;

-- Dữ liệu mẫu (Seed Data)

-- 1. Thêm danh mục
INSERT IGNORE INTO categories (id, name, description) VALUES 
(1, 'Rau Lá', 'Các loại rau ăn lá tươi xanh'),
(2, 'Củ Quả', 'Các loại củ và quả sạch'),
(3, 'Trái Cây', 'Trái cây tươi ngon mỗi ngày');

-- 2. Thêm admin mặc định
INSERT IGNORE INTO users (email, password_hash, full_name, role) VALUES 
('admin@idev.shop', '123456', 'Quản trị viên', 'ADMIN');
