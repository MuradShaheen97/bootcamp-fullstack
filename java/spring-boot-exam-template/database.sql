-- شغّل هذا الأمر مرة واحدة في MySQL Workbench قبل تشغيل المشروع.

CREATE DATABASE IF NOT EXISTS exam_app_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- لا تعمل الجداول يدويًا.
-- Hibernate سيعمل users و items من الـ Models.
