(ns midi.soundfont
  (:require [clojure.java.io :as io])
  (:import (javax.sound.midi MidiSystem Synthesizer)))

(defn load-all-instruments!
  "Loads all of the instruments from a soundfont into a MIDI synthesizer.

   `soundfont` must be a supported soundfont (i.e. a DLS or SF2 file), 
    as either a File or an InputStream."
  [^Synthesizer synth soundfont]
  (.open synth) ; open synth, in case it isn't open already
  (.unloadAllInstruments synth (.getDefaultSoundbank synth))
  (.loadAllInstruments synth (MidiSystem/getSoundbank soundfont)))

;;; for testing purposes ;;;

(defn load-patch [^Synthesizer synth patch-number]
  (let [channel (first (.getChannels synth))]
    (.programChange channel (dec patch-number))))

(defn midi-test [^Synthesizer synth]
  (let [channel (first (.getChannels synth))
        demo-notes [43 47 50 55 59 62 67 71 74 79]]
    (doseq [note demo-notes]
      (. channel noteOn note 127)
      (Thread/sleep 250)
      (. channel noteOff note))))   

