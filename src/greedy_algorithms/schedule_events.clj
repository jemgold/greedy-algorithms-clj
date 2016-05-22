(ns greedy-algorithms.schedule-events
  (:gen-class))

(defn overlaps [a b]
  (not (<= (:finish b)
           (:start a))))

(defn schedule-events
  ([inbox] (schedule-events (sort-by :finish inbox) []))
  ([inbox cal]
   (if (empty? inbox)
     cal
     (let [next (first inbox)
           last-sched (last cal)]
       (println "next: " next)
       (println "last: " last-sched)

       (if (empty? cal)
         (recur (rest inbox) (conj cal next))

         (if (overlaps next last-sched)
           (recur (rest inbox) cal)
           (recur (rest inbox) (conj cal next))))))))
