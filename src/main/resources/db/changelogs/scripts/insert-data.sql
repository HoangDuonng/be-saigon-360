INSERT INTO users (id, email, name, image_url, token, expiry, status, created_by, updated_by) VALUES
('user1', 'user1@example.com', 'John Doe', 'http://example.com/images/user1.png', 'sample_token_1', '2024-12-31T23:59:59', true, 'system', 'system');

INSERT INTO roles (id, name, description, slug, created_by, updated_by) VALUES
('role1', 'Admin', 'Administrator role', 'admin', 'system', 'system'),
('role2', 'User', 'Standard user role', 'user', 'system', 'system');

INSERT INTO menu_function (id, name_en, name_vi, active, created_by, updated_by) VALUES
('menu1', 'Destinations', 'Điểm du lịch', true, 'system', 'system'),
('menu2', 'VirtualTour', 'VirtualTour', true, 'system', 'system');

INSERT INTO sub_function (id, name_en, name_vi, description_en, description_vi, active, url, mfunc_id, created_by, updated_by) VALUES
('sub1', 'Ho Chi Minh Book Street ', 'Đường sách Thành phố', 'Đường sách Thành phố', 'Đường sách Thành phố', true, '/destinations/book-street', 'menu1', 'system', 'system'),
('sub2', 'Saigon Notre Dame Cathedral', 'Nhà thờ Đức Bà', 'Saigon Notre Dame Cathedral', 'Nhà thờ Đức Bà', true, '/destinations/saigon-notre-dame-cathedral', 'menu1', 'system', 'system'),
('sub3', 'Metro Ben Thanh - Suoi Tien', 'Ga tàu điện Metro - Suối Tiên', 'Metro Ben Thanh - Suoi Tien', 'Ga tàu điện Metro - Suối Tiên', true, '/destinations/metro-ben-thanh-suoi-tien', 'menu1', 'system', 'system'),
('sub4', 'Ben Thanh Market', 'Chợ Bến Thành', 'Ben Thanh Market', 'Chợ Bến Thành', true, '/destinations/ben-thanh-market', 'menu1', 'system', 'system'),
('sub5', 'Ho Chi Minh Book Street Virtual Panorama', 'Đường sách Thành phố', 'Đường sách Thành phố', 'Đường sách Thành phố', true, '/panoramas/book-street', 'menu2', 'system', 'system'),
('sub6', 'Saigon Notre Dame Cathedral Virtual Panorama', 'Nhà thờ Đức Bà', 'Saigon Notre Dame Cathedral', 'Nhà thờ Đức Bà', true, '/panoramas/saigon-notre-dame-cathedral', 'menu2', 'system', 'system'),
('sub7', 'Metro Ben Thanh - Suoi Tien Virtual Panorama', 'Ga tàu điện Metro - Suối Tiên', 'Metro Ben Thanh - Suối Tiên', 'Ga tàu điện Metro - Suối Tiên', true, '/panoramas/metro-ben-thanh-suoi-tien', 'menu2', 'system', 'system'),
('sub8', 'Ben Thanh Market Virtual', 'Chợ Bến Thành Panorama', 'Ben Thanh Market', 'Chợ Bến Thành', true, '/panoramas/ben-thanh-market', 'menu2', 'system', 'system');

INSERT INTO user_roles (user_id, role_id, created_by, updated_by) VALUES
('user1', 'role1', 'system', 'system');

INSERT INTO destination (
    id, 
    name_vi, name_en, 
    address_vi, address_en, 
    open_time, 
    title_vi, title_en, 
    description_vi, description_en, 
    content_vi,
    content_en,
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
 'Vương Cung Thánh Đường Đức Bà Sài Gòn là một công trình kiến trúc mang tính biểu tượng, thể hiện bề dày lịch sử và di sản văn hóa của Thành phố Hồ Chí Minh. Được xây dựng vào cuối thế kỷ 19 dưới thời Pháp thuộc, nhà thờ là một kiệt tác của kiến trúc Romanesque với mặt tiền gạch đỏ nổi bật, hai tháp chuông cao vút và những ô cửa kính màu tinh xảo.

Nằm ngay trung tâm thành phố, nhà thờ không chỉ là nơi hành lễ mà còn là một điểm đến thu hút đông đảo du khách. Không gian trang nghiêm cùng giá trị lịch sử đặc biệt khiến nơi đây trở thành địa điểm không thể bỏ qua đối với những ai muốn khám phá quá khứ của thành phố và chiêm ngưỡng vẻ đẹp kiến trúc. Là một trong những công trình mang tính biểu tượng nhất của Sài Gòn, nhà thờ Đức Bà vẫn là minh chứng cho sự giao thoa giữa lịch sử, tín ngưỡng và nét đẹp vượt thời gian của thành phố.', 
 'Notre-Dame Cathedral Basilica of Saigon is an iconic architectural landmark, symbolizing the rich history and cultural heritage of Ho Chi Minh City. Built in the late 19th century during the French colonial period, the cathedral stands as a masterpiece of neo-Romanesque architecture with its striking red brick facade, twin bell towers, and intricate stained glass windows.

Located in the heart of the city, it serves as both a place of worship and a popular tourist attraction. The cathedrals serene ambiance and historical significance make it a must-visit destination for those seeking to explore the citys past and admire its architectural beauty. As one of Saigons most treasured landmarks, it continues to be a testament to the citys blend of history, faith, and timeless elegance.', 
 'Vương Cung Thánh Đường Đức Bà Sài Gòn, một viên ngọc kiến trúc Pháp giữa lòng Sài Gòn, không chỉ là một địa điểm tôn giáo mà còn là một phần không thể thiếu trong bức tranh văn hóa của thành phố. Bắt đầu xây dựng vào năm 1877 và hoàn thành năm 1880, nhà thờ được thiết kế bởi kiến trúc sư J. Bourard, mang đậm phong cách Roman cải tiến kết hợp Gothic, tạo nên vẻ đẹp vừa tráng lệ vừa cổ kính.

Điều đặc biệt của nhà thờ là tất cả vật liệu xây dựng, từ xi măng, sắt thép đến gạch ngói, đều được nhập khẩu từ Pháp, đảm bảo chất lượng và độ bền vững của công trình. Gạch sử dụng để xây dựng mặt ngoài nhà thờ được làm thủ công, không tô trát, giữ nguyên màu đỏ cam tự nhiên, tạo nên vẻ đẹp độc đáo và ấn tượng.

Bên trong nhà thờ là không gian rộng lớn, thoáng đãng với những hàng cột cao vút, các ô cửa kính màu rực rỡ và hệ thống đèn chiếu sáng tinh tế, tạo nên một bầu không khí trang nghiêm và linh thiêng. Trên tường nhà thờ là những bức tranh và phù điêu mô tả các sự kiện trong Kinh Thánh, mang đến cho du khách cái nhìn sâu sắc về lịch sử và văn hóa Công giáo.

Ngoài ra, nhà thờ còn nổi tiếng với hệ thống chuông gồm 6 chiếc, được đúc tại Pháp và mang về Việt Nam vào năm 1879. Mỗi chiếc chuông có một âm vực khác nhau, khi hòa quyện lại tạo nên một bản nhạc du dương và thánh thót, vang vọng khắp khu vực trung tâm thành phố.

Nhà thờ Đức Bà không chỉ là một biểu tượng tôn giáo mà còn là một điểm đến du lịch hấp dẫn, thu hút hàng triệu du khách mỗi năm. Đến đây, du khách không chỉ được chiêm ngưỡng vẻ đẹp kiến trúc độc đáo mà còn được tìm hiểu về lịch sử, văn hóa và tín ngưỡng của người dân Sài Gòn. Nhà thờ còn là nơi diễn ra nhiều sự kiện quan trọng của thành phố, như lễ Giáng Sinh, lễ Phục Sinh và các buổi hòa nhạc, thu hút sự quan tâm của đông đảo công chúng.',

 'Saigon Notre Dame Cathedral, a French architectural gem in the heart of Saigon, is not only a religious site but also an integral part of the citys cultural tapestry. Construction began in 1877 and was completed in 1880. The cathedral was designed by architect J. Bourard, featuring a neo-Roman style combined with Gothic elements, creating a majestic and antique beauty.

What is special about the cathedral is that all building materials, from cement, steel to bricks and tiles, were imported from France, ensuring the quality and sustainability of the project. The bricks used to build the exterior of the church are handmade, without plastering, keeping the natural red-orange color, creating a unique and impressive beauty.

Inside the cathedral is a large, airy space with soaring columns, colorful stained glass windows, and sophisticated lighting, creating a solemn and sacred atmosphere. On the walls of the church are paintings and reliefs depicting events in the Bible, giving visitors a deep insight into Catholic history and culture.

In addition, the church is also famous for its bell system consisting of 6 bells, cast in France and brought to Vietnam in 1879. Each bell has a different pitch, which when mixed together creates a melodious and sacred piece of music, echoing throughout the central area of the city.

Notre Dame Cathedral is not only a religious symbol but also an attractive tourist destination, attracting millions of visitors every year. Coming here, visitors can not only admire the unique architectural beauty but also learn about the history, culture and beliefs of the people of Saigon. The church is also the venue for many important events of the city, such as Christmas, Easter and concerts, attracting the attention of a large audience.', 
 'saigon-notre-dame-cathedral-about1,saigon-notre-dame-cathedral-about2,saigon-notre-dame-cathedral-about3,saigon-notre-dame-cathedral-about4,saigon-notre-dame-cathedral-about5',
 'saigon-notre-dame-cathedral1,saigon-notre-dame-cathedral2',
 true, 'system', 'system'),

('book-street',
 'Đường Sách TP.HCM', 'Ho Chi Minh City Book Street',
 'Đường Nguyễn Văn Bình, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'Nguyen Van Binh Street, Ben Nghe Ward, District 1, Ho Chi Minh City',
 '09:00 - 22:00',
 'Thiên đường sách giữa lòng Sài Gòn', 'A book paradise in the heart of Saigon',
 'Đường Sách Thành phố Hồ Chí Minh là một không gian văn hóa độc đáo, nuôi dưỡng niềm đam mê đọc sách và tri thức. Nằm ngay trung tâm thành phố, con phố đi bộ này được bao quanh bởi các hiệu sách, quán cà phê và khu trưng bày, tạo nên một bầu không khí hấp dẫn dành cho những người yêu sách ở mọi lứa tuổi.

Không chỉ là nơi mua sách, phố sách còn là một trung tâm giao lưu sôi động, nơi các tác giả, học giả và độc giả có thể kết nối thông qua các buổi ký tặng sách, tọa đàm và sự kiện văn học. Nhiều hoạt động văn hóa, giáo dục được tổ chức thường xuyên, biến nơi đây thành một không gian đầy sức sống, khuyến khích học tập suốt đời.

Với sự kết hợp giữa kiến trúc hiện đại và truyền thống, những lối đi rợp bóng cây và không gian yên bình, Phố Sách Thành phố Hồ Chí Minh mang đến một góc thư giãn giữa nhịp sống sôi động của đô thị. Không chỉ là điểm đến dành cho những người yêu sách, nơi đây còn là biểu tượng cho sự phát triển trí tuệ và văn hóa của thành phố.',

 'Ho Chi Minh City Book Street is a unique cultural space that fosters a love for reading and knowledge. Nestled in the heart of the city, this pedestrian-friendly street is lined with bookstores, cafés, and exhibition areas, creating an inviting atmosphere for book lovers of all ages.
Beyond being a place to buy books, it serves as a vibrant community hub where authors, scholars, and readers can connect through book signings, discussions, and literary events. Regular cultural and educational activities are organized, making it a dynamic space that promotes lifelong learning.With its blend of modern and traditional architecture, shaded walkways, and tranquil ambiance, Ho Chi Minh City Book Street offers a peaceful retreat from the citys hustle and bustle. It is not only a destination for book enthusiasts but also a symbol of the citys commitment to intellectual and cultural enrichment',
 'Đường Sách TP.HCM, một điểm đến văn hóa không thể bỏ qua, là nơi hội tụ của tri thức và nghệ thuật giữa lòng Sài Gòn. Được khánh thành vào năm 2016, con đường này nhanh chóng trở thành một biểu tượng văn hóa mới của thành phố, thu hút hàng ngàn lượt khách mỗi ngày. Không chỉ là nơi mua bán sách, Đường Sách còn là một không gian cộng đồng, nơi diễn ra các hoạt động văn hóa, nghệ thuật và giáo dục đa dạng.

Với chiều dài khoảng 144 mét, Đường Sách Nguyễn Văn Bình tập trung nhiều gian hàng sách của các nhà xuất bản, công ty phát hành sách uy tín trong cả nước. Tại đây, bạn có thể tìm thấy đủ loại sách, từ văn học kinh điển đến sách thiếu nhi, từ sách khoa học đến sách kinh tế. Ngoài ra, Đường Sách còn có nhiều quán cà phê sách, nơi bạn có thể thư giãn đọc sách và thưởng thức đồ uống.

Đường Sách cũng thường xuyên tổ chức các sự kiện văn hóa, như giao lưu với tác giả, giới thiệu sách mới, triển lãm sách, và các hoạt động dành cho trẻ em. Các sự kiện này thu hút sự tham gia của đông đảo người dân và du khách, tạo nên một không khí sôi động và náo nhiệt.

Không gian kiến trúc của Đường Sách cũng là một điểm nhấn đặc biệt. Con đường được thiết kế theo phong cách hiện đại, kết hợp với các yếu tố truyền thống, tạo nên một không gian hài hòa và thân thiện. Những hàng cây xanh mát, những chiếc ghế đá xinh xắn và những tác phẩm nghệ thuật sắp đặt độc đáo tạo nên một không gian lý tưởng để thư giãn và tận hưởng văn hóa đọc.',

 'Ho Chi Minh City Book Street, a must-visit cultural destination, is a hub of knowledge and art in the heart of Saigon. Inaugurated in 2016, this street quickly became a new cultural symbol of the city, attracting thousands of visitors every day. More than just a place to buy and sell books, Book Street is also a community space, where diverse cultural, artistic and educational activities take place.

With a length of about 144 meters, Nguyen Van Binh Book Street focuses on many book stalls of reputable publishers and book distributors across the country. Here, you can find all kinds of books, from classic literature to children books, from science books to economics books. In addition, Book Street also has many book cafes, where you can relax read books and enjoy drinks.

Book Street also regularly organizes cultural events, such as exchanges with authors, new book introductions, book exhibitions, and activities for children. These events attract the participation of a large number of people and tourists, creating a lively and bustling atmosphere.

The architectural space of Book Street is also a special highlight. The road is designed in a modern style, combined with traditional elements, creating a harmonious and friendly space. The rows of green trees, the lovely stone chairs and the unique art installations create an ideal space to relax and enjoy reading culture.',
 'duongsach1,duongsach2,duongsach3,duongsach4,duongsach5',
 'duongsach1,duongsach2,duongsach3,duongsach4,duongsach5',
 true, 'system', 'system'),

('metro-ben-thanh-suoi-tien',
 'Tuyến Metro Bến Thành - Suối Tiên', 'Ben Thanh - Suoi Tien Metro Line',
 'Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'Ben Thanh, District 1, Ho Chi Minh City',
 '05:00 - 23:00',
 'Tuyến Metro hiện đại đầu tiên của TP.HCM', 'Ho Chi Minh Citys first modern metro line',
 'Tuyến Metro Bến Thành - Suối Tiên là tuyến đường sắt đô thị đầu tiên tại Thành phố Hồ Chí Minh, đánh dấu một cột mốc quan trọng trong hệ thống giao thông của thành phố. Được thiết kế nhằm giảm ùn tắc giao thông và cung cấp một hệ thống vận tải công cộng hiện đại, hiệu quả, tuyến metro này kết nối khu trung tâm sầm uất với các quận phía Đông đang phát triển nhanh chóng.

Trải dài qua nhiều ga, tuyến metro giúp tăng cường kết nối giữa các khu vực thương mại, giáo dục và dân cư, giúp việc đi lại hàng ngày trở nên nhanh chóng và thuận tiện hơn. Với công nghệ tiên tiến và cam kết phát triển bền vững, tuyến metro này hướng đến việc cách mạng hóa giao thông đô thị và khuyến khích người dân sử dụng phương tiện công cộng.

Không chỉ là một hệ thống giao thông, tuyến Metro Bến Thành - Suối Tiên còn thể hiện bước tiến của Thành phố Hồ Chí Minh trên con đường trở thành một đô thị năng động và hiện đại. Đây là biểu tượng của sự đổi mới, hứa hẹn nâng cao chất lượng sống đô thị và thúc đẩy tăng trưởng kinh tế cho thành phố và cư dân.',

 'The Ben Thanh - Suoi Tien Metro Line is the first urban railway line in Ho Chi Minh City, marking a significant milestone in the citys transportation infrastructure. Designed to ease traffic congestion and provide a modern, efficient public transit system, this metro line connects the bustling downtown area with the rapidly developing eastern districts.

Stretching over multiple stations, the metro line enhances connectivity between key commercial, educational, and residential areas, making daily commutes faster and more convenient. With advanced technology and a commitment to sustainability, it aims to revolutionize urban mobility and encourage a shift towards public transportation.

Beyond its role as a transit system, the Ben Thanh - Suoi Tien Metro Line represents Ho Chi Minh Citys progress toward becoming a more dynamic and future-ready metropolis. It is a symbol of modernization, promising improved urban living and economic growth for the city and its residents.',
  'Tuyến Metro Bến Thành - Suối Tiên, dự án giao thông trọng điểm của TP.HCM, không chỉ là một phương tiện di chuyển mà còn là biểu tượng của sự phát triển và hiện đại hóa. Khởi công xây dựng vào năm 2012, tuyến metro này đánh dấu một bước ngoặt quan trọng trong việc cải thiện hệ thống giao thông công cộng của thành phố. Với tổng chiều dài gần 20km, tuyến metro đi qua nhiều quận trung tâm và khu vực phía Đông, kết nối Bến Thành với Khu Du Lịch Văn Hóa Suối Tiên.

Tuyến metro được thiết kế với công nghệ tiên tiến, đảm bảo an toàn, tiện nghi và thân thiện với môi trường. Các nhà ga được xây dựng hiện đại, trang bị đầy đủ tiện ích cho hành khách, như thang cuốn, thang máy, hệ thống thông tin điện tử và khu vực chờ thoải mái.

Không chỉ giúp giảm ùn tắc giao thông, tuyến metro còn mang đến nhiều lợi ích khác cho thành phố. Nó giúp kết nối các khu vực kinh tế, văn hóa và du lịch, tạo điều kiện thuận lợi cho việc phát triển kinh tế - xã hội. Ngoài ra, tuyến metro còn góp phần giảm ô nhiễm môi trường, khuyến khích người dân sử dụng phương tiện công cộng.',

 'The Ben Thanh - Suoi Tien Metro Line, a key transportation project of Ho Chi Minh City, is not only a means of transportation but also a symbol of development and modernization. Construction started in 2012, this metro line marks an important milestone in improving the citys public transport system. With a total length of nearly 20km, the metro line passes through many central districts and the eastern region, connecting Ben Thanh with Suoi Tien Cultural Tourist Area.

The metro line is designed with advanced technology, ensuring safety, convenience and environmental friendliness. The stations are built in a modern style, fully equipped with facilities for passengers, such as escalators, elevators, electronic information systems and comfortable waiting areas.

Not only does it help reduce traffic congestion, the metro line also brings many other benefits to the city. It helps connect economic, cultural and tourism areas, creating favorable conditions for socio-economic development. In addition, the metro line also contributes to reducing environmental pollution, encouraging people to use public transport.',
 'metro-ben-thanh-suoi-tien-about1,metro-ben-thanh-suoi-tien-about2',
 'metro-ben-thanh-suoi-tien1,metro-ben-thanh-suoi-tien2',
 true, 'system', 'system'),

('ben-thanh-market',
 'Chợ Bến Thành', 'Ben Thanh Market',
 'Lê Lợi, Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'Le Loi Street, Ben Thanh Ward, District 1, Ho Chi Minh City',
 '07:00 - 19:00',
 'Biểu tượng lịch sử và văn hóa của Sài Gòn', 'A historical and cultural icon of Saigon',
 'Chợ Bến Thành là một trong những địa danh lâu đời và nổi tiếng nhất của Sài Gòn. Nằm ngay trung tâm thành phố, chợ đã là một trung tâm thương mại và văn hóa sôi động suốt hơn một thế kỷ. Tại đây, du khách có thể khám phá vô số mặt hàng, từ đồ thủ công mỹ nghệ và quà lưu niệm địa phương đến nông sản tươi sống và ẩm thực truyền thống Việt Nam.

Không chỉ là một điểm mua sắm, Chợ Bến Thành còn là biểu tượng văn hóa phản ánh tinh thần của Sài Gòn. Kiến trúc mang dấu ấn lịch sử, những gian hàng nhộn nhịp và sự đa dạng của các sản phẩm khiến nơi đây trở thành điểm đến không thể bỏ qua đối với cả người dân địa phương và du khách. Dù là để thưởng thức hương vị ẩm thực đường phố chính gốc hay tìm kiếm những món hàng độc đáo, một chuyến ghé thăm chợ sẽ mang đến cái nhìn chân thực về di sản phong phú và nhịp sống sôi động của thành phố.',
 'Ben Thanh Market is one of Saigons oldest and most famous landmarks. Located in the heart of the city, it has been a bustling hub of commerce and culture for over a century. The market offers a vibrant atmosphere where visitors can explore a wide variety of goods, from local handicrafts and souvenirs to fresh produce and traditional Vietnamese cuisine.

Beyond being a shopping destination, Ben Thanh Market is a cultural icon that reflects the spirit of Saigon. Its historic architecture, lively stalls, and diverse range of products make it a must-visit spot for both locals and tourists. Whether experiencing the flavors of authentic street food or bargaining for unique items, a visit to this market provides a glimpse into the citys rich heritage and dynamic lifestyle.',
 'Chợ Bến Thành, một biểu tượng của Sài Gòn, không chỉ là một khu chợ truyền thống mà còn là một chứng nhân lịch sử, một không gian văn hóa độc đáo. Chợ được xây dựng vào năm 1912, thay thế cho khu chợ cũ nằm bên bờ sông Bến Nghé. Với kiến trúc mang đậm phong cách Pháp, chợ Bến Thành nhanh chóng trở thành một trong những điểm nhấn của thành phố.

Tại chợ Bến Thành, bạn có thể tìm thấy mọi thứ, từ quần áo, giày dép, đồ thủ công mỹ nghệ đến các loại thực phẩm tươi sống, đặc sản địa phương và quà lưu niệm. Chợ được chia thành nhiều khu vực khác nhau, mỗi khu vực chuyên bán một loại hàng hóa riêng. Khu vực ẩm thực là nơi tập trung nhiều món ăn đường phố nổi tiếng của Sài Gòn, như bún riêu, bánh xèo, gỏi cuốn, và nhiều món ăn đặc trưng khác của miền Nam.

Không gian chợ luôn sôi động và náo nhiệt, với tiếng rao hàng, tiếng mặc cả, và những câu chuyện đời thường của người bán hàng. Đến chợ Bến Thành, bạn sẽ có cơ hội trải nghiệm một phần không thể thiếu của cuộc sống Sài Gòn. Chợ không chỉ là nơi mua bán hàng hóa mà còn là một điểm đến du lịch hấp dẫn, thu hút hàng triệu du khách mỗi năm.

Chợ Bến Thành không chỉ là một biểu tượng của Sài Gòn mà còn là một phần của lịch sử và văn hóa Việt Nam. Chợ đã chứng kiến nhiều sự kiện quan trọng của thành phố, từ thời kỳ Pháp thuộc đến những năm tháng chiến tranh và hòa bình. Chợ Bến Thành vẫn luôn là một điểm đến quen thuộc của người dân Sài Gòn và du khách thập phương.',
 'Ben Thanh Market, a symbol of Saigon, is not only a traditional market but also a historical witness, a unique cultural space. The market was built in 1912, replacing the old market located on the banks of the Ben Nghe River. With architecture imbued with French style, Ben Thanh Market quickly became one of the highlights of the city.

At Ben Thanh Market, you can find everything, from clothes, shoes, handicrafts to fresh food, local specialties and souvenirs. The market is divided into many different areas, each area specializing in selling a separate type of goods. The culinary area is where many famous street food dishes of Saigon are concentrated, such as bun rieu, banh xeo, spring rolls, and many other typical dishes of the South.

The market space is always bustling and lively, with the sound of hawking, bargaining, and everyday stories of vendors. Coming to Ben Thanh Market, you will have the opportunity to experience an integral part of Saigon life. The market is not only a place to buy and sell goods but also an attractive tourist destination, attracting millions of tourists every year.

Ben Thanh Market is not only a symbol of Saigon but also a part of Vietnamese history and culture. The market has witnessed many important events of the city, from the French colonial period to the years of war and peace. Ben Thanh Market has always been a familiar destination for Saigon people and tourists from all over the world.',
 'ben-thanh-market-about1,ben-thanh-market-about2',
 'ben-thanh-market1,ben-thanh-market2',
 true, 'system', 'system');

INSERT INTO favorite_destinations (id, user_id, destination_id, created_by, updated_by) VALUES
('fav1', 'user1', 'saigon-notre-dame-cathedral', 'system', 'system'),
('fav2', 'user1', 'book-street', 'system', 'system'),
('fav3', 'user1', 'metro-ben-thanh-suoi-tien', 'system', 'system'),
('fav4', 'user1', 'ben-thanh-market', 'system', 'system');