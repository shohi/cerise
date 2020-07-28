#!/usr/bin/env bb

(def ignore-list ["baidunetdisk"])

;; TODO: check shell status
(defn get-outdated-list
  "get outdated brew list"
  []
  (let [out (:out (apply shell/sh ["brew" "outdated"]))]
    (str/split out #"\n")
    ))

(defn get-update-list
  "update list excluding the ones in ignore list"
  []
  (let [all (get-outdated-list)]
    ;; TODO: return diff
    )
  )

;; TODO: check shell status
(defn daily-routine
  "daily routine
  - brew update & brew upgrade
  "
  []
  )

(comment
  (prn (:out (apply shell/sh ["brew" "update"])))
  (prn (get-outdated-list))
  (prn (:out (shell/sh "brew" "outdated")))
  (println "hello\n")
 )
