; Problem Set 1
; Ejercicios hechos en clase.

(use 'clojure.test)

(defn f2c
  "Takes x degrees Fahrenheit and converts
  them to degrees Celsius."
  [x]
  (/ (* (- x 32)
        5)
     9))

(defn add-list
  "Returns the sum of all the elements of its input
  list, or 0 if its empty. Assume that all the
  elements in the input list are numbers."
  [lst]
  (loop [sum 0
         lst lst]
    (if (empty? lst)
      sum
      (recur (+ sum (first lst)) (rest lst)))))

(defn fact
  "Computes the factorial of n."
  [n]
  (loop [i      1
         result 1]
    (if (> i n)
      result
      (recur (inc i) (*' result i)))))

(deftest test-f2c
  (is (= 100.0 (f2c 212.0)))
  (is (= 0.0 (f2c 32.0)))
  (is (= -40.0 (f2c -40.0))))

(deftest test-add-list
  (is (= 0 (add-list ())))
  (is (= 10 (add-list '(2 4 1 3))))
  (is (= 55 (add-list '(1 2 3 4 5 6 7 8 9 10)))))

(run-tests)
