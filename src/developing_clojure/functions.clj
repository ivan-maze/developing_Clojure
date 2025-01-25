(ns developing-clojure.functions)

(defn apply-discount [absolute-value] ; defining the function name and its [parameter]
    (* absolute-value 0.9)) ; multiplying parameter for a decimal 
(apply-discount 100) ; return the function result for a defined parameter 

(defn apply-discount [absolute-value] 
    (* absolute-value (- 1 0.1))) ; multiplying parameter for the result of a subtraction
(apply-discount 100)

(defn apply-discount ; **** ATTENTION: NOT RECOMMENDED - BAD PRACTICE ****
    "Apply a defined discount in an inserted parameter" ; Function description
    [absolute-value] ; Function parameter
    (def discount 0.10) ; Defines a Global Symbol **** ATTENTION: NOT RECOMMENDED - BAD PRACTICE - generates memory trash ****
    (* absolute-value (- 1 discount))) 
(apply-discount 100)

(defn apply-discount ; **** GOOD PRACTICE - Local Symbol during the scope () ****
    "Apply a defined discount in an inserted parameter" 
    [absolute-value] 
    (let [discount 0.10] ; Creates a Local Symbol that receives a vector and exists during the scope ()
      (println "Calculating discount of" discount)
      (* absolute-value (- 1 discount)))) 
(apply-discount 100) ; should return a double

(defn apply-discount ; Trying different approach 
    "Apply a defined discount in an inserted parameter" 
    [absolute-value] 
    (let [discount (/ 10 100)] ; Creates a Local Symbol that receives a vector, which is a result of a division, and exists during the scope ()
      (println "Calculating discount of" discount)
      (* absolute-value (- 1 discount)))) 
(apply-discount 100) ; should return 90N what is a BigInt (N = BigInt ; M = BigDecimal)

(defn apply-discount ; Introducing conditional (if <condition> <return if true> <return if false>
    "Apply a defined discount in an inserted parameter if absolute value is greater than 100"
    [absolute-value] 
    (if (> absolute-value 100) ; condition
      (let [discount 0.10] 
        (println "Calculating discount of" discount) 
        (* absolute-value (- 1 discount))))) ; Return if true
(apply-discount 100) ; Return nill in case of false, once false is not defined

(defn apply-discount ; Introducing conditional if (if <condition> <return if true> <return if false>
    "Apply a defined discount in an inserted parameter if absolute value is greater than 100"
    [absolute-value] 
    (if (> absolute-value 100)
      (let [discount 0.10] 
        (println "Calculating discount of" discount)
        (* absolute-value (- 1 discount))) ; Return if true
    absolute-value)) ; Return absolute-value in case of false
(apply-discount 100) 