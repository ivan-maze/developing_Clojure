(defn apply-discount [absolute-value] ; defining the function name and its [parameter]
    (* absolute-value 0.9)) ; multiplying parameter for a decimal 
(apply-discount 100) ; return the function result for a defined parameter 

(defn apply-discount [absolute-value] 
    (* absolute-value (- 1 0.1))) ; multiplaying parameter for the result of a subtratciton 
(apply-discount 100)

(defn apply-discount ; **** ATENTITION: NOT RECOMMENDED - BAD PRACTICE **** 
    "Apply a defined discount in an inserted parameter" ; Function description
    [absolute-value] ; Function parameter
    (def discount 0.10) ; Deifines a Global Symbol **** ATENTITION: NOT RECOMMENDED - BAD PRACTICE - generates memory trash **** 
    (* absolute-value (- 1 discount))) 
(apply-discount 100)

(defn apply-discount ; **** GOOD PRACTICE - Lolcal Symbol during the scpote () ****
    "Apply a defined discount in an inserted parameter" 
    [absolute-value] 
    (let [discount 0.10] ; Creates a Local Symbol that recives a vector and existes during the scope ()
      (println "Calculating discount of" discount)
      (* absolute-value (- 1 discount)))) 
(apply-discount 100) ; should return a double

(defn apply-discount ; Trying different approach 
    "Apply a defined discount in an inserted parameter" 
    [absolute-value] 
    (let [discount (/ 10 100)] ; Creates a Local Symbol that recives a vector, which is a result of a division, and existes during the scope ()
      (println "Calculating discount of" discount)
      (* absolute-value (- 1 discount)))) 
(apply-discount 100) ; should return 90N what is a BigInt (N = BigInt ; M = BigDecimal)

(defn apply-discount ; Introducing conditional if
    "Apply a defined discount in an inserted parameter if absolute value is greatter than 100" 
    [absolute-value] 
    (if (> absolute-value 100)
      (let [discount 0.10] 
        (println "Calculating discount of" discount)
        (* absolute-value (- 1 discount))))) ; Once false is not defined, return nill in case of false
(apply-discount 100) 

(defn apply-discount ; Introducing conditional if
    "Apply a defined discount in an inserted parameter if absolute value is greatter than 100" 
    [absolute-value] 
    (if (> absolute-value 100)
      (let [discount 0.10] 
        (println "Calculating discount of" discount)
        (* absolute-value (- 1 discount)))
    absolute-value)) ; Return absolute-value in case of false
(apply-discount 100) 