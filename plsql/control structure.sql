DECLARE
CURSOR cust_cur IS
SELECT CustomerID, Age
FROM Customers;
BEGIN
FOR cust IN cust_cur LOOP
IF cust.Age > 60 THEN
UPDATE Loans
SET InterestRate = InterestRate - 1
WHERE CustomerID = cust.CustomerID;
END IF;
END LOOP;

COMMIT;
DBMS_OUTPUT.PUT_LINE('Interest rate discount applied successfully.');

END;
/

DECLARE
CURSOR cust_cur IS
SELECT CustomerID, Balance
FROM Customers;
BEGIN
FOR cust IN cust_cur LOOP
IF cust.Balance > 10000 THEN
UPDATE Customers
SET IsVIP = 'TRUE'
WHERE CustomerID = cust.CustomerID;
END IF;
END LOOP;

COMMIT;
DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');

END;
/

DECLARE
CURSOR loan_cur IS
SELECT CustomerID, LoanID, DueDate
FROM Loans
WHERE DueDate BETWEEN SYSDATE AND SYSDATE + 30;
BEGIN
FOR loan IN loan_cur LOOP
DBMS_OUTPUT.PUT_LINE(
'Reminder: Customer ' || loan.CustomerID ||
' has Loan ' || loan.LoanID ||
' due on ' || loan.DueDate
);
END LOOP;
END;
/