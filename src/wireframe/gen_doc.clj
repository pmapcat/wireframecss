;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-09-10 18:03 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
(ns wireframe.gen-doc
  (:require [wireframe.styles :as styles]
            [wireframe.color-material :as color-material]
            [wireframe.utils :refer [get-class-names]]
            [garden.core :as garden]))


(defn- highlight
  [item subs styles]
  (->>
   (fn [item]
    (str
     "<span style=\"" styles "\">"
     item
     "</span>"))
   (clojure.string/replace item (re-pattern subs))))

(defn- display-div
  [class body]
  [:div {:style (str "margin:1em;overflow:auto;background:#F9CC9D94;")}
   [:div {:class class  :style  "background:#C2CE8994;"}
    [:span {:style "background:#dcdbfa94;"} body]]])

(defn- make-demo
  [list-of-classes props]
  (let [props (merge {:attach-class ""
                      :item-decoration identity} props  )]
    [:div.mik-pad-1 {:style "background:url(\"/sheet.png\")"}
     (for [item (sort list-of-classes)]
       (display-div (str (apply str (rest item)) " " (:attach-class props))
                    ((:item-decoration props) item)))]))

(defn- make-source-demo
  [item-result]
  [:pre
   [:code.language-css.hljs
    (garden/css item-result)]])

(defn generate-doc
  ([title description gen-res]
   (generate-doc title description gen-res {}))
  ([title description gen-res props]
   (let [classes (get-class-names gen-res)]
     [:div
      [:h4.mik-cut-bottom [:a.mik-fs-0 {:href "#top"} "[ top ] "] title]
      [:p.mik-cut-top.mik-cut-bottom
       description]
      [:div.mik-pad-0.mik-margin-0
       (make-demo classes props)]
      [:hr]])))

(def ratio-scale
  (str "[" (clojure.string/join ", " (map styles/ratio (range 7))) "]"))

(def datum
  [:div
   ;; [:div.mik-defy-boundaries-angry
   ;;  [:div.mik-white-back.mik-small-container.mik-pad-1
   ;;   (color-material/generate-doc)]]
   (color-material/generate-doc)
   
   (generate-doc
    "Cut padding and margin of an element"
    "Useful when you want to put elements adjacent to each other"
    (styles/p-cut-specified) {:attach-class " mik-margin-0 mik-pad-0"})
   
   (generate-doc
    "Float element"
    [:span "Either on the right or on the left. Do not mistake with  " [:b " flush "]]
    (styles/p-float-specified ))
   
   (generate-doc
    "Align (or flush) layout either (left,right,center or justify)"
    [:span "In general, useful when " [:b " aligning "] " elements"]
    (styles/p-flush-specified))
   
   (generate-doc
    "Padding element"
    [:div "Padding amount is calculated according to" [:b " ratio "] "scale in the config." "The default one is:" [:br]
     ratio-scale [:br]
     "Default elements are of the second element on the scale ratio"]
    (styles/p-pad-specified))
   
   (generate-doc
    "Margin element"
    [:div "Margin amount is calculated according to" [:b " ratio "] "scale in the config." "The default one is:" [:br]
     ratio-scale [:br]
     "Default elements are of the second element on the scale ratio"]
    ( styles/p-margin-specified))
   
   (generate-doc
    "Font size" 
    [:div "Relative font size is calculated according to" [:b " ratio "] "scale in the config." "The default one is:" [:br]
     [:code ratio-scale] [:br]
     "Default elements are of the second element on the scale ratio"]
    (styles/p-fs-specified))
   
   (generate-doc
    "Font weight"
    "Weights of the font size"
    (styles/p-fw) )
   (generate-doc
    "Containers"
    "These behave similar to Bootstrap's container class"
    (styles/p-containers))
   
   (generate-doc
    "Justify single line"
    ""
    (styles/p-line-justify)
    {:item-decoration #(clojure.string/join " " (into [] %))})

   (generate-doc
    "Sets width to 100%"
    ""
    (styles/p-width-100))

   (generate-doc
    "Add shadow to the element"
    ""
    (styles/p-shadow)  {:attach-class " mik-margin-0 "} )
   (generate-doc
    "Make border square"
    ""
    (styles/p-square-border))

   ;; [:div.mik-defy-boundaries-angry
   ;;  [:div.mik-white-back.mik-container.mik-pad-1
   ;;   (generate-doc
   ;;    "Defy boundaries"
   ;;    [:div "Will display the element not respecting parent container.  " [:br]
   ;;     "To have an effect, selector should be put inside the parent container" [:br]]
   ;;    (styles/p-defy-boundaries))]]
   
   (generate-doc
    "Padded|Margin as button"
    "Will pad or add margins as in button"
    (styles/p-as-button-specificed))])
