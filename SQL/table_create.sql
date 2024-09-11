CREATE DATABASE IF NOT EXISTS bugtest;

USE bugtest;

DROP TABLE IF EXISTS user_project;
DROP TABLE IF EXISTS test;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;
DROP TABLE IF EXISTS bug;
DROP TABLE IF EXISTS project_module;
DROP TABLE IF EXISTS project;

-- 项目表
CREATE TABLE project (
        project_id INT AUTO_INCREMENT PRIMARY KEY,          -- 项目ID
        pro_name VARCHAR(255) NOT NULL,                     -- 项目名称
        pro_created_by VARCHAR(255) NOT NULL                -- 创建人
);

-- 模块表
CREATE TABLE project_module (
        module_id INT AUTO_INCREMENT PRIMARY KEY,           -- 模块ID
        mod_name VARCHAR(255) NOT NULL,                     -- 模块名称
        project_id INT NOT NULL,                            -- 所属项目ID
        FOREIGN KEY (project_id) REFERENCES project(project_id)
);

-- Bug表
CREATE TABLE bug (
        bug_id INT PRIMARY KEY AUTO_INCREMENT,        -- Bug ID
        bug_name VARCHAR(255) NOT NULL,               -- Bug标题
        bug_content TEXT,                             -- Bug详细内容
        bug_module INT,                               -- 所属的项目、模块ID
        bug_builder VARCHAR(255) NOT NULL,            -- Bug创建人
        bug_create_date DATETIME NOT NULL,            -- 创建时间
        bug_receiver VARCHAR(255),                    -- 分配给谁
        bug_grade TINYINT CHECK (bug_grade IN (1, 2, 3, 4)), -- Bug等级（1，2，3，4）
        bug_solution ENUM('已修复', '待修复', '不修复'),  -- Bug解决方案（已修复，待修复，不修复）
        bug_solved_date DATETIME,                     -- 解决时间
        bug_state ENUM('激活', '关闭'),                 -- Bug状态（激活，关闭）
        close_date DATETIME,                          -- 关闭时间
        FOREIGN KEY (bug_module) REFERENCES project_module(module_id)  -- 外键约束
);

-- 角色表
CREATE TABLE role (
        role_id INT AUTO_INCREMENT PRIMARY KEY,             -- 角色ID
        role_name VARCHAR(255) NOT NULL,                    -- 角色名称
        permissions TEXT,                                   -- 权限列表
        UNIQUE (role_name)
);

-- 用户表
CREATE TABLE user (
        user_id INT AUTO_INCREMENT PRIMARY KEY,             -- 用户ID
        username VARCHAR(255) NOT NULL UNIQUE,              -- 用户名
        password VARCHAR(255) NOT NULL,                     -- 密码
        email varchar(64) DEFAULT NULL,                     -- 邮箱
        phone_number varchar(32) DEFAULT NULL,              -- 手机号
        role_id INT NOT NULL ,                              -- 角色ID
--      project_id INT,                                     -- 所属项目ID
        status char(1) DEFAULT '0',                         -- 登录状态: 0代表未登录, 1代表已登录
        FOREIGN KEY (role_id) REFERENCES role(role_id),
--      FOREIGN KEY (project_id) REFERENCES project(project_id),
        UNIQUE (username)
);

-- 测试用例表
CREATE TABLE test (
        test_id INT AUTO_INCREMENT PRIMARY KEY,             -- 测试ID
        module_id INT,                                      -- 所属模块ID
        test_case TEXT NOT NULL,                           -- 测试用例描述
        tester VARCHAR(255),                                -- 测试人员
        test_result VARCHAR(50),                            -- 测试结果
        FOREIGN KEY (module_id) REFERENCES project_module(module_id)
);

-- 用户项目关联表
CREATE TABLE user_project (
        user_id INT,                                        -- 用户ID
        project_id INT,                                    -- 项目ID
        PRIMARY KEY (user_id, project_id),                -- 联合主键
        FOREIGN KEY (user_id) REFERENCES user(user_id) ON DELETE CASCADE,      -- 外键引用用户表
        FOREIGN KEY (project_id) REFERENCES project(project_id) ON DELETE CASCADE -- 外键引用项目表
);