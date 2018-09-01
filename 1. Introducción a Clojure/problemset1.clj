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

(defn conj-end
  [lst x]
  (concat lst (list x)))

(defn deep-reverse
  "Takes a list as its input. It returns a list with
  the same elements as its input but in reverse order.
  If there are any nested lists, these too should
  be reversed."
  [lst]
  (if (empty? lst)
    ()
    (if (list? (first lst))
      (conj-end (deep-reverse (rest lst))
                (deep-reverse (first lst)))
      (conj-end (deep-reverse (rest lst))
                (first lst)))))

(defn binary
  [n]
  (if (zero? n)
    ()
    (concat (binary (quot n 2))
            (list (rem n 2)))))

(defn binary-v2
  [n]
  (loop [n      n
         result ()]
    (if (zero? n)
      result
      (recur (quot n 2) (cons (rem n 2) result)))))

(defn binary-v3
  [n]
  (->>
  (iterate (fn [[n result]]
             [(quot n 2) (cons (rem n 2) result)])
           [n ()])
    (drop-while (fn [x] (pos? (first x))))
    first
    second))

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

(deftest test-deep-reverse
  (is (= () (deep-reverse ())))
  (is (= '(3 (d c b) a) (deep-reverse '(a (b c d) 3))))
  (is (= '(((6 5) 4) 3 (2 1))
          (deep-reverse '((1 2) 3 (4 (5 6)))))))

(run-tests)
