(ns greedy-algorithms.coin-change-test
  (:use expectations)
  (:require [greedy-algorithms.coin-change :refer :all]))

;; coin-change

;; test-case-1
(expect
 (coin-change 48 [1 2 5 10 20])
 [1 2 5 20 20])

;; test-case-2
(expect
 (coin-change 48 [10 5 1])
 [1 1 1 5 10 10 10 10])

;; test-case-3
(expect
 (coin-change 20000 [1])
 (repeat 20000 1))

;; test-case-4
;; returns an empty list if impossible
(expect
 (coin-change 20 [7])
 [])

;; test-case-5
;; returns an empty list if impossible
(expect
 (coin-change 289 [7 3 5 10 50 19])
 [])
