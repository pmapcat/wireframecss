;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-10-10 20:52 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

(ns wireframe.utils
  (:require
   [garden.core :as garden]
   [wireframe.config :as config :refer [*ANGRY* *PREFIX*]]))

(defn- black-font-calculator
  [r g b]
  (> (/ (+  (* 0.299 r) (* 0.587 g) (* 0.114 b)) 255) 0.5))

(defn black-font? [color] 
  (let [colors (rest (clojure.string/split color #""))
        red (take 2 colors)
        green (take 2 (drop 2 colors))
        blue (take 2 (drop 4 colors))]
    (apply black-font-calculator (map #(-> (conj % "0x") (clojure.string/join) (read-string)) [red green blue]))))
(defn scale-inplace
  [A B C D X]
  (+
   (* C (- 1  (/ (- X A) (- B A))))
   (* D (/ (- X A) (- B A)))))

(defn get-class-names
  [item]
  (distinct (re-seq (re-pattern (str "\\." *PREFIX* "[^\\s:]+")) (garden/css item))))



(defn angry
  [item]
  (if config/*ANGRY*
    (str item " !important")
    item))

(defn any-to-string
  [item]
  (let [i (str item)]
    (if (= \: (first i))
      (apply str (rest i))
      i)))

(defn kstr
  [& whatever]
  (as->
    (map any-to-string whatever) $
    (clojure.string/join "-" $)
    (clojure.string/split $ #"-+")
    (clojure.string/join "-" $)))

(defn dstr
  [& whatever]
  (as->
    (map any-to-string whatever) $
    (if config/*ANGRY* (concat $ ["angry"]) $)
    (concat  [(str "." *PREFIX*)] $)
    (clojure.string/join "-" $)
    (clojure.string/split $ #"-+")
    (clojure.string/join "-" $)))

(defn whatever
  []
  config/*ANGRY*)
