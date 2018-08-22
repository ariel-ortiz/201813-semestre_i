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
  (reduce + lst))

(defn fact
  "Computes the factorial of n."
  [n]
  (reduce *' (range 1 (inc n))))

(deftest test-f2c
  (is (= 100.0 (f2c 212.0)))
  (is (= 0.0 (f2c 32.0)))
  (is (= -40.0 (f2c -40.0))))

(deftest test-add-list
  (is (= 0 (add-list ())))
  (is (= 10 (add-list '(2 4 1 3))))
  (is (= 55 (add-list '(1 2 3 4 5 6 7 8 9 10)))))

(deftest test-fact
  (is (= 1 (fact 0)))
  (is (= 1 (fact 1)))
  (is (= 6 (fact 3)))
  (is (= 120 (fact 5)))
  (is (= 720 (fact 6))))

(run-tests)
