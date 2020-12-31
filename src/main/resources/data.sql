-- User
INSERT INTO `app_user` (`id`, `is_account_non_expired`, `is_account_non_locked`, `is_credentials_non_expired`, `is_enabled`, `password`, `username`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, b'1', b'1', b'1', b'1', '$2a$10$IQCZ0Nor0JmiRz8iLUHZROvn5sptkfwSTT72IxQ4sp58zRgexxnTm', 'namory', '2015-02-20 06:30:00.000000', 'admin', '2015-02-20 06:30:00.000000', 'admin');
COMMIT;

-- role
INSERT INTO `app_role` (`role_id`, `name`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 'USER', '2015-02-20 06:30:00.000000', 'admin', '2015-02-20 06:30:00.000000', 'admin');

-- permissions
INSERT INTO `app_permission` (`permission_id`, `name`, `created_at`, `created_by`, `updated_at`, `updated_by`) VALUES
(1, 'read_lift', '2015-02-20 06:30:00.000000', 'admin', '2015-02-20 06:30:00.000000', 'admin');