(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.6.0"]
                 [adzerk/bootlaces "0.1.11" :scope "test"]])

(require '[adzerk.bootlaces :refer :all])

(def +version+ "0.1.0")
(bootlaces! +version+)

(task-options!
  pom {:project 'midi.soundfont
       :version +version+
       :description "A library for loading MIDI soundfonts into the JVM"
       :url "https://github.com/daveyarwood/midi.soundfont"
       :scm {:url "https://github.com/daveyarwood/midi.soundfont"}
       :license {"name" "Eclipse Public License"
                 "url" "http://www.eclipse.org/legal/epl-v10.html"}})
