-- Bảng users
CREATE TABLE users (
    id VARCHAR(255) PRIMARY KEY,
    email VARCHAR(255),
    name VARCHAR(150),
    address VARCHAR(150),
    phone_number VARCHAR(20),
    image_url VARCHAR(255),
    token TEXT,
    expiry TIMESTAMP,
    status BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Bảng role
CREATE TABLE roles (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    slug TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Bảng menu_function
CREATE TABLE menu_function (
    id VARCHAR(255) PRIMARY KEY,
    name_en VARCHAR(255),
    name_vi VARCHAR(255),
    active BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Bảng sub_function
CREATE TABLE sub_function (
    id VARCHAR(255) PRIMARY KEY,
    name_en VARCHAR(255),
    name_vi VARCHAR(255),
    description_en TEXT,
    description_vi TEXT,
    active BOOLEAN,
    url TEXT,
    mfunc_id VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

-- Bảng user_roles (nhiều-nhiều giữa users và role)
CREATE TABLE user_roles (
    user_id VARCHAR(255),
    role_id VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    PRIMARY KEY (user_id, role_id)
);

CREATE TABLE destination (
    id VARCHAR(255) PRIMARY KEY,
    name_vi VARCHAR(255),
    name_en VARCHAR(255),
    address_vi VARCHAR(255),
    address_en VARCHAR(255),
    open_time VARCHAR(100),
    title_vi VARCHAR(255), 
    title_en VARCHAR(255), 
    description_vi TEXT, 
    description_en TEXT, 
    content_vi TEXT,
    content_en TEXT,
    image_banner VARCHAR(255),
    image_content VARCHAR(255),
    status BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255)
);

------------------------------
-- Email unique
ALTER TABLE users
ADD CONSTRAINT uq_users_email UNIQUE (email);

-- sub_function - menu_function
ALTER TABLE sub_function
ADD CONSTRAINT fk_sub_menu FOREIGN KEY (mfunc_id) REFERENCES menu_function (id);

-- user_roles - users
ALTER TABLE user_roles
ADD CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;

-- user_roles - role
ALTER TABLE user_roles
ADD CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE;
