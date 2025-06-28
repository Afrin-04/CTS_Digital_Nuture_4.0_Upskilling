
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE customers';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

CREATE TABLE customerss (
    customer_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    balance NUMBER
);

CREATE TABLE employees1 (
    employee_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    salary NUMBER
);

CREATE OR REPLACE PROCEDURE addnewcustomer (
    p_id       NUMBER,
    p_name     VARCHAR2,
    p_balance  NUMBER
)
AS
BEGIN
    INSERT INTO customerss (customer_id, name, balance)
    VALUES (p_id, p_name, p_balance);

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in ADDNEWCUSTOMER: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE updatesalary (
    p_empid     NUMBER,
    p_increment NUMBER
)
AS
BEGIN
    UPDATE employees1
    SET salary = salary + p_increment
    WHERE employee_id = p_empid;

    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('No employee found.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Salary updated.');
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in UPDATESALARY: ' || SQLERRM);
END;
/

CREATE OR REPLACE PROCEDURE safetransferfunds (
    p_from_id NUMBER,
    p_to_id   NUMBER,
    p_amount  NUMBER
)
AS
BEGIN
    DECLARE
        v_from_balance NUMBER;
    BEGIN
        SELECT balance INTO v_from_balance
        FROM customerss
        WHERE customer_id = p_from_id;

        IF v_from_balance < p_amount THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
        END IF;

        UPDATE customerss SET balance = balance - p_amount WHERE customer_id = p_from_id;
        UPDATE customerss SET balance = balance + p_amount WHERE customer_id = p_to_id;

        DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');
    END;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error in SAFETRANSFERFUNDS: ' || SQLERRM);
END;
/

INSERT INTO employees1 VALUES (2001, 'Alice', 50000);
INSERT INTO employees1 VALUES (2002, 'Bob', 45000);
COMMIT;

BEGIN
    addnewcustomer(101, 'John Doe', 1000);
    addnewcustomer(102, 'Jane Smith', 500);
    
    updatesalary(2001, 5000);

    safetransferfunds(101, 102, 300);
END;
/
