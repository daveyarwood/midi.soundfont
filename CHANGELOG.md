# CHANGELOG

## 0.1.1

* `load-all-instruments!` can now optionally take an already-obtained reference to a javax.sound.midi.Soundbank in the place of a soundfont file.

## 0.1.0

* Initial release
* `load-all-instruments!` loads all instruments from a MIDI soundfont (provided as a File or InputStream) into a javax.sound.midi.Synthesizer.
* `load-patch` and `midi-test` functions provided for testing purposes.
