(ns midi.soundfont
  (:require [clojure.java.io :as io])
  (:import (javax.sound.midi MidiSystem Synthesizer)))

(defprotocol Soundbank
  (soundbank-of [x]))

(extend-protocol Soundbank
  Object
  (soundbank-of [☠]
    (throw (Exception.
             (format "Expected a File, InputStream, or Soundbank; got %s"
                     (type ☠)))))

  java.io.File
  (soundbank-of [sf] (MidiSystem/getSoundbank sf))

  java.io.InputStream
  (soundbank-of [sf] (MidiSystem/getSoundbank sf))

  javax.sound.midi.Soundbank
  (soundbank-of [sb] sb))

(defn load-all-instruments!
  "Loads all of the instruments from a soundbank or soundfont into a MIDI
   synthesizer.

   `src` may be either an existing (i.e. pre-evaluated) soundbank, or a
   supported soundfont (i.e. a DLS or SF2 file) in the form of a File or
   an InputStream."
  [^Synthesizer synth src]
  (doto synth
    (.open); open synth, in case it isn't open already
    (.unloadAllInstruments (.getDefaultSoundbank synth))
    (.loadAllInstruments (soundbank-of src))))

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

