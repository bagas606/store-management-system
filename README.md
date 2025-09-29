# store-management-system
# KlikIndomaret Backend Developer Assignment

**Candidate:** Rahadhian  
**Assignment:** Backend Developer Technical Assignment  
**Date:** 2025  

---

## **1. Overview**

This project is a **Spring Boot backend system** for managing Provinces, Branches, Stores, and Whitelist Stores.  
It is designed to handle a growing dataset, providing efficient querying, soft-delete functionality, and whitelist store management.  

The project is structured into **3 main services**:

1. **ProvinceService** – manage provinces (read-only)
2. **BranchService** – manage branches (CRUD + soft delete)
3. **StoreService** – manage stores and whitelist stores

The system includes **RESTful APIs**, **active/non-deleted filters**, and **whitelist logic**.  

---

## **2. Technology Stack**

- **Java 17** (or JDK 8+)
- **Spring Boot**
- **Spring Data JPA / Hibernate**
- **MySQL** (or PostgreSQL)
- **Maven** (dependency management)
- **Postman / Insomnia** (API testing)

---

## **3. Database Setup**

**Tables:**

1. **Province**
   - `id` BIGINT PK
   - `name` VARCHAR(100)
   - `created_at` TIMESTAMP
   - `updated_at` TIMESTAMP
   - `is_deleted` BOOLEAN

2. **Branch**
   - `id` BIGINT PK
   - `province_id` BIGINT FK → Province(id)
   - `name` VARCHAR(100)
   - `created_at` TIMESTAMP
   - `updated_at` TIMESTAMP
   - `is_deleted` BOOLEAN

3. **Store**
   - `id` BIGINT PK
   - `branch_id` BIGINT FK → Branch(id)
   - `name` VARCHAR(100)
   - `status` ENUM('ACTIVE','INACTIVE')
   - `is_deleted` BOOLEAN
   - `created_at` TIMESTAMP
   - `updated_at` TIMESTAMP

4. **WhitelistStore**
   - `id` BIGINT PK
   - `store_id` BIGINT FK → Store(id)
   - `is_active` BOOLEAN
   - `created_at` TIMESTAMP
   - `updated_at` TIMESTAMP

**ERD Relation:**

