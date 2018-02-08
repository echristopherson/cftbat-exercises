(ns cftbat-exercises.chapter01 "Exercises for Chapter 1"
    (:gen-class))

;;; 1. Use the str, vector, list, hash-map, and hash-set functions.
(defn exercise01
  "Use the str, vector, list, hash-map, and hash-set functions."
  []
  (let [my-string (str "This is " "my string")
        my-vector (vector 1 :two "three" 4.0)
        my-list (list + 1 1)
        my-hash-map (hash-map :a "ayyy" :b "Bea")
        my-hash-set (hash-set :life 42 :universe 42 :everything)]
    (println "my-string:" my-string)
    (println "3rd element of my-vector:" (nth my-vector 3))
    (println "value for key :b in my-hash-map:" (:b my-hash-map))
    (println "my-hash-set contains 42?" (contains? my-hash-set 42))))

;;; 2. Write a function that takes a number and adds 100 to it.
(defn exercise02
  "Write a function that takes a number and adds 100 to it."
  [num]
  (+ num 100))

;;; 3. Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction:
;;;    (def dec9 (dec-maker 9)) (dec9 10)
;;;    ; => 1
(defn exercise03
  "Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction:
    (def dec9 (dec-maker 9)) (dec9 10)
    ; => 1"
  ([]
   (defn dec-maker
     "Return a function `f`, taking `num`, such that `(f num)` evaluates to `(- num subtrahend)`"
     [subtrahend]
     (fn [num] (- num subtrahend)))
   dec-maker)
  ([subtrahend]
   (exercise03)
   (dec-maker subtrahend)))

;;; 4. Write a function, mapset, that works like map except the return value is a set:
;;;    (mapset inc [1 1 2 2])
;;;    ; => #{2 3}

;;; 5. Create a function that’s similar to symmetrize-body-parts except that it has to work with weird space aliens with radial symmetry. Instead of two eyes, arms, legs, and so on, they have  ve.

;;; 6. Create a function that generalizes symmetrize-body-parts and the func- tion you created in Exercise 5. The new function should take a col- lection of body parts and the number of matching body parts to add.
;;;    If you’re completely new to Lisp languages and functional program- ming, it probably won’t be obvious how to do this. If you get stuck, just move on to the next chapter and revisit the problem later.
