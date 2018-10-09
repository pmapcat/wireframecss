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
   :element "#8BB4C0"})
(defn color-and-back
  [name color]
  [[(str "." name "-color")] {:color color}
   [(str "." name "-color-background")
    {:background color}]])

(def specific-styles
  [[:h2 ;; {:color (:element chrome-colors)}
    ]
   [:h1 {:font-family "Monoton" :font-weight "300"}]
   ["*" {:font-family "Open Sans"}]
   (color-and-back "margin" (:margin chrome-colors))
   (color-and-back "border" (:border chrome-colors))
   (color-and-back "padding" (:padding chrome-colors))
   (color-and-back "element" (:element chrome-colors))])


