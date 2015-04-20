(ns midi.soundfont
  (:require [clojure.java.io :as io]
            [boot.core])
  (:import (javax.sound.midi MidiSystem)))

(defn load-all-instruments!
  "Loads all of the instruments from a soundfont (.sf2 file handle) into a MIDI
   synthesizer.

   Can accept either a file handle or a string representing the path to one."
  [synth sf2-file]
  (let [sf2-file (if (instance? java.io.File sf2-file)
                   sf2-file
                   (io/file sf2-file))]
    (.unloadAllInstruments synth (.getDefaultSoundbank synth))
    (.loadAllInstruments synth (MidiSystem/getSoundbank sf2-file))))
