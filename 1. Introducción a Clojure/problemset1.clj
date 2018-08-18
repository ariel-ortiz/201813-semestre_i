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

(deftest test-f2c
  (is (= 100.0 (f2c 212.0)))
  (is (= 0.0 (f2c 32.0)))
  (is (= -40.0 (f2c -40.0))))

(run-tests)
