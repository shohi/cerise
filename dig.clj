#!/usr/bin/env bb
;; -*- mode: clojure; -*-

;; TOD0

;; refer, https://github.com/clojure-cookbook/clojure-cookbook/blob/master/05_network-io/5-03_sending-a-ping-request.asciidoc
;; NOTE: not work
(defn timed-ping
  "Time an .isReachable ping to a given domain"
  [domain timeout]
  (let [addr (java.net.InetAddress/getByName domain)
        start (. System (nanoTime))
        result (.isReachable addr timeout)
        total (/ (double (- (. System (nanoTime)) start)) 1000000.0)]
    {:time total
     :result result}))

;; +short only show A records
(def c (:out (shell/sh "dig" "+short" "@1.0.0.1" "yahoo.com")))
(def ip-pattern #"^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$")

(defn get-ip
  "domain ip look up and return host record"
  [dns domain]
  (let [c (:out (shell/sh "dig" "+short" dns domain))
        lines (str/split c #"\n")
        ips (filter #(re-matches ip-pattern %) lines)]
    (for [ip ips]
      (str domain "\t" ip))))

(defn ip-ping
  "ping given ip address"
  [ip]
  (:out (shell/sh "ping" "-c" "3" ip)))

(defn parse-ping-stat
  [])

(comment

  (def lines (str/split c #"\n"))
  (re-matches ip-pattern c)
  ;; match
  (re-matches ip-pattern "1.0.0.1")

  ;; not match
  (re-matches ip-pattern "1.0.0.1.")

  (str/split c #"\n")
  (re-find #"(?is).*ANSWER SECTION:(.*?);; QUERY time" c)
  (count (re-matches #"(?is).*ANSWER SECTION:(.*?);; QUERY time.*" c))

  )
