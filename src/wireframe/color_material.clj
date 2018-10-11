;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-10-10 22:10 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

(ns wireframe.color-material
  (:require [wireframe.utils :as utils]
            [wireframe.config :refer [*MATERIAL-PALETTE* *COLOR-NAMES*]]))

(defn- p-color-style
  [color-name color]
  (if (nil? color)
    nil
    (let [dark-text? (utils/black-font? color)]
      [[(utils/dstr color-name) {:color (utils/angry color)}]
       [(utils/dstr color-name "back")
        {:color (if dark-text?  (utils/angry "black") (utils/angry "white"))
         :background (utils/angry color)}]])))

(defn- by-color-name
  [color-name datum]
  (let [color-name (name color-name)]
    [
     [(p-color-style (str color-name "-a-3") (:a700  datum))]
     [(p-color-style (str color-name "-a-2") (:a400  datum))]
     [(p-color-style (str color-name "-a-1") (:a200  datum))]
     [(p-color-style (str color-name "-s-4") (:900  datum))]
     [(p-color-style (str color-name "-s-3") (:800  datum))]
     [(p-color-style (str color-name "-s-2") (:700  datum))]
     [(p-color-style (str color-name "-s-1") (:600  datum))]
     [(p-color-style (str color-name) (:500  datum))]
     [(p-color-style (str color-name "-t-1") (:400  datum))]
     [(p-color-style (str color-name "-t-2") (:300  datum))]
     [(p-color-style (str color-name "-t-3") (:200  datum))]
     [(p-color-style (str color-name "-t-4") (:100  datum))]
     [(p-color-style (str color-name "-t-5") (:50  datum))]]))


(defn gen-palette
  []
  (for [key-item *COLOR-NAMES*]
    (by-color-name  key-item (*MATERIAL-PALETTE* key-item))))

(defn generate-doc
  ([]
   [:div.flush-center
    [:h4.mik-cut-bottom [:a.mik-fs-0 {:href "#top"} "[ top ] "] "Material color palette"]
    [:p.mik-cut-top.mik-cut-bottom
     [:p.mik-pad-0.element-color-background
      "Colors take up the most space. The library with color will take " [:b "7.6K"]  " gzipped" [:br]
      "And without color it will take " [:b "1.6K"] " gzipped" [:br]]
     "Available color names are: " [:br]
     (for [i  (map name *COLOR-NAMES*)]
       [:b {:class (str "mik-" i)} " " i " "]) [:br]
     
     "Attach " [:b " -back "] "for it to work for the background" [:br]
     "Attach " [:b " -angry "] "to override default styles of a given framework" [:br]
     "Attach " [:b " -t-1, -t-2,-t-3,-t-4,-t-4, -t-5 "] "for tints" [:br]
     "Attach " [:b " -s-1, -s-2,-s-3,-s-4,-s-4, -s-5 "] "for shades" [:br]
     "Attach " [:b " -a-1, -a-2,-a-3 "] "for accents"]
    [:div
     [:table
      [:tbody.mik-fs-0-angry
       (for [color (gen-palette)]
         [:tr
          (for [class-name (filter #(.contains % "-back")  (utils/get-class-names color))]
            [:td.mik-fs-0-angry {:class (str (apply str (rest class-name)) "-angry")}
             (str  class-name)])])]]]
    [:hr]]))
