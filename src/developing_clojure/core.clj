(ns developing-clojure.core)

(defn discounted-value
  "Returns the value discounted 10% if the absolute value is > 100 "
  [absolute-value]
  (if (> absolute-value 100)
    (let [discount-tax (/ 10 100)
          discount         (* absolute-value discount-tax)]
      (- absolute-value discount))
    absolute-value))

(println (discounted-value 1000))
(println (discounted-value 100))

; PREDICATE
(defn apply-discount?
  [absolute-value]
  (if (> absolute-value 100)
    true
    false))

(println (apply-discount? 100))
(println (apply-discount? 1000))