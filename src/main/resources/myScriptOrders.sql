SELECT O.product_name
FROM ORDERS O
         JOIN CUSTOMERS C on O.customer_id = C.id
WHERE LOWER(C.name) = :name;