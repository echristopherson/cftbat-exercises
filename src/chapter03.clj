(ns cftbat-exercises.chapter03 "Exercises for Chapter 3"
    (:gen-class))

;;; 1. Use the str, vector, list, hash-map, and hash-set functions.
(defn exercise01
  "Simply demonstrates the `str`, `vector`, `list`, `hash-map`, and `hash-set` functions."
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
  "Takes a number `num` and adds 100 to it."
  [num]
  (+ num 100))

;;; 3. Write a function, dec-maker, that works exactly like the function inc-maker except with subtraction:
;;;    (def dec9 (dec-maker 9)) (dec9 10)
;;;    ; => 1
(defn exercise03
  "Defines a function, `dec-maker`, that works exactly like the function `inc-maker` in the book, except with subtraction; i.e. it takes an argument `num`, such that `(f num)` evaluates to `(- num subtrahend)`:

       (def dec9 (dec-maker 9))
       (dec9 10)
       ; => 1

  If called with no arguments, simply (re)defines `dec-maker`, and returns it. If called with the argument `subtrahend`, (re)defines `dec-maker` and returns the result of calling `(dec-maker subtrahend)`, i.e. a decrementer function that will remove `subtrahend` from its argument and return that."
  ([]
   (defn dec-maker
     "Returns a function `f`, taking `num`, such that `(f num)` evaluates to `(- num subtrahend)`."
     [subtrahend]
     (fn [num] (- num subtrahend)))
   dec-maker)
  ([subtrahend]
   (exercise03)
   (dec-maker subtrahend)))

;;; 4. Write a function, mapset, that works like map except the return value is a set:
;;;    (mapset inc [1 1 2 2])
;;;    ; => #{2 3}
(defn exercise04
  "Defines a function, `mapset`, that works like map except the return value is a set:

       (mapset inc [1 1 2 2])
       ; => #{2 3}

  If called with no arguments, simply (re)defines `mapset`, and returns it. If called with an argument list `& args`, (re)defines `mapset` and returns the result of calling `(apply mapset args)`."
  ([]
   (defn mapset
     "Acts like `map`, except that it returns a set made from what would be the seq returned by the equivalent `map`."
     [& args]
     (set (apply map args)))
   mapset)
  ([& args]
   (exercise04)
   (apply mapset args)))

;;; 5. Create a function that’s similar to symmetrize-body-parts except that it has to work with weird space aliens with radial symmetry. Instead of two eyes, arms, legs, and so on, they have five.
;; Hobbit violence!
(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])


(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts
         final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(defn exercise05
  "Defines a function, `symmetrize-body-parts-5`, that works like `symmetrize-body-parts` in the book, except that instead of just pairs of matching body parts, they have sets of five.

  If called with no arguments, simply (re)defines `symmetrize-body-parts-5`, and returns it. If called with an argument list `& args`, (re)defines `symmetrize-body-parts-5` and returns the result of calling `(apply symmetrize-body-parts-5 args)`."
([])
([& args]
))

;;; 6. Create a function that generalizes symmetrize-body-parts and the function you created in Exercise 5. The new function should take a collection of body parts and the number of matching body parts to add.
;;;    If you’re completely new to Lisp languages and functional programming, it probably won’t be obvious how to do this. If you get stuck, just move on to the next chapter and revisit the problem later.
(defn exercise06
  "Defines a function, `symmetrize-body-parts-n`, that works like `symmetrize-body-parts` and `symmetrize-body-parts-5`, except that instead of sets of two or five matching body parts, the creature has sets of an arbitrary number of parts.

  If called with no arguments, simply (re)defines `symmetrize-body-parts-radial`, and returns it. If called with an argument list `& args`, (re)defines `symmetrize-body-parts-radial` and returns the result of calling `(apply symmetrize-body-parts-5 args)`.
"
([])
([& args]
))
