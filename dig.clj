#!/usr/bin/env bb

;; TODO
;; +short only show A records
(def c (:out (shell/sh "dig" "+short" "@1.0.0.1" "yahoo.com")))
(def ip-pattern #"^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$")


(defn get-ip
  "domain ip look up and return host record"
  [dns domain]
  (let [c (:out (shell/sh "dig" "+short" "@1.0.0.1" "yahoo.com"))]
    (if (empty? c))
    )
  )

(comment

  (re-matches ip-pattern c)
  ;; match
  (re-matches ip-pattern "1.0.0.1")

  ;; not match
  (re-matches ip-pattern "1.0.0.1.")

  (str/split c #"\n")
  (re-find #"(?is).*ANSWER SECTION:(.*?);; QUERY time" c)
  (count (re-matches #"(?is).*ANSWER SECTION:(.*?);; QUERY time.*" c))

  )
