(ns greedy-algorithms.schedule-events-test
  (:use expectations)
  (:require [greedy-algorithms.schedule-events :refer :all]))

;; coin-change

;; test-case-1
;; (expect
;;  (coin-change 48 [1 2 5 10 20])
;;  [1 2 5 20 20])

(defn to-mins [xs]
  {
   :start  (+ (* (nth xs 0) 60) (nth xs 1))
   :finish (+ (* (nth xs 2) 60) (nth xs 3))
   })

(let [events (map to-mins
                  [[10 00 18 30]
                   [12 15 13 00]
                   [12 30 16 30]
                   [15 00 18 00]
                   [18 00 20 45]])
      expected [(nth events 1)
                (nth events 3)
                (nth events 4)]]

  (expect expected (schedule-events events)))

(let [events (map to-mins
                  [[12 15 13 15]
                   [15 00 18 00]
                   [10 00 13 00]
                   [18 00 20 45]
                   [12 30 16 30]])
      expected [(nth events 2)
                (nth events 1)
                (nth events 3)]]

  (expect expected (schedule-events events)))

(let [events (map to-mins
                  [[10 00 11 30]
                   [10 00 13 00]
                   [11 30 13 15]
                   [12 00 18 00]
                   [18 00 20 45]
                   [12 30 16 30]])
      expected [(nth events 0)
                (nth events 2)
                (nth events 4)]]

  (expect expected (schedule-events events)))


(let [events (map to-mins
                  [[10 00 11 30]
                   [17 00 20 30]
                   [17 00 19 00]
                   [18 00 19 05]
                   [19 03 19 20]
                   [10 00 13 00]])
      expected [(nth events 0)
                (nth events 2)
                (nth events 4)]]

  (expect expected (schedule-events events)))
