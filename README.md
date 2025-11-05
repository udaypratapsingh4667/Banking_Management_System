# 🏦 Banking Management System (ATM Simulator)

This project is a complete desktop-based ATM simulator application. It uses Java Swing for the graphical user interface (GUI) and MySQL for the database backend.

The primary goal of this project is to demonstrate core Java principles, Object-Oriented Programming (OOP), and JDBC for database connectivity in a real-world application.

---

## ✨ Features

* **New User Registration:** A detailed 3-page signup form for opening a new bank account.
* **User Authentication:** Secure login using a unique Card Number and PIN.
* **Deposit:** Deposit funds directly into the account.
* **Withdrawal:** Withdraw funds from the account.
* **Fast Cash:** Quick withdrawal options for common amounts (e.g., Rs.100, Rs.500, Rs.1000).
* **Balance Enquiry:** Check the current account balance.
* **PIN Change:** Securely change the ATM PIN.
* **Mini Statement:** View the last 10-12 transactions.

---

## 🛠️ Technology Stack

* **Core Language:** Java
* **GUI (Frontend):** Java Swing & AWT
* **Database (Backend):** MySQL
* **Libraries:**
    * `mysql-connector-j`: For connecting to the MySQL database.
    * `jcalendar`: Used for the date-picker component in the signup form.
* **IDE:** IntelliJ IDEA

---

## 🚀 Getting Started: How to Run This Project

Follow these instructions to get a copy of the project up and running on your local machine.

### 1. Prerequisites

* **Java JDK:** You must have the Java Development Kit (JDK) installed (version 17 or higher recommended).
* **MySQL Server:** You need a running MySQL database server (e.g., XAMPP, WAMP, or MySQL Workbench).
* **IDE:** An IDE like IntelliJ IDEA (Recommended) or Eclipse.

### 2. Installation & Setup

**Step 1: Clone the Repository**
Open your terminal and run the following git command:
```bash
git clone [https://github.com/udaypratapsingh4667/Banking_Management_System.git](https://github.com/udaypratapsingh4667/Banking_Management_System.git)
```
(Alternatively, you can download the project as a ZIP file).

**Step 2: Open in IntelliJ IDEA** Open IntelliJ IDEA and select "Open" to import the cloned project folder. The IDE should automatically recognize the lib folder and its dependencies.

**Step 3: Database Setup (Crucial Step)**
You must create the database and tables in MySQL before running the application.

1.  Open your MySQL client (like MySQL Workbench or a command line).
2.  Create a new database:
    ```sql
    CREATE DATABASE bankmanagementsystem;
    ```
3.  Use the new database:
    ```sql
    USE bankmanagementsystem;
    ```
4.  Create the required tables:

    ```sql
    CREATE TABLE customer (
        form_no VARCHAR(20) PRIMARY KEY,
        name VARCHAR(50),
        father_name VARCHAR(50),
        DOB VARCHAR(20),
        gender VARCHAR(10),
        email VARCHAR(50),
        marital_status VARCHAR(20),
        address VARCHAR(100),
        city VARCHAR(50),
        pincode VARCHAR(10),
        state VARCHAR(50),
        religion VARCHAR(20),
        category VARCHAR(20),
        income VARCHAR(20),
        education VARCHAR(30),
        occupation VARCHAR(30),
        pan VARCHAR(20),
        aadhaar VARCHAR(20),
        senior_citizen VARCHAR(10),
        existing_account VARCHAR(10),
        account_type VARCHAR(30),
        card_number VARCHAR(20),
        services VARCHAR(100)
    );
    ```

    ```sql
    CREATE TABLE login (
        form_no VARCHAR(20),
        card_number VARCHAR(20),
        pin VARCHAR(10)
    );
    ```

    ```sql
    CREATE TABLE bank (
        id INT AUTO_INCREMENT PRIMARY KEY,
        pin VARCHAR(10),
        date DATETIME,
        type VARCHAR(20),
        amount INT
    );
    ```

**Step 4: Create the **config.properties** File**

Your sensitive database password is not on GitHub. You need to create this file locally.

1.  In IntelliJ, right-click the **src** folder.
2.  Select **New** -> **File**.
3.  Name the file exactly **config.properties**.
4.  Inside this new file, add your MySQL username and password:

    ```properties
    # Enter your personal MySQL username and password
    db_user=root
    db_password=your_mysql_password
    ```

**Step 5: Run the Project**

You are all set!
Navigate to **src/bank/management/system/**, find the **Login.java** file, right-click on it, and select **"Run 'Login.main()'"**.

## 📸 Screenshots

<img width="1108" height="618" alt="Screenshot 2025-11-05 151418" src="https://github.com/user-attachments/assets/99d6e130-0d90-4b7c-b6b4-92048e6593ac" />
<img width="1049" height="988" alt="Screenshot 2025-11-05 151436" src="https://github.com/user-attachments/assets/f98dee35-8ca7-4d0d-9bcc-cb4536c1c968" />
<img width="1895" height="1014" alt="Screenshot 2025-11-05 151515" src="https://github.com/user-attachments/assets/c8b495f1-eb80-4d52-9b3c-5898b3f734e8" />
<img width="482" height="738" alt="Screenshot 2025-11-05 151736" src="https://github.com/user-attachments/assets/5a8e3f41-1b1b-4cbc-8609-cedd5695effa" />
<img width="1603" height="581" alt="Screenshot 2025-11-05 151917" src="https://github.com/user-attachments/assets/d6053695-c7cf-4a7d-ab7b-a5b0fd36a69b" />


---

## 🧑‍💻 Author

-   **[Uday Pratap Singh](https://github.com/udaypratapsingh4667)**
