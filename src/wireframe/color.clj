;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-10-10 17:37 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
(ns wireframe.color
  (:require [com.evocomputing.colors :as cl]
            [wireframe.utils :refer [scale-inplace]]))


(defn black-font?
  [color]
  (> (/ (+  (* 299 (cl/red color)) (* 0.587 (cl/green  color)) (* 0.114 (cl/blue color))) 255) 0.5))

(defn string->color
  [item]
  (if (and  (string? item) (not (empty? item)))
    (cl/create-color item)
    item))

(defn color->string
  [item]
  (if (= :com.evocomputing.colors/color (type item))
    (cl/rgb-hexstr item)
    item))

(defn- set-hue
  [color hue]
  (cl/create-color :h (cl/clamp-hue  hue)
                   :s (cl/saturation color)
                   :l (cl/lightness  color)
                   :a (cl/alpha color)))

(defn- middle-color
  [color-1 color-2]
  (let [[color-1 color-2]
        (if (> (cl/hue color-1) (cl/hue color-2))
          [color-1 color-2]
          [color-2 color-1])]
    (set-hue
     color-2
     (+ (cl/hue color-2) (/ (- (cl/hue color-1) (cl/hue color-2)) 2)))))

(defn- scale-generate
  [measure op size base]
  (let [base      (string->color base)
        lightness (measure base)]
    (for [i  (rest (range (inc size)))]
      (->>
       (scale-inplace 0 (inc size) 0 lightness i)
       (op base)
       (color->string)))))

(defn- tints-and-shades
  [amount color]
  {:shades (into [] (scale-generate cl/lightness cl/darken  amount color))
   :tints  (into [] (scale-generate cl/lightness cl/lighten amount color))
   :lumos  (into [] (scale-generate cl/saturation cl/saturate amount color))
   :gray   (into [] (scale-generate cl/saturation cl/desaturate amount color))})

(defn generate-color
  [interval base-string]
  (let [base (string->color base-string)
        ts   (tints-and-shades 5 base)]
    {:pos
     {:base       (color->string base)
      :gray       (color->string (cl/grayscale base))
      :comp       (color->string (cl/opposite base))
      :near-0     (color->string (cl/adjust-hue base interval))
      :near-1     (color->string (cl/adjust-hue base (- interval)))
      :op-side-0  (color->string (cl/adjust-hue base (- 180 interval)))
      :op-side-1  (color->string (cl/adjust-hue base (-  (- 180 interval))))}
     :tints   (:tints ts)
     :shades  (:shades ts)
     :lumos   (:lumos ts)
     :gray    (:gray ts)}))

(comment
  
  (map
   println
   (generate-color 30 "#3f51b5"))
  )
