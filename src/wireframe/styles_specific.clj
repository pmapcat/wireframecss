;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-09-10 21:28 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

(ns wireframe.styles-specific)
(def chrome-colors
  {:margin "#F9CC9D"
   :border "#fddc9a40"
   :padding "#C2CE89"
   :element "#dcdbfa"
   :dark-gray "#494949"
   :dark-blue "#0700e6"})
(defn color-and-back
  [name color]
  [[(str "." name "-color")] {:color color}
   [(str "." name "-color-background")
    {:background color}]])

(def specific-styles
  [[:h2 {:font-family "'Patua One', cursive"}]
   [:h4 {:font-family "'Patua One', cursive" :font-weight "300"}]
   [:a {:color (:dark-blue chrome-colors) :font-weight "600" :text-decoration "none"}]
   [:a:hover {:color "#dcdbfa"  :font-weight "600"}]
   [:b {:font-family "'Patua One', cursive" :font-weight "300"}]
   [:h1 {:font-family "Monoton" :font-weight "300"}]
   ["*" {:font-family "Open Sans"
         :color (:dark-gray chrome-colors)}]
   
   (color-and-back "margin" (:margin chrome-colors))
   (color-and-back "border" (:border chrome-colors))
   (color-and-back "padding" (:padding chrome-colors))
   (color-and-back "element" (:element chrome-colors))])


