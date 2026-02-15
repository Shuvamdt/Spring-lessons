USE `employee_directory`;
CREATE TABLE `users`(
`username` VARCHAR(50) NOT NULL,
`password` VARCHAR(68) NOT NULL,
`enabled` TINYINT(1) NOT NULL,
PRIMARY KEY(`username`)
)ENGINE = InnoDB DEFAULT CHARSET = latin1;
CREATE TABLE `authorities`(
`username` VARCHAR(50) NOT NULL,
`authority` VARCHAR(50) NOT NULL,
UNIQUE KEY `authorities_idx_1`(`username`,`authority`),
CONSTRAINT `authorities_constraint` 
FOREIGN KEY(`username`) REFERENCES `users`(`username`)
)ENGINE = InnoDB DEFAULT CHARSET = latin1;
INSERT INTO `users` VALUES
('Shuvam', '{bcrypt}$2a$10$HsseAH14Gqr0XoNp35FZvOoEFTBDUDdP8QE/rhprUhrar1VpxoBCC', 1),
('Sneha', '{bcrypt}$2a$10$iQRvyBNJEUwYwG8ngUldfuALUVhHG0QyooOu3Md4tF8qiib/5X7/C', 1),
('Riju', '{bcrypt}$2a$10$xfHaeDNgiyvyQaZxL1W8Ae5kliLNHXPzj3NLxxt2HcBPJQuFXhyua', 1);
INSERT INTO `authorities` VALUES
('Shuvam', 'ROLE_ADMIN'),
('Shuvam', 'ROLE_MANAGER'),
('Shuvam', 'ROLE_EMPLOYEE'),
('Sneha', 'ROLE_MANAGER'),
('Sneha', 'ROLE_EMPLOYEE'),
('Riju', 'ROLE_EMPLOYEE');