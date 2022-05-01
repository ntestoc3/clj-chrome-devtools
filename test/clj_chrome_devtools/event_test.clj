(ns clj-chrome-devtools.event-test
  (:require  [clojure.test :as t]
             [clj-chrome-devtools.impl.connection :as ccd]
             [clj-chrome-devtools.events :as cce]
             [clj-chrome-devtools.commands.network :as ccn]))

(comment
  (def c (ccd/connect))

  (ccn/enable c {})

  (def last-v (atom []))

  (defn prn-event-2 [{:keys [domain event params]}]
    (println :event event)
    (when (= "XHR" (:type params))
      (let [body (ccn/get-response-body c (select-keys params [:request-id]))]
        (swap! last-v conj (assoc params :body (:body body)))))
    (try (println :id (:request-id params)
                  :url (get-in params [:response :url])
                  :mime-type (get-in params [:response :mime-type])
                  :url (get-in params [:response :url])
                  :ip (get-in params [:response :remote-ip-address])
                  )
         (catch Exception e
           (println e)))
    )

  (reset! (:event-listeners c) {})

  (cce/listen c :network :response-received prn-event-2)

  )




