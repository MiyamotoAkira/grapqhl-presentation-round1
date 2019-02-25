(ns base-sample.service
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [io.pedestal.http.body-params :as body-params]
            [ring.util.response :as ring-resp]
            [base-sample.schema :as schema]
            [com.walmartlabs.lacinia.pedestal :as lp]))



(def compiled-schema (schema/load-schema))

;; Consumed by base-sample.server/create-server
;; See http/default-interceptors for additional options you can configure
(def service (-> compiled-schema
                 (lp/service-map {:graphiql true
                                  :port 8080})))

