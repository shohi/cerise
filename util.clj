#!/usr/bin/env bb

(use 'clojure.data)

(def ignore-list ["baidunetdisk"])

;; TODO: check shell status
(defn get-brew-outdated-list
  "get outdated brew list"
  []
  (let [out (:out (shell/sh "brew" "outdated"))]
    (str/split out #"\n")
    ))

(defn get-brew-upgrade-list
  "get upgrade list excluding the ones in ignore list"
  []
  (let [all (get-brew-outdated-list)
        items (first (diff all ignore-list))]

    (into [] (remove nil? items))))

(defn do-brew-upgrade
  "run brew upgrade"
  []
  (let [items (get-brew-upgrade-list)]
    (do
      (println "upgrade brew:" items)

      (for [t items]
        (do
          (println "brew upgrade" t)
          (println (:out (shell/sh "brew" "upgrade" t)))
          (println "brew upgrade done!"))))))

;; TODO: check shell status
(defn daily-routine
  "daily routine
  - brew update & brew upgrade
  "
  []
  (do
    (do-brew-upgrade)
    ))

(defn main
  "main entry"
  [args]
  (daily-routine))

(main *command-line-args*)

(comment
  (prn (:out (apply shell/sh ["brew" "update"])))
  (prn (get-brew-upgrade-list))
  (prn (:out (shell/sh "brew" "outdated")))
  (println "hello\n")
 )
