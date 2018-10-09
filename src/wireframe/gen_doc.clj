;; @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
;; @ Copyright (c) Michael Leachim                                                      @
;; @ You can find additional information regarding licensing of this work in LICENSE.md @
;; @ You must not remove this notice, or any other, from this software.                 @
;; @ All rights reserved.                                                               @
;; @@@@@@ At 2018-09-10 18:03 <mklimoff222@gmail.com> @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
(ns wireframe.gen-doc
  (:require [wireframe.styles :as styles]
            [wireframe.styles-specific :as sstyles]
            [wireframe.config :refer [conf]]
            [garden.core :as garden]))

(defn get-class-names
  [item]
  (distinct (re-seq (re-pattern (str "\\." (conf :prefix) "[^\\s:]+")) (garden/css item))))

(defn- highlight
  [item subs styles]
  (->>
   (fn [item]
    (str
     "<span style=\"" styles "\">"
     item
     "</span>"))
   (clojure.string/replace item (re-pattern subs))))

(defn- demo-setup
  [body]
  [:div.mik-padded-as-button {:style "background:url(\"/sheet.png\")"}
   body])

(defn- make-demo
  [attach-class list-of-classes]
  (demo-setup
   (for [item (sort list-of-classes)]
     [:div {:style (str "margin:1em;overflow:auto;background:" (sstyles/chrome-colors :margin) "94;")}
      [:div {:class (str  attach-class " "(apply str (rest item))) :style (str "background:" (sstyles/chrome-colors :padding) "94;")}
       [:span {:style (str "background:" (sstyles/chrome-colors :element) "94;")}  item]]])))

(defn- make-source-demo
  [item-result]
  [:pre
   [:code.language-css.hljs
    (garden/css item-result)]])

(defn generate-doc
  ([title description gen-res]
   (generate-doc title description gen-res ""))
  ([title description gen-res attach-class]
   (let [classes (get-class-names gen-res)]
     [:div
      [:h4.mik-cut-bottom.mik-fw-2 title]
      [:p.mik-cut-top.mik-cut-bottom.mik-tiny-container
       description]
      [:div.mik-tiny-container.mik-pad-0.mik-margin-0.mik-shadow
       (make-demo attach-class classes )]])))

(def ratio-scale
  (str "[" (clojure.string/join ", " (map styles/ratio (range 7))) "]"))

(def datum
  [:div
   (generate-doc
    "Cut padding and margin of an element"
    "Useful when you want to put element near to each other"
    (styles/p-cut-specified) " mik-margin-0 mik-pad-0")
   
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
    "Containers (default small and tiny)"
    "These behave similar to Bootstrap's container class"
    (styles/p-containers)  )
   
   (generate-doc
    "Justify single line"
    ""
    (styles/p-line-justify))
   
   (generate-doc
    "Add shadow to the element"
    ""
    (styles/p-shadow)  )
   (generate-doc
    "Make border square"
    ""
    (styles/p-square-border))

   (generate-doc
    "Padded|Margin as button"
    "Will pad or add margins as in button"
    (styles/p-as-button-specificed))])
