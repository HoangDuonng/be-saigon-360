INSERT INTO users (id, email, name, address, phone_number, image_url, token, expiry, status, created_by, updated_by) VALUES
('user1', 'user1@example.com', 'John Doe', '288M1 Nam Ki Khoi Nghia, Vo Thi Sau, District 3, HCMC', '0383702585', 'http://example.com/images/user1.png', 'sample_token_1', '2024-12-31T23:59:59', true, 'system', 'system');

INSERT INTO roles (id, name, description, slug, created_by, updated_by) VALUES
('role1', 'Admin', 'Administrator role', 'admin', 'system', 'system'),
('role2', 'User', 'Standard user role', 'user', 'system', 'system');

INSERT INTO menu_function (id, name_en, name_vi, active, created_by, updated_by) VALUES
('menu1', 'Destinations', 'Địa điểm', true, 'system', 'system'),
('menu2', 'Review', 'Đánh giá', true, 'system', 'system'),
('menu3', 'Hotel', 'Khách sạn', true, 'system', 'system');

INSERT INTO sub_function (id, name_en, name_vi, description_en, description_vi, active, url, mfunc_id, created_by, updated_by) VALUES
('sub1', 'Ben Thanh Market', 'Chợ Bến Thành', 'Ben Thanh Market', 'Chợ Bến Thành', true, '/destinations/ben-thanh-market', 'menu1', 'system', 'system'),
('sub2', 'Metro Ben Thanh - Suoi Tien', 'Ga tàu điện Metro - Suối Tiên', 'Metro Ben Thanh - Suoi Tien', 'Ga tàu điện Metro - Suối Tiên', true, '/destinations/metro-ben-thanh-suoi-tien', 'menu1', 'system', 'system'),
('sub3', 'Saigon Notre Dame Cathedral', 'Nhà thờ Đức Bà', 'Saigon Notre Dame Cathedral', 'Nhà thờ Đức Bà', true, '/destinations/saigon-notre-dame-cathedral', 'menu1', 'system', 'system');

INSERT INTO user_roles (user_id, role_id, created_by, updated_by) VALUES
('user1', 'role1', 'system', 'system');

INSERT INTO destination (
    id, 
    name_vi, name_en, 
    address_vi, address_en, 
    open_time, 
    title_vi, title_en, 
    description_vi, description_en, 
    image_banner, 
    image_content,
    status, 
    created_by, updated_by
) VALUES

('saigon-notre-dame-cathedral', 
 'Nhà thờ Đức Bà', 'Saigon Notre Dame Cathedral', 
 '1 Công Xã Paris, Bến Nghé, Quận 1, TP.HCM', '1 Cong Xa Paris, Ben Nghe, District 1, Ho Chi Minh City', 
 '06:00 - 18:00', 
 'Nhà thờ lịch sử tại Sài Gòn', 'A historical church in Saigon', 
 'Nhà thờ Đức Bà Sài Gòn (Notre-Dame Cathedral Basilica of Saigon) là một trong những công trình kiến trúc tiêu biểu nhất của Việt Nam, mang đậm dấu ấn lịch sử và văn hóa. Được xây dựng từ năm 1880 dưới thời Pháp thuộc, nhà thờ là một biểu tượng tôn giáo và nghệ thuật kiến trúc giữa lòng Sài Gòn.

Với sự kết hợp hài hòa giữa phong cách kiến trúc Roman và Gothic, Nhà thờ Đức Bà có một thiết kế tinh tế với các mái vòm cao, cửa sổ kính màu rực rỡ và hai ngọn tháp chuông cao 60m. Đặc biệt, toàn bộ gạch đỏ xây dựng nhà thờ đều được nhập khẩu từ Marseille (Pháp), giúp công trình giữ nguyên màu sắc tự nhiên mà không cần sơn phủ.

Trải qua hơn 140 năm tồn tại, Nhà thờ Đức Bà vẫn đứng vững, trở thành điểm đến linh thiêng của cộng đồng Công giáo cũng như một biểu tượng của Sài Gòn. Trước nhà thờ là bức tượng Đức Mẹ Hòa Bình, đặt vào năm 1959, được xem như một biểu tượng thiêng liêng về hòa bình và niềm tin.', 
 'Notre-Dame Cathedral Basilica of Saigon is one of Vietnam’s most iconic architectural landmarks, embodying a rich blend of history and culture. Built in 1880 during the French colonial period, the cathedral stands as both a religious and artistic masterpiece in the heart of Saigon.

With a harmonious blend of Roman and Gothic architectural styles, the cathedral boasts towering arches, vibrant stained-glass windows, and two 60-meter-high bell towers. Notably, all the red bricks used for construction were imported from Marseille, France, ensuring the structure retains its natural color without any need for paint.

For over 140 years, Notre-Dame Cathedral has remained a sacred place for the Catholic community and a cherished symbol of Saigon. In front of the cathedral stands the Statue of Our Lady of Peace, placed in 1959, representing faith, protection, and the pursuit of peace.', 
 'saigon-notre-dame-cathedral-about1,saigon-notre-dame-cathedral-about2,saigon-notre-dame-cathedral-about3,saigon-notre-dame-cathedral-about4,saigon-notre-dame-cathedral-about5',
 'saigon-notre-dame-cathedral1,saigon-notre-dame-cathedral2,saigon-notre-dame-cathedral3',
 true, 'system', 'system');


