-- ========================================
-- INIT DATABASE SCRIPT
-- ========================================

-- Drop existing objects (untuk development/testing)
DROP TABLE IF EXISTS province CASCADE;
DROP TABLE IF EXISTS branch CASCADE;
DROP TABLE IF EXISTS store CASCADE;
DROP TABLE IF EXISTS whitelist_store CASCADE;


-- ========================================
-- TABLE: province
-- ========================================

CREATE TABLE province
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE
);

-- ========================================
-- TABLE: branch
-- ========================================

CREATE TABLE branch
(
    id          BIGSERIAL PRIMARY KEY,
    province_id BIGSERIAL,
    name        VARCHAR(255),
    created_at  TIMESTAMP,
    updated_at  TIMESTAMP,
    is_deleted  BOOLEAN DEFAULT FALSE
);

-- ========================================
-- TABLE: store
-- ========================================

CREATE TABLE store
(
    id         BIGSERIAL PRIMARY KEY,
    branch_id  BIGSERIAL,
    name       VARCHAR(255),
    status     VARCHAR(50),
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    is_deleted BOOLEAN DEFAULT FALSE
);

-- ========================================
-- TABLE: whitelist_store
-- ========================================

CREATE TABLE whitelist_store
(
    id         BIGSERIAL PRIMARY KEY,
    store_id   BIGSERIAL,
    is_active  BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
